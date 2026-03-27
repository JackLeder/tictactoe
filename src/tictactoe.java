import java.util.Scanner;


public class tictactoe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];
    private static int moveCount = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        clearBoard();

        boolean done = false;

        do {


            boolean validp1check = false;
            boolean validp2check = false;


            while (!validp1check) {
                int pl1row1 = safeinput.getRangedInt(in, "Player 1, enter row (1-3)", 1, 3) - 1;
                int pl1col1 = safeinput.getRangedInt(in, "Player 1, enter column (1-3)", 1, 3) - 1;

                if (isValidMove(pl1row1, pl1col1)) {
                    board[pl1row1][pl1col1] = "X";
                    moveCount++;
                    validp1check = true;
                }
            }

            if (isWin("X")) {
                display();
                System.out.println("Player 1 wins!");
                System.out.println("total move count: " + moveCount);

                boolean playagain = safeinput.getYNConfirm(in, "Do you want to play again?");
                if(playagain){
                    clearBoard();
                    continue;
                }else{
                    done = true;
                }


            }else if(isTie()){
                display();
                System.out.println("It's a tie!");
                System.out.println("total move count: " + moveCount);

                boolean playagain = safeinput.getYNConfirm(in, "Do you want to play again?");
                if(playagain){
                    clearBoard();
                    continue;
                }else{
                    done = true;
                }


            }
            else{
                display();
            }



            while (!validp2check) {
                int pl1row2 = safeinput.getRangedInt(in, "Player 2, enter row (1-3)", 1, 3) - 1;
                int pl1col2 = safeinput.getRangedInt(in, "Player 2, enter column (1-3)", 1, 3) - 1;

                if (isValidMove(pl1row2, pl1col2)) {
                    board[pl1row2][pl1col2] = "O";
                    moveCount++;
                    validp2check = true;

                }
            }


            if (isWin("O")) {
                display();
                System.out.println("Player 2 wins!");
                System.out.println("total move count: " + moveCount);

                boolean playagain = safeinput.getYNConfirm(in, "Do you want to play again?");
                if(playagain){
                    clearBoard();
                    continue;
                }else{
                    done = true;
                }



            }else if(isTie()){
                display();
                System.out.println("It's a tie!");
                System.out.println("total move count: " + moveCount);

                boolean playagain = safeinput.getYNConfirm(in, "Do you want to play again?");
                if(playagain){
                    clearBoard();
                    continue;
                }else{
                    done = true;
                }
            }
            else{
                display();
            }


        }while(!done);
    }



    private static void clearBoard(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = " ";
            }
        }
    }
    private static void display(){
        System.out.print("\n\n");

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j]);
                if (j < COLS - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < ROWS - 1) {
                System.out.println("-----------------");
            }
        }
    }
    private static boolean isValidMove(int row, int col){
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Invalid row or column");
            return false;
        }
        if (!board[row][col].equals(" ")) {
            System.out.println("Invalid row or column someone already played there");
            return false;
        }
        return true;
    }


    private static boolean isWin(String player){
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }


    private static boolean isRowWin(String player){
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

     private static boolean isColWin(String player){
        for (int j = 0; j < COLS; j++) {
            if (board[0][j].equals(player) && board[1][j].equals(player) && board[2][j].equals(player)) {
                return true;
            }
        }return false;
    }

     private static boolean isDiagonalWin(String player){
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        return false;
     }

     private static boolean isTie(){
        if (isWin("X") || isWin("O")) {
            return false;
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
         return true;
     }

    }

