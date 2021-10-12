public class TicTacToeTest {
    public static void main(String[] args) {
        TicTacToeTest test = new TicTacToeTest();

        System.out.println(test.testRowWin() == TicTacToe.WIN);

        System.out.println(test.testColWin() == TicTacToe.WIN);

        System.out.println(test.testCross1Win() == TicTacToe.WIN);

        System.out.println(test.testCross2Win() == TicTacToe.WIN);

        System.out.println(test.testFull() == TicTacToe.FULL);

        System.out.println(test.testNormal() == TicTacToe.CONTINUE);

        System.out.println(test.testInvalid() == TicTacToe.INVALID);

        System.out.println(test.testInvalidPlayer() == TicTacToe.INVALID);
    }

    /**
     * test row win
     *
     * @return
     */
    private int testRowWin() {
        TicTacToe game = new TicTacToe();
        game.playStep(TicTacToe.PLAYER0, 0, 0);
        game.playStep(TicTacToe.PLAYER1, 1, 1);

        game.playStep(TicTacToe.PLAYER0, 0, 2);
        game.playStep(TicTacToe.PLAYER1, 1, 0);

        return game.playStep(TicTacToe.PLAYER0, 0, 1);
    }

    /**
     * test col win
     *
     * @return
     */
    private int testColWin() {
        TicTacToe game = new TicTacToe();
        game.playStep(TicTacToe.PLAYER0, 0, 0);
        game.playStep(TicTacToe.PLAYER1, 1, 1);

        game.playStep(TicTacToe.PLAYER0, 2, 0);
        game.playStep(TicTacToe.PLAYER1, 2, 1);

        return game.playStep(TicTacToe.PLAYER0, 1, 0);
    }

    /**
     * 0,0; 1,1; 2,2 win
     *
     * @return
     */
    private int testCross1Win() {
        TicTacToe game = new TicTacToe();
        game.playStep(TicTacToe.PLAYER0, 0, 0);
        game.playStep(TicTacToe.PLAYER1, 0, 1);

        game.playStep(TicTacToe.PLAYER0, 1, 1);
        game.playStep(TicTacToe.PLAYER1, 2, 0);

        return game.playStep(TicTacToe.PLAYER0, 2, 2);
    }

    /**
     * 0,2; 1,1; 2,0 win
     *
     * @return
     */
    private int testCross2Win() {
        TicTacToe game = new TicTacToe();
        game.playStep(TicTacToe.PLAYER0, 1, 1);
        game.playStep(TicTacToe.PLAYER1, 0, 1);

        game.playStep(TicTacToe.PLAYER0, 2, 0);
        game.playStep(TicTacToe.PLAYER1, 2, 1);

        return game.playStep(TicTacToe.PLAYER0, 0, 2);
    }

    /**
     * test grid full
     *
     * @return
     */
    private int testFull() {
        TicTacToe game = new TicTacToe();
        game.playStep(TicTacToe.PLAYER0, 1, 1);
        game.playStep(TicTacToe.PLAYER1, 0, 0);

        game.playStep(TicTacToe.PLAYER0, 0, 2);
        game.playStep(TicTacToe.PLAYER1, 2, 0);

        game.playStep(TicTacToe.PLAYER0, 1, 0);
        game.playStep(TicTacToe.PLAYER1, 1, 2);

        game.playStep(TicTacToe.PLAYER0, 1, 0);
        game.playStep(TicTacToe.PLAYER1, 1, 2);

        game.playStep(TicTacToe.PLAYER0, 2, 1);
        game.playStep(TicTacToe.PLAYER1, 0, 1);

        return game.playStep(TicTacToe.PLAYER0, 2, 2);
    }

    /**
     * test invalid step
     *
     * @return
     */
    private int testInvalid() {
        TicTacToe game = new TicTacToe();
        game.playStep(TicTacToe.PLAYER0, 0, 0);
        return game.playStep(TicTacToe.PLAYER1, 0, 0);
    }

    /**
     * test normal step
     *
     * @return
     */
    private int testNormal() {
        TicTacToe game = new TicTacToe();
        game.playStep(TicTacToe.PLAYER0, 0, 0);
        return game.playStep(TicTacToe.PLAYER1, 0, 1);
    }

    /**
     * test invalid player 5
     *
     * @return
     */
    private int testInvalidPlayer() {
        TicTacToe game = new TicTacToe();
        return game.playStep(5, 0, 0);
    }
}
