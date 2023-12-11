package edu.hw6;

import edu.hw6.Task1.DiskMap;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    @Test
    @DisplayName("Тест добавления значений")
    void putInMap() {
        // given
        String path = "src/main/resources/hw6/Task1/";
        DiskMap diskMap = new DiskMap(path);
        diskMap.put("key", "value");

        // when
        String answer = diskMap.get("key");

        // then
        assertFalse(diskMap.isEmpty());
        assertThat(answer).isEqualTo("value");
        assertThat(diskMap.size()).isEqualTo(1);
    }


    @Test
    @DisplayName("Тест удаления значений")
    void deleteFromMap() {
        // given
        String path = "src/main/resources/hw6/Task1/";
        DiskMap diskMap = new DiskMap(path);
        diskMap.put("key", "value");
        diskMap.put("key1", "value1");
        diskMap.put("key12", "value12");

        // when
        String answer = diskMap.remove("key");

        // then
        assertFalse(diskMap.isEmpty());
        assertThat(answer).isEqualTo("value");
        assertThat(diskMap.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Тест сохранения в файл")
    void saveOnDisk() {
        // given
        String path = "src/main/resources/hw6/Task1/";
        DiskMap diskMap = new DiskMap(path);
        diskMap.put("key", "value");
        diskMap.put("key1", "value1");
        diskMap.put("key12", "value12");
        String savePathString = "src/main/resources/hw6/Task1_2.txt";

        // when
        Path savePath = Paths.get(savePathString);
        diskMap.saveToFile(savePath);
        String answer = readFile(savePath);

        // then
        assertFalse(diskMap.isEmpty());
        assertThat(diskMap.size()).isEqualTo(3);
        assertThat(answer).contains("key:value");
        assertThat(answer).contains("key1:value1");
        assertThat(answer).contains("key12:value12");
    }

    @Test
    @DisplayName("Тест загрузки из файла")
    void downloadFromDisk() {
        // given
        String path = "src/main/resources/hw6/Task1/";
        DiskMap diskMap = new DiskMap(path);
        Path downloadPath = Paths.get("src/main/resources/hw6/Task1_1.txt");

        // when
        diskMap.downloadFromFile(downloadPath);
        diskMap.put("key", "value");

        // then
        assertFalse(diskMap.isEmpty());
        assertThat(diskMap.size()).isEqualTo(3);
        assertTrue(diskMap.containsKey("key"));
        assertTrue(diskMap.containsKey("abc"));
        assertTrue(diskMap.containsKey("first"));
    }

    @Test
    @DisplayName("Тест конструктора с загрузкой из файла")
    void constructorWithDonwload() {
        // given
        String path = "src/main/resources/hw6/Task1/";
        Path downloadPath = Paths.get("src/main/resources/hw6/Task1_1.txt");
        DiskMap diskMap = new DiskMap(path, downloadPath);

        // when
        diskMap.put("key", "value");

        // then
        assertFalse(diskMap.isEmpty());
        assertThat(diskMap.size()).isEqualTo(3);
        assertTrue(diskMap.containsValue("value"));
        assertTrue(diskMap.containsValue("bcd"));
        assertTrue(diskMap.containsValue("valueFirst"));
    }

    @Test
    @DisplayName("Метод putAll")
    void checkingPutAll() {
        // given
        String path = "src/main/resources/hw6/Task1/";
        DiskMap diskMap = new DiskMap(path);
        Map<String, String> map = new HashMap<>();

        // when
        diskMap.put("key", "value");
        map.put("mapKey", "mapValue");
        map.put("someKey", "someValue");
        diskMap.putAll(map);


        // then
        assertThat(diskMap.size()).isEqualTo(3);
        assertTrue(diskMap.containsValue("value"));
        assertTrue(diskMap.containsValue("mapValue"));
        assertTrue(diskMap.containsValue("someValue"));
    }

    @Test
    @DisplayName("Тест метода values()")
    void checkingValues() {
        // given
        String path = "src/main/resources/hw6/Task1/";
        DiskMap diskMap = new DiskMap(path);
        diskMap.put("key", "value");
        diskMap.put("key1", "value1");
        diskMap.put("key12", "value12");

        // when
        Collection<String> answer = diskMap.values();

        // then
        assertFalse(diskMap.isEmpty());
        assertThat(answer.size()).isEqualTo(3);
        assertThat(diskMap.size()).isEqualTo(3);
        assertTrue(answer.contains("value"));
        assertTrue(answer.contains("value1"));
        assertTrue(answer.contains("value12"));
    }

    @Test
    @DisplayName("Тест метода entrySet()")
    void checkingEntries() {
        // given
        String path = "src/main/resources/hw6/Task1/";
        DiskMap diskMap = new DiskMap(path);
        diskMap.put("key", "value");
        diskMap.put("key1", "value1");
        diskMap.put("key12", "value12");

        // when
        Set<Map.Entry<String, String>> answer = diskMap.entrySet();

        // then
        assertFalse(diskMap.isEmpty());
        assertThat(answer.size()).isEqualTo(3);
        assertThat(diskMap.size()).isEqualTo(3);
        assertTrue(answer.contains(Map.entry("key", "value")));
        assertTrue(answer.contains(Map.entry("key1", "value1")));
        assertTrue(answer.contains(Map.entry("key12", "value12")));
    }

    private String readFile(Path path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (ReadableByteChannel inChannel = FileChannel.open(path)) {
            ByteBuffer buffer = ByteBuffer.allocate(48);
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
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
