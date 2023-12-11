package edu.project3;

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogReader {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int BUFFER_CAPACITY = 48;

    private LogReader() {
    }

    static List<Log> read(Path path) {
        LogCreator creator = new LogCreator();
        try (ReadableByteChannel inChannel = FileChannel.open(path)) {
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_CAPACITY);
            int bytesRead = inChannel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    creator.createLogs((char) buffer.get());
                }
                buffer.clear();
                bytesRead = inChannel.read(buffer);
            }
        } catch (IOException e) {
            LOGGER.info("No file found");
        }
        return creator.getLogList();
    }

    static List<Log> read(URI uri) {
        LogCreator creator = new LogCreator();
        try (ReadableByteChannel inChannel = Channels.newChannel(uri.toURL().openStream())) {
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_CAPACITY);
            int bytesRead = inChannel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    creator.createLogs((char) buffer.get());
                }
                buffer.clear();
                bytesRead = inChannel.read(buffer);
            }
        } catch (IOException e) {
            LOGGER.info("No url found");
        }
        return creator.getLogList();
    }
}
