public class Main {
    public static void main(String[] args) {
        GameOfUr game = new GameOfUr();
        Logic.control(game);
    }
}

class IO {
    //probably can make this simpler with a switch statement
    private static void printBoard(boolean[][] board) {
        //shared
        //safe
        //player 1
        //player 2

        for (int i = 13; i >= 0; i--) {
            //if the tile is not shared
            if (board[3][i] == false) {

                //if the tile is not safe
                if (board[2][i] == false) {
                    if (board[0][i] == false) {
                        System.out.print("O");
                    } else {
                        System.out.print("X");
                    }

                    if (board[1][i] == false) {
                        System.out.println("O");
                    } else {
                        System.out.println("Y");
                    }
                    continue;
                }

                //if the tile is safe
                if (board[0][i] == false) {
                    System.out.print("@");
                } else {
                    System.out.print("#");
                }
                if (board[1][i] == false) {
                        System.out.println("O");
                } else {
                    System.out.println("$");
                } 
                continue;                   
                }
                
            //if the tile is shared
            //if the tile is not safe
            if (board[2][i] == false) {
                if (board[0][i] == true) {
                    System.out.println("XX");
                    continue;
                }
                if (board[1][i] == true) {
                    System.out.println("YY");
                    continue;
                }
                System.out.println("OO");
                continue;
            }

            //if the tile is safe
            if (board[0][i] == true) {
                System.out.println("##");
                continue;
            }
            if (board[1][i] == true) {
                System.out.println("$$");
                continue;
            }
            System.out.println("@@");
        }
    }
}

class Logic {
    private static int PLAYER1 = 0;
    private static int PLAYER2 = 1;

    protected static void control(GameOfUr game){
        //roll dice
        //check if any legal moves
        //ask for input
        //check if input is legal
        //check if landed on safe square
        //edit map
        //check if game ended
        //repeat
    }
}

class GameOfUr {

    private boolean[][] board = new boolean[14][4];
    private Player player1 = new Player();
    private Player player2 = new Player();

    protected GameOfUr(){
        board[2][3] = true;
        board[2][7] = true;
        board[2][13] = true;

        int count = 0;

        for (boolean i : board[3]){
            if (count >= 4 || count <= 11){
                i = true;
            }
            count++;
        }
    }

    private boolean[][] getBoard(){
        return board;
    }

    private void setBoard(int origin, int destination, int player){
        board[origin][player] = false;
        board[destination][player] = true;
    }

    private Player getPlayer1(){
        return player1;
    }

    private Player getPlayer2(){
        return player2;
    }
}

class Player {
    private int score = 0;
    private int pieces = 7;

    Player(){}

    private int getScore(){
        return score;
    }

    private int getPieces(){
        return pieces;
    }

    private void incrementScore(){
        score++;
    }

    private void incrementPieces(){
        pieces++;
    }

    private void decrementPieces(){
        pieces--;
    }
}