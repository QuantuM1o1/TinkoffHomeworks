package edu.hw6.Task1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private static final int BUFFER_CAPACITY = 48;
    private static final String MESSAGE_IF_FILE_WAS_NOT_FOUND = "File not found";
    private final static Logger LOGGER = LogManager.getLogger();
    private final Path mainDirectory;
    private final String stringDirectory;
    private int size;

    public DiskMap(String mainDirectory) {
        this.mainDirectory = Paths.get(mainDirectory);
        stringDirectory = mainDirectory;
        this.clear();
        this.size = 0;
    }

    public DiskMap(String mainDirectory, Path downloadFile) {
        this.mainDirectory = Paths.get(mainDirectory);
        stringDirectory = mainDirectory;
        this.clear();
        this.downloadFromFile(downloadFile);
    }

    private List<String> parseString(String stringToParse) {
        Pattern pattern = Pattern.compile("^(\\w+):(\\w+)$");
        Matcher matcher;
        matcher = pattern.matcher(stringToParse);
        if (matcher.find()) {
            List<String> keyValue = new ArrayList<>();
            keyValue.add(matcher.group(1));
            keyValue.add(matcher.group(2));
            return keyValue;
        }
        return Collections.emptyList();
    }

    private List<Path> findPathList() {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + stringDirectory + "*");
        Path sourcePath = Paths.get("src/");
        try (Stream<Path> paths = Files.find(sourcePath, Integer.MAX_VALUE, (path, f) -> pathMatcher.matches(path))) {
            return paths.toList();
        } catch (IOException e) {
            LOGGER.info("No files in path");
            return Collections.emptyList();
        }
    }

    private String readFile(Path path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (ReadableByteChannel inChannel = FileChannel.open(path)) {
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_CAPACITY);
            int bytesRead = inChannel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    char c = (char) buffer.get();
                    stringBuilder.append(c);
                }
                buffer.clear();
                bytesRead = inChannel.read(buffer);
            }
        } catch (IOException e) {
            LOGGER.info(MESSAGE_IF_FILE_WAS_NOT_FOUND);
        }
        return stringBuilder.toString();
    }

    public void saveToFile(Path path) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String key : this.keySet()) {
                writer.write(key + ":" + this.get(key));
                writer.newLine();
            }
        } catch (IOException e) {
            LOGGER.info(MESSAGE_IF_FILE_WAS_NOT_FOUND);
        }
    }

    public void downloadFromFile(Path path) {
        String fullFile = this.readFile(path);
        String[] strings = fullFile.split(System.lineSeparator());
        for (String string : strings) {
            List<String> keyValue = parseString(string);
            this.put(keyValue.get(0), keyValue.get(1));
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Path path = Paths.get(this.mainDirectory + "/" + key);
        return Files.isReadable(path);
    }

    @Override
    public boolean containsValue(Object value) {
        List<Path> pathList = this.findPathList();
        for (Path path : pathList) {
            String string = this.readFile(path);
            List<String> keyValue = parseString(string);
            if (Objects.equals(keyValue.get(1), value.toString())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String get(Object key) {
        if (!this.containsKey(key)) {
            return null;
        }
        Path path = Paths.get(this.mainDirectory + "/" + key);
        String string = this.readFile(path);
        List<String> keyValue = parseString(string);
        return keyValue.get(1);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        String oldValue = null;
        if (!this.containsKey(key)) {
            oldValue = this.get(key);
        }
        Path path = Paths.get(this.mainDirectory + "/" + key);
        if (!Files.isWritable(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                LOGGER.info("Couldn't create a file");
            }
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(key + ":" + value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        size++;
        return oldValue;
    }

    @Override
    public String remove(Object key) {
        String oldValue = null;
        if (this.containsKey(key)) {
            oldValue = this.get(key);
        }
        Path path = Paths.get(this.mainDirectory + "/" + key);
        try {
            Files.delete(path);
        } catch (IOException ignored) {
        }
        size--;
        return oldValue;
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        for (Map.Entry<? extends String, ? extends String> e : m.entrySet()) {
            this.put(e.getKey(), e.getValue());
        }
    }

    @Override
    public void clear() {
        for (Object key : this.keySet()) {
            remove(key);
        }
        size = 0;
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        Set<String> set = new HashSet<>();
        List<Path> pathList = this.findPathList();
       for (Path path : pathList) {
            String string = this.readFile(path);
            List<String> keyValue = parseString(string);
            set.add(keyValue.getFirst());
        }
        return set;
    }

    @NotNull
    @Override
    public Collection<String> values() {
        List<String> list = new ArrayList<>();
        List<Path> pathList = this.findPathList();
        for (Path path : pathList) {
            String string = this.readFile(path);
            List<String> keyValue = parseString(string);
            list.add(keyValue.get(1));
        }
        return list;
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        Set<Entry<String, String>> entries = new HashSet<>();
        List<Path> pathList = this.findPathList();
        for (Path path : pathList) {
            String string = this.readFile(path);
            List<String> keyValue = parseString(string);
            Map.Entry<String, String> entry = new AbstractMap.SimpleEntry<>(keyValue.get(0), keyValue.get(1));
            entries.add(entry);
        }
        return entries;
    }
}
