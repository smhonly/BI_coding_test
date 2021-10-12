public class TicTacToe {

    public static final int PLAYER0 = 1;
    public static final int PLAYER1 = 2;

    public static final int WIN = 2;
    public static final int FULL = 1;
    public static final int CONTINUE = 0;
    public static final int INVALID = -1;

    private int[][] grids = new int[3][3];

    /**
     * play game
     *
     * @param player player0/player1
     * @param row
     * @param col
     * @return 2:player win, 1:grid full; 0:no player win,continue; -1:invalid
     */
    public int playStep(int player, int row, int col) {
        if (row < 0 || row > 3) {
            return INVALID;
        }
        if (col < 0 || col > 3) {
            return INVALID;
        }
        if (player != PLAYER0 && player != PLAYER1) {
            return INVALID;
        }
        //grid occupied.
        if (grids[row][col] != 0) {
            return INVALID;
        }

        int currentPlayer;
        grids[row][col] = player;

        //check all same values in one row
        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            boolean allSame = true;
            currentPlayer = grids[rowIdx][0];
            if (currentPlayer != 0) {
                for (int colIdx = 1; colIdx < 3; colIdx++) {
                    if (grids[rowIdx][colIdx] != currentPlayer) {
                        allSame = false;
                        break;
                    }
                }
                if (allSame) {
                    return WIN;
                }
            }
        }

        //check all same values in one col
        for (int colIdx = 0; colIdx < 3; colIdx++) {
            boolean allSame = true;
            currentPlayer = grids[0][colIdx];
            if (currentPlayer != 0) {
                for (int rowIdx = 1; rowIdx < 3; rowIdx++) {
                    if (grids[rowIdx][colIdx] != currentPlayer) {
                        allSame = false;
                        break;
                    }
                }
                if (allSame) {
                    return WIN;
                }
            }
        }

        //check all same values from 0,0;1,1;2,2
        currentPlayer = grids[0][0];
        if (currentPlayer > 0) {
            if (currentPlayer == grids[1][1] && currentPlayer == grids[2][2]) {
                return WIN;
            }
        }

        //check all same values from 0,2;1,1;2,0
        currentPlayer = grids[0][2];
        if (currentPlayer > 0) {
            if (currentPlayer == grids[1][1] && currentPlayer == grids[2][0]) {
                return WIN;
            }
        }

        //check all grids full
        boolean full = true;
        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            for (int colIdx = 0; colIdx < 3; colIdx++) {
                if (grids[rowIdx][colIdx] == 0) {
                    full = false;
                    break;
                }
            }
        }
        if (full) {
            return FULL;
        }

        //can put the chess
        return CONTINUE;
    }
}
