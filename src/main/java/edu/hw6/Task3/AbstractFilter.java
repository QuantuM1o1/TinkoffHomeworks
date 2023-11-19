package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    @Override
    boolean accept(Path entry) throws IOException;

    default AbstractFilter and(AbstractFilter other) {
        return entry -> AbstractFilter.this.accept(entry) && other.accept(entry);
    }

    AbstractFilter REGULAR_FILE = Files::isRegularFile;
    AbstractFilter READABLE = Files::isReadable;
    AbstractFilter WRITABLE = Files::isWritable;
    AbstractFilter EXECUTABLE = Files::isExecutable;
    AbstractFilter HIDDEN = Files::isHidden;

    static AbstractFilter largerThan(long size) {
        return entry -> Files.size(entry) > size;
    }

    static AbstractFilter lessThan(long size) {
        return entry -> Files.size(entry) < size;
    }

    static AbstractFilter sizeIs(long size) {
        return entry -> Files.size(entry) == size;
    }

    static AbstractFilter globMatches(String glob) {
        return entry -> entry.getFileName().toString().matches("." + glob);
    }

    static AbstractFilter regexContains(String regex) {
        return entry -> entry.getFileName().toString().matches(".*" + regex + ".*");
    }

    static AbstractFilter magicNumber(int... magicBytes) {
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
