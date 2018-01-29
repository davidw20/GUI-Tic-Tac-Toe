
//This is the board class to create board objects

public class Board {

    String[][] boardArr = new String[3][3];
    String blank = " ";
    int turn = 0;

    public Board() {
        boardArr = initialize();

    }

    private String[][] initialize() {

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                boardArr[k][i] = " ";
            }

        }

        return boardArr;

    }

    public String[][] arrUpdate(int column, int row) {
        if (turn % 2 == 0) {
            boardArr[row - 1][column - 1] = "X";

        } else {
            boardArr[row - 1][column - 1] = "O";
        }

        turn++;
        return boardArr;
    }

    public void boardUpdate(){
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                System.out.print(" " + boardArr[k][i] + " ");
                if (i < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (k < 2) {
                System.out.println("------------");
            }

        }

    }

    public int getTurn(){
        return turn;
    }

    public int checkGame() {
        if (boardArr[1][1].equals(boardArr[0][0]) && boardArr[1][1].equals(boardArr[2][2]) && !boardArr[1][1].equals(blank)) {
            return 1;
        } else if (boardArr[1][1].equals(boardArr[2][0]) && boardArr[1][1].equals(boardArr[0][2]) && !boardArr[1][1].equals(blank)) {
            return 1;
        } else if (boardArr[1][1].equals(boardArr[1][0]) && boardArr[1][1].equals(boardArr[1][2]) && !boardArr[1][1].equals(blank)) {
            return 1;
        } else if (boardArr[1][1].equals(boardArr[0][1]) && boardArr[1][1].equals(boardArr[2][1]) && !boardArr[1][1].equals(blank)) {
            return 1;
        } else if (boardArr[0][0].equals(boardArr[1][0]) && boardArr[0][0].equals(boardArr[2][0]) && !boardArr[0][0].equals(blank)) {
            return 1;
        } else if (boardArr[0][0].equals(boardArr[0][1]) && boardArr[0][0].equals(boardArr[0][2]) && !boardArr[0][0].equals(blank)) {
            return 1;
        } else if (boardArr[2][2].equals(boardArr[1][2]) && boardArr[2][2].equals(boardArr[0][2]) && !boardArr[2][2].equals(blank)) {
            return 1;
        } else if (boardArr[2][2].equals(boardArr[2][1]) && boardArr[2][2].equals(boardArr[2][0]) && !boardArr[2][2].equals(blank)) {
            return 1;
        } else if (isDraw()) {
            return 2;
        } else {
            return 0;
        }
    }

    public boolean isDraw() {
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (boardArr[k][i].equals(blank)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getArrValue(int column, int row) {
        return boardArr[row - 1][column - 1];
    }

    public void fistBoard(){
        for (int k = 1; k <= 3; k++) {
            for (int i = 1; i <= 3; i++) {
                System.out.print(" " + i + "," + k + " ");
                if (i < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (k <= 2) {
                System.out.println("------------");
            }

        }

    }
}
