import java.util.Scanner;

public class TicTacToe {
    private final int BOARDSIZE = 3;
    private enum Status {WIN, DRAW, CONTINUE};
    private int[][] board;
    private boolean firstPlayer;
    private boolean gameOver;

    public TicTacToe() {
        board = new int[BOARDSIZE][BOARDSIZE];
        firstPlayer = true;
        gameOver = false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int row;
        int column;

        System.out.println("Player 1's turn.");

        while(!gameOver) {
            int player = (firstPlayer ? 1 : 2);

            do {
                System.out.printf("Player %d: Enter row (0 <= row < 3): ", player);
                row = scanner.nextInt();
                System.out.printf("Player %d: Enter column (0 <= row < 3): ", player);
                column = scanner.nextInt();
            }
            while(!validMove(row, column));

            board[row][column] = player;
            firstPlayer = !firstPlayer;
            printBoard();
            printStatus(player);
        }
    }

    public void printStatus(int player) {
        Status status = gameStatus();

        switch (status) {
            case WIN:
                System.out.println("Player " + player + " wins.");
                gameOver = true;
                break;
            case DRAW:
                System.out.println("Game Drawn.");
                gameOver = true;
                break;
            case CONTINUE:
                if(player == 1)
                    System.out.println("Player 2's turn.");
                else
                    System.out.println("Player 1's turn.");
                break;
        }
    }

    public Status gameStatus() {
        int a;

        // check for a win on diagonals
        if(board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2])
            return Status.WIN;
        else if(board[0][2] != 0 && board[0][2] == board[1][1] && board[0][2] == board[2][0])
            return Status.WIN;

        // check for a win in rows
        for(a=0 ; a<3 ; a++)
            if(board[a][0] != 0 && board[a][0] == board[a][1] && board[a][0] == board[a][2])
                return Status.WIN;
        
        // check for a win in columns
        for(a=0 ; a<3 ; a++)
            if(board[0][a] != 0 && board[0][a] == board[1][a] && board[0][a] == board[2][a])
                return Status.WIN;
        
        // check for a completed game
        for(int r=0 ; r<3 ; r++)
            for(int c=0 ; c<3 ; c++)
                if(board[r][c] == 0)
                    return Status.CONTINUE;

        return Status.DRAW;
    }

    public void printBoard() {
        System.out.println(" _______ _______ _______ ");
        for(int row = 0 ; row < BOARDSIZE ; row++) {
            System.out.println("|       |       |       |");

            for(int column = 0 ; column < BOARDSIZE ; column++) {
                printSymbol(column, board[row][column]);
            }
            System.out.println("|_______|_______|_______|");
        }
    }

    public void printSymbol(int column, int player) {
        switch (player) {
            case 0:
                System.out.print("|       ");
                break;
            case 1:
                System.out.print("|   1   ");
                break;
            case 2:
                System.out.print("|   2   ");
                break;
        }

        if(column == 2)
            System.out.println("|");
    }

    public boolean validMove(int row, int column) {
        return row >= 0 && row < 3 && column >= 0 && column < 3 && board[row][column] == 0;
    }
}