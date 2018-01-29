
//Where the game is run

import java.util.*;

public class Game {

    public static void main(String[] args) {
        Board myBoard = new Board();
        Scanner keyboard = new Scanner(System.in);

        myBoard.fistBoard();

        int go;
        do {
            gameUpdate(myBoard, keyboard);
            go = myBoard.checkGame();
        } while (go == 0);

        if (go == 2) {
            System.out.println("No one wins. The game is a DRAW!");
        } else if (myBoard.getTurn() % 2 == 0) {
            System.out.println("\nPlayer 'O' wins!!");
        } else {
            System.out.println("\nPlayer 'X' wins!!");
        }


    }

    public static void gameUpdate(Board myBoard, Scanner keyboard) {

        int column;
        int row;
        int keepGoing;
        do {
            System.out.println();

            if (myBoard.getTurn() % 2 == 0) {
                System.out.print("Player 'X', ");
            } else {
                System.out.print("Player 'O', ");
            }

            System.out.print("Enter your move (column[1-3]) row[1-3]): ");

            column = keyboard.nextInt();
            row = keyboard.nextInt();

            if (row > 3 || column > 3) {
                keepGoing = invalidPrint(column, row);

            } else if (!myBoard.getArrValue(column, row).equals(myBoard.blank)) {

                keepGoing = invalidPrint(column, row);
            } else {
                keepGoing = 1;
            }

        } while (keepGoing == 0);


        myBoard.arrUpdate(column, row);
        myBoard.boardUpdate();


    }

    public static int invalidPrint(int column, int row) {
        System.out.print("This move at (" + column + "," + row + ") is not valid. ");
        System.out.println("Try again...");
        return 0;

    }


}
