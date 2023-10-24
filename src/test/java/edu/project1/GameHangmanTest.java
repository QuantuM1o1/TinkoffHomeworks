package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameHangmanTest
{
    @Test
    @DisplayName("Проверка на выдачу слов")
    void wordCheck()
    {
        // given
        GameHangman gameHangman = new GameHangman("exampleWord.txt");

        // when
        String answer = gameHangman.gameState();

        // then
        // слово тестирование
        assertThat(answer).isEqualTo("******");
    }

    @Test
    @DisplayName("Проверка на выдачу слов c дефисами")
    void wordWithHyphenCheck()
    {
        // given
        GameHangman gameHangman = new GameHangman("wordsWithHyphen.txt");

        // when
        String answer = gameHangman.gameState();

        // then
        // слово теле-пресс-конференция
        assertThat(answer).isEqualTo("****-*****-***********");
    }
}
