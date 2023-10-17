package edu.project1;

import java.util.Scanner;
import java.util.TreeSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int MAXIMUM_OF_AVAILABLE_GUESSES = 5;
    private int availableGuesses;
    private final TreeSet<Character> setOfGuesses;
    private boolean wantsToPlay;

    public Player() {
        availableGuesses = MAXIMUM_OF_AVAILABLE_GUESSES;
        setOfGuesses = new TreeSet<>();
        wantsToPlay = true;
    }

    public void makeATurn(GameHangman currentGame, String guess) {
        if (guess.equals("-")) {
            wantsToPlay = false;
            return;
        }
        char guessChar = guess.charAt(0);
        guessChar = Character.toLowerCase(guessChar);
        setOfGuesses.add(guessChar);
        if (!currentGame.takeAGuess(guessChar)) {
            availableGuesses--;
        }
        LOGGER.info("Оставшееся количество ошибок: " + availableGuesses);
        if (availableGuesses == 0) {
            currentGame.gameOver();
        }
    }

    public boolean checkIfWantsToPlay() {
        return wantsToPlay;
    }

    public String input() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Введите букву: ");
        return scanner.next();
    }

    public boolean validateInput(String guess) {
        if (guess.length() == 1) {
            char choice = guess.charAt(0);
            return ((Character.UnicodeBlock.of(choice).equals(Character.UnicodeBlock.CYRILLIC) || choice == '-')
                && !setOfGuesses.contains(choice));
        }
        return false;
    }
}
