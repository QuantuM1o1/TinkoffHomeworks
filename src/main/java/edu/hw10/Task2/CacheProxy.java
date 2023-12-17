package edu.hw10.Task2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cache = new HashMap<>();
    private static final String PATH_TO_CACHE = "src/main/resources/hw10/123.txt";

    private CacheProxy(Object target) {
        this.target = target;
        Path path = Paths.get(PATH_TO_CACHE);
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't delete the file");
        }
    }

    public static <T> T create(Object target, Class<?> interfaceClass) {
        return (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class<?>[]{interfaceClass},
            new CacheProxy(target)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class)) {
            String key = method.getName() + Arrays.toString(args);
            if (cache.containsKey(key)) {
                return cache.get(key);
            } else {
                Object result = method.invoke(target, args);
                cache.put(key, result);
                if (method.getAnnotation(Cache.class).persist()) {
                    writeToFile(key, result);
                }
                return result;
            }
        } else {
            return method.invoke(target, args);
        }
    }

    private void writeToFile(String key, Object result) {
        Path path = Paths.get(PATH_TO_CACHE);
        try (BufferedWriter writer
                 = Files.newBufferedWriter(path, StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            writer.write(key + ":" + result);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
