package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NewGame {
    private final static Logger LOGGER = LogManager.getLogger();

    private NewGame() {
    }

    public static void playAGame() {
        char playAgain = 'н';
        do {
            Player player = new Player();
            GameHangman newGame = new GameHangman("exampleWord.txt");
            LOGGER.info("Если хотите выйти из игры нажмите -");
            newGame.gameState();
            String guess;
            while (newGame.checkIfGameIsRunning() && player.checkIfWantsToPlay()) {
                do {
                    guess = player.input();
                }
                while (!player.validateInput(guess));
                player.makeATurn(newGame, guess);
                newGame.gameState();
            }
            Scanner scanner = new Scanner(System.in);
            do {
                String checker;
                LOGGER.info("Сыграть ещё раз?");
                LOGGER.info("    д. Да");
                LOGGER.info("    н. Нет");
                checker = scanner.next();
                if (checker.length() > 1) {
                    continue;
                }
                playAgain = checker.charAt(0);
            }
            while (playAgain != 'д' && playAgain != 'н');
        }
        while (playAgain == 'д');
    }
}
