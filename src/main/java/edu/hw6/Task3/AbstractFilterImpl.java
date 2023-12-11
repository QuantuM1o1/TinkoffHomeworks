package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AbstractFilterImpl implements AbstractFilter {
    private final AbstractFilter filter;

    public AbstractFilterImpl(AbstractFilter filter) {
        this.filter = filter;
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return filter != null && filter.accept(entry);
    }

    public static AbstractFilter regularFile = Files::isRegularFile;

    public static AbstractFilter readable = Files::isReadable;

    public static AbstractFilter writable = Files::isWritable;

    public static AbstractFilter executable = Files::isExecutable;

    public static AbstractFilter hidden = Files::isHidden;

    public static AbstractFilter largerThan(long size) {
        return entry -> Files.size(entry) > size;
    }

    public static AbstractFilter lessThan(long size) {
        return entry -> Files.size(entry) < size;
    }

    public static AbstractFilter sizeIs(long size) {
        return entry -> Files.size(entry) == size;
    }

    public static AbstractFilter globMatches(String glob) {
        return entry -> entry.getFileName().toString().matches("." + glob);
    }

    public static AbstractFilter regexContains(String regex) {
        return entry -> entry.getFileName().toString().matches(".*" + regex + ".*");
    }

    public static AbstractFilter magicNumber(int... magicBytes) {
        return entry -> {
            byte[] fileBytes = Files.readAllBytes(entry);
            if (fileBytes.length < magicBytes.length) {
                return false;
            }
            for (int i = 0; i < magicBytes.length; i++) {
                if ((byte) magicBytes[i] != fileBytes[i]) {
                    return false;
                }
            }
            return true;
        };
    }
}
