package week11;

public class TokenPass {
    private int[] board;
    private int currentPlayer;

    public TokenPass(int playerCount) {
        board = new int[playerCount];

        for (int i = 0; i < board.length; i++) {
            int rand = (int)(Math.random() * 10) + 1;
            board[i] = rand;
        }
        currentPlayer = (int)(Math.random() * playerCount);
    }

    public void distributeCurrentPlayerTokens() {
        int tokens = board[currentPlayer];
        board[currentPlayer] = 0;

        int nextPlayer = currentPlayer + 1;

        while(tokens > 0) {
            if(nextPlayer == board.length) {
                nextPlayer = 0;
            }

            board[nextPlayer]++;
            nextPlayer++;
            tokens--;
        }
    }


}