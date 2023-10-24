package edu.project1;

import java.util.TreeSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameHangman {
    private final static Logger LOGGER = LogManager.getLogger();

    private String word;
    private final char[] playersWord;
    private boolean gameIsRunning = true;
    private final TreeSet<Character> setOfCharsNeededToGuess;
    private String result;

    public GameHangman(String dictionaryFile) {
        Dictionary dictionary = new Dictionary(dictionaryFile);
        setOfCharsNeededToGuess = new TreeSet<>();
        word = dictionary.chooseRandomWord();
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != '-') {
                setOfCharsNeededToGuess.add(word.charAt(i));
            }
        }
        playersWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '-') {
                playersWord[i] = '-';
            } else {
                playersWord[i] = '*';
            }
        }
    }

    public boolean takeAGuess(char guess) {
        if (word.indexOf(guess) != -1) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    playersWord[i] = guess;
                }
            }
            setOfCharsNeededToGuess.remove(guess);
            return true;
        }
        return false;
    }

    public String gameState() {
        String string = new String(playersWord);
        LOGGER.info(string);
        if (setOfCharsNeededToGuess.isEmpty()) {
            youWon();
        }
        return string;
    }

    public void gameOver() {
        LOGGER.info("Игра окончена! Вы проиграли");
        LOGGER.info("Было загадано слово: " + word);
        gameIsRunning = false;
        result = "Last game was lost";
    }

    public void youWon() {
        LOGGER.info("Поздравляем! Вы победили");
        gameIsRunning = false;
        result = "Last game was won";
    }

    public boolean checkIfGameIsRunning() {
        return gameIsRunning;
    }

    public String getResult() {
        return result;
    }
}
