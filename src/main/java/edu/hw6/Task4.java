package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task4() {
    }

    @SuppressWarnings("NestedTryDepth")
    public static void streams(Path path) {
        try (OutputStream outputStream = Files.newOutputStream(path)) {
            Checksum checksum = new Adler32();
            try (CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, checksum)) {
                try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream)) {
                    try (OutputStreamWriter outputStreamWriter
                             = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8)) {
                        try (PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {
                            printWriter.print("Programming is learned by writing programs. ― Brian Kernighan");
                        }
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.info("File wasn't found");
        }
    }
}
