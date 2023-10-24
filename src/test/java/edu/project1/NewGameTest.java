package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class NewGameTest {
    @Test
    @DisplayName("Одна правильная догадка, 5 неправильных")
    void oneRightGuess() {
        // given
        Player player = new Player();
        GameHangman newGame = new GameHangman("exampleWord.txt");
        String[] guesses = {"о", "ц", "к", "е", "н", "ш"};
        int i = 0;

        // when
        while (newGame.checkIfGameIsRunning() && player.checkIfWantsToPlay()) {
            player.makeATurn(newGame, guesses[i]);
            i++;
        }

        // then
        assertThat(newGame.getResult()).isEqualTo("Last game was lost");
    }

    @Test
    @DisplayName("Неправильные догадки")
    void allGuessesAreIncorrect() {
        // given
        Player player = new Player();
        GameHangman newGame = new GameHangman("exampleWord.txt");
        String[] guesses = {"щ", "ц", "к", "е", "н"};
        int i = 0;

        // when
        while (newGame.checkIfGameIsRunning() && player.checkIfWantsToPlay()) {
            player.makeATurn(newGame, guesses[i]);
            i++;
        }

        // then
        assertThat(newGame.getResult()).isEqualTo("Last game was lost");
    }

    @Test
    @DisplayName("Правильные догадки")
    void allGuessesAreCorrect() {
        // given
        Player player = new Player();
        GameHangman newGame = new GameHangman("exampleWord.txt");
        String[] guesses = {"й", "у", "г", "р", "т", "о"};
        int i = 0;

        // when
        while (newGame.checkIfGameIsRunning() && player.checkIfWantsToPlay()) {
            player.makeATurn(newGame, guesses[i]);
            newGame.gameState();
            i++;
        }

        // then
        assertThat(newGame.getResult()).isEqualTo("Last game was won");
    }
    @Test
    @DisplayName("Не угадали одну букву")
    void almostWon() {
        // given
        Player player = new Player();
        GameHangman newGame = new GameHangman("exampleWord.txt");
        String[] guesses = {"й", "у", "г", "р", "ц", "о", "е", "н", "ш", "щ"};
        int i = 0;

        // when
        while (newGame.checkIfGameIsRunning() && player.checkIfWantsToPlay()) {
            player.makeATurn(newGame, guesses[i]);
            newGame.gameState();
            i++;
        }

        // then
        assertThat(newGame.getResult()).isEqualTo("Last game was lost");
    }

    @Test
    @DisplayName("Выход из игры")
    void quitAGame() {
        // given
        Player player = new Player();
        GameHangman newGame = new GameHangman("exampleWord.txt");
        String[] guesses = {"й", "ц", "-"};
        int i = 0;

        // when
        while (newGame.checkIfGameIsRunning() && player.checkIfWantsToPlay()) {
            player.makeATurn(newGame, guesses[i]);
            newGame.gameState();
            i++;
        }

        // then
        assertFalse(player.checkIfWantsToPlay());
    }
}
