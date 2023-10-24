package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DictionaryTest {
    @Test
    @DisplayName("Проверка на выдачу слов")
    void wordCheck()
    {
        // given
        Dictionary dictionary = new Dictionary("words.txt");

        // when
        String answer = dictionary.chooseRandomWord();

        // then
        assertThat(answer).isNotNull();
    }

    @Test
    @DisplayName("Проверка на некорректные строки")
    void checkSpaces()
    {
        // given
        Dictionary dictionary = new Dictionary("wordsSpaces.txt");

        // when
        String answer = dictionary.chooseRandomWord();

        // then
        assertThat(answer).isEqualTo("словарь");
    }

    @Test
    @DisplayName("Проверка на отсутствие файла")
    void noFile()
    {
        // given
        // file that doesn't exist in repo
        Dictionary dictionary = new Dictionary("word.txt");

        // when
        String answer = dictionary.chooseRandomWord();

        // then
        assertThat(answer).isEqualTo("словарь");
    }

    @Test
    @DisplayName("Проверка на слово короче трёх букв")
    void shortWord()
    {
        // given
        Dictionary dictionary = new Dictionary("shortWord.txt");

        // when
        String answer = dictionary.chooseRandomWord();

        // then
        assertThat(answer).isEqualTo("словарь");
    }
}
