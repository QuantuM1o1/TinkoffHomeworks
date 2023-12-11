package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    @Override
    boolean accept(Path entry) throws IOException;

    default AbstractFilter and(AbstractFilter other) {
        return entry -> AbstractFilter.this.accept(entry) && other.accept(entry);
    }
}
