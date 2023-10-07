package edu.hw1;

public class Task8 {
    private Task8() {
    }

    static final int BOARD_SIZE_MINUS_ONE = 7;

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 1; i < BOARD_SIZE_MINUS_ONE; i++) {
            for (int j = 1; j < BOARD_SIZE_MINUS_ONE; j++) {
                if (board[i][j] == 1) {
                    if (checkAllMoves(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean checkAllMoves(int[][] board, int i, int j) {
        return (checkFirstMove(board, i, j) || checkSecondMove(board, i, j) || checkThirdMove(board, i, j)
            || checkFourthMove(board, i, j) || checkFifthMove(board, i, j) || checkSixthMove(board, i, j)
            || checkSeventhMove(board, i, j) || checkEighthMove(board, i, j));
    }

    private static boolean checkFirstMove(int[][] board, int i, int j) {
        if (((i - 2) >= 0) && ((j + 1) <= BOARD_SIZE_MINUS_ONE)) {
            return (board[i - 2][j + 1] == 1);
        }
        return false;
    }

    private static boolean checkSecondMove(int[][] board, int i, int j) {
        if (((i - 1) >= 0) && ((j + 2) <= BOARD_SIZE_MINUS_ONE)) {
            return (board[i - 1][j + 2] == 1);
        }
        return false;
    }

    private static boolean checkThirdMove(int[][] board, int i, int j) {
        if (((i + 1) <= BOARD_SIZE_MINUS_ONE) && ((j + 2) <= BOARD_SIZE_MINUS_ONE)) {
            return (board[i + 1][j + 2] == 1);
        }
        return false;
    }

    private static boolean checkFourthMove(int[][] board, int i, int j) {
        if (((i + 2) <= BOARD_SIZE_MINUS_ONE) && ((j + 1) <= BOARD_SIZE_MINUS_ONE)) {
            return (board[i + 2][j + 1] == 1);
        }
        return false;
    }

    private static boolean checkFifthMove(int[][] board, int i, int j) {
        if (((i + 2) <= BOARD_SIZE_MINUS_ONE) && ((j - 1) >= 0)) {
            return (board[i + 2][j - 1] == 1);
        }
        return false;
    }

    private static boolean checkSixthMove(int[][] board, int i, int j) {
        if (((i + 1) <= BOARD_SIZE_MINUS_ONE) && ((j - 2) >= 0)) {
            return (board[i + 1][j - 2] == 1);
        }
        return false;
    }

    private static boolean checkSeventhMove(int[][] board, int i, int j) {
        if (((i - 1) >= 0) && ((j - 2) >= 0)) {
            return (board[i - 1][j - 2] == 1);
        }
        return false;
    }

    private static boolean checkEighthMove(int[][] board, int i, int j) {
        if (((i - 2) >= 0) && ((j - 1) >= 0)) {
            return (board[i - 2][j - 1] == 1);
        }
        return false;
    }
}
