import java.util.Scanner;

public class TicTacToe {
    private int boardSize;
    private enum Status {WIN, DRAW, CONTINUE};
    private int[][] board;
    private boolean firstPlayer;
    private boolean gameOver;

    public TicTacToe(int sizeOfBoard) {
        boardSize = sizeOfBoard;
        board = new int[boardSize][boardSize];
        firstPlayer = true;
        gameOver = false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int position;

        System.out.println("Player 1's turn.");

        while(!gameOver) {
            int player = (firstPlayer ? 1 : 2);

            do {
                System.out.printf("Player %d: Enter position (1-%d): ", player, boardSize * boardSize);
                position = scanner.nextInt();
            }
            while(!validMove(position));

            int row = (position -1) / boardSize;
            int column = (position -1) % boardSize;
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

        boolean win = true;
        // check for a win on diagonals
        if(board[0][0] != 0) {
            for(int i=1 ; i<boardSize ; i++) {
                if(board[i][i] != board[0][0]) {
                    win = false;
                    break;
                }
            }
            if(win)
                return Status.WIN;
        }

        win = true;
        if(board[0][boardSize -1] != 0) {
            for(int i=1 ; i<boardSize ; i++) {
                if(board[i][boardSize -1-i] != board[0][boardSize -1]) {
                    win = false;
                    break;
                }
            }
            if(win)
                return Status.WIN;
        }

        for(int row = 0 ; row < boardSize ; row++) {
            win = true;
            if(board[row][0] != 0) {
                for(int col = 1 ; col < boardSize ; col++) {
                    if(board[row][col] != board[row][0]) {
                        win = false;
                        break;
                    }
                }
                if(win)
                    return Status.WIN;
            }
        }

        for(int col = 0 ; col < boardSize ; col++) {
            win = true;
            if(board[0][col] != 0) {
                for(int row = 1 ; row < boardSize ; row++) {
                    if(board[row][col] != board[0][col]) {
                        win = false;
                        break;
                    }
                }
                if(win)
                    return Status.WIN;
            }
        }
        
        // check for a completed game
        for(int r=0 ; r<boardSize ; r++)
            for(int c=0 ; c<boardSize ; c++)
                if(board[r][c] == 0)
                    return Status.CONTINUE;

        return Status.DRAW;
    }

    public void printBoard() {
        for(int column = 0 ; column < boardSize ; column++) {
            System.out.print(" _______");
        }
        System.out.println(" ");
        for(int row = 0 ; row < boardSize ; row++) {
            for(int column = 0 ; column < boardSize ; column++) {
                System.out.print("|       ");
            }
            System.out.println("|");

            for(int column = 0 ; column < boardSize ; column++) {
                printSymbol(column, board[row][column]);
            }
            for(int column = 0 ; column < boardSize ; column++) {
                System.out.print("|_______");
            }
            System.out.println("|");
        }
    }

    public void printSymbol(int column, int player) {
        switch (player) {
            case 0:
                System.out.print("|       ");
                break;
            case 1:
                System.out.print("|   x   ");
                break;
            case 2:
                System.out.print("|   o   ");
                break;
        }

        if(column == (boardSize -1))
            System.out.println("|");
    }

    public boolean validMove(int position) {
        if(position < 1 || position > boardSize * boardSize)
            return false;
        
        int row = (position -1) / boardSize;
        int column = (position -1) % boardSize;
        return board[row][column] == 0;
    }
}