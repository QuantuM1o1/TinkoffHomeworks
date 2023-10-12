package edu.hw1;

public class Task8 {
    private Task8() {
    }

    static final int BOARD_SIZE = 8;
    static final int KNIGHT_SUM_OF_MOVES = 3;

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 1; i < BOARD_SIZE - 1; i++) {
            for (int j = 1; j < BOARD_SIZE - 1; j++) {
                if (board[i][j] == 1) {
                    if (checkAllMoves(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean checkAllMoves(int[][] board, int i1, int j1) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1 && i != i1 && j != j1
                    && (Math.abs(i - i1) + Math.abs(j - j1) == KNIGHT_SUM_OF_MOVES)) {
                    return true;
                }
            }
        }
        return false;
    }
}
