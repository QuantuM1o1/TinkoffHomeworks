package edu.project1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dictionary {
    private final static Logger LOGGER = LogManager.getLogger();
    private static final String DEFAULT_WORD = "словарь";
    private static final int MIN_WORD_LENGTH = 3;
    private static List<String> dictionary;

    public Dictionary(String txtForDictionary) {
        dictionary = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        int c;
        try (FileReader fr = new FileReader("src/main/resources/project1/" + txtForDictionary)) {
            while ((c = fr.read()) != -1) {
                if (c == '\r') {
                    continue;
                }
                if (c == '\n') {
                    dictionary.add(str.toString());
                    str.setLength(0);
                } else {
                    str.append((char) c);
                }
            }
            if (!str.toString().isEmpty()) {
                dictionary.add(str.toString());
            }
        } catch (IOException e) {
            LOGGER.info("Проверьте наличие файлов словаря!");
            dictionary.add(DEFAULT_WORD);
        }
    }

    public String chooseRandomWord() {
        Random random = new Random();
        int r = random.nextInt();
        if (r < 0) {
            r = -r;
        }
        String answer = dictionary.get(r % dictionary.size());
        if (!answer.matches("[А-яЁё][-А-яЁё]+") || answer.length() < MIN_WORD_LENGTH) {
            LOGGER.info("Проверьте словарь!");
            answer =  DEFAULT_WORD;
        }
        return answer;
    }
}
