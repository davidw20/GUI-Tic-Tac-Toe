/**
 * 
 */
package tic_tac_toe;

import java.awt.Color;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * @author David
 *
 */
public class Board {

    private String[][] boardArr = new String[3][3];
    private int player;
    private String blank;

    private Window window;
    private Shape horzBar1;
    private Shape vertBar1;
    private Shape horzBar2;
    private Shape vertBar2;

    private Shape square1;
    private Shape square2;
    private Shape square3;
    private Shape square4;
    private Shape square5;
    private Shape square6;
    private Shape square7;
    private Shape square8;
    private Shape square9;


    public Board() {
        initialize();
        player = 1;
        blank = " ";

        window = new Window();
        window.setSize(1000, 1000);
        horzBar1 = new Shape(100, 275, 800, 20, Color.BLACK); // x, y, width,
                                                              // height, color
        vertBar1 = new Shape(325, 50, 20, 800, Color.BLACK);
        horzBar2 = new Shape(100, 575, 800, 20, Color.BLACK);
        vertBar2 = new Shape(625, 50, 20, 800, Color.BLACK);

        square1 = new Shape(100, 50, 225, 225, Color.GREEN);
        square2 = new Shape(345, 50, 300, 225, Color.GREEN);
        square3 = new Shape(645, 50, 255, 225, Color.GREEN);
        square4 = new Shape(100, horzBar1.getY() + horzBar1.getHeight(), 225,
            300, Color.GREEN);
        square5 = new Shape(345, horzBar1.getY() + horzBar1.getHeight(), 300,
            300, Color.GREEN);
        square6 = new Shape(645, horzBar1.getY() + horzBar1.getHeight(), 255,
            300, Color.GREEN);
        square7 = new Shape(100, horzBar2.getY() + horzBar2.getHeight(), 225,
            260, Color.GREEN);
        square8 = new Shape(345, horzBar2.getY() + horzBar2.getHeight(), 300,
            260, Color.GREEN);
        square9 = new Shape(645, horzBar2.getY() + horzBar2.getHeight(), 255,
            260, Color.GREEN);

        square1.onClick(this, "clickedSquare1");
        square2.onClick(this, "clickedSquare2");
        square3.onClick(this, "clickedSquare3");
        square4.onClick(this, "clickedSquare4");
        square5.onClick(this, "clickedSquare5");
        square6.onClick(this, "clickedSquare6");
        square7.onClick(this, "clickedSquare7");
        square8.onClick(this, "clickedSquare8");
        square9.onClick(this, "clickedSquare9");

        printBoard();

    }


    /**
     * This method sets the 2D array blank
     * 
     * @return a blank 2D array
     */
    public void initialize() {

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                boardArr[i][k] = " ";
            }

        }

    }


    /**
     * This method updates the 2D array of the board by passing in the column
     * number and row number of the new move
     * 
     * @param column
     * @param row
     * @return
     */
    public void arrUpdate(int column, int row) {
        if (player == 1) {
            boardArr[row - 1][column - 1] = "X";

        }
        else {
            boardArr[row - 1][column - 1] = "O";
        }

    }


    /**
     * This method returns the 2D board array
     * 
     * @return
     */
    public String[][] getArray() {
        return boardArr;
    }


    /**
     * This method checks to see if the game is over
     * 
     * @return
     */
    public String checkGame() {

        // Diagonal, top left, center, bottom right
        if (boardArr[1][1].equals(boardArr[0][0]) && boardArr[1][1].equals(
            boardArr[2][2]) && !boardArr[1][1].equals(blank)) {
            return "won";

            // Diagonal, top right, center, bottom left
        }
        else if (boardArr[1][1].equals(boardArr[2][0]) && boardArr[1][1].equals(
            boardArr[0][2]) && !boardArr[1][1].equals(blank)) {
            return "won";
        }
        else if (boardArr[1][1].equals(boardArr[1][0]) && boardArr[1][1].equals(
            boardArr[1][2]) && !boardArr[1][1].equals(blank)) {
            return "won";
        }
        else if (boardArr[1][1].equals(boardArr[0][1]) && boardArr[1][1].equals(
            boardArr[2][1]) && !boardArr[1][1].equals(blank)) {
            return "won";
        }
        else if (boardArr[0][0].equals(boardArr[1][0]) && boardArr[0][0].equals(
            boardArr[2][0]) && !boardArr[0][0].equals(blank)) {
            return "won";
        }
        else if (boardArr[0][0].equals(boardArr[0][1]) && boardArr[0][0].equals(
            boardArr[0][2]) && !boardArr[0][0].equals(blank)) {
            return "won";
        }
        else if (boardArr[2][2].equals(boardArr[1][2]) && boardArr[2][2].equals(
            boardArr[0][2]) && !boardArr[2][2].equals(blank)) {
            return "won";
        }
        else if (boardArr[2][2].equals(boardArr[2][1]) && boardArr[2][2].equals(
            boardArr[2][0]) && !boardArr[2][2].equals(blank)) {
            return "won";
        }
        else if (isDraw()) {
            return "draw";
        }
        else {
            return "go";
        }
    }


    /**
     * This method checks to see if the game is a draw by checking if all the
     * places are filled
     */
    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                if (boardArr[i][k].equals(blank)) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * This method prints the board
     */
    public void printBoard() {

        window.addShape(horzBar1);
        window.addShape(vertBar1);
        window.addShape(horzBar2);
        window.addShape(vertBar2);

        window.addShape(square1);
        window.addShape(square2);
        window.addShape(square3);
        window.addShape(square4);
        window.addShape(square5);
        window.addShape(square6);
        window.addShape(square7);
        window.addShape(square8);
        window.addShape(square9);

    }


    public void clickedSquare1(Shape square1) {
        clickedRecaction(1);

    }


    public void clickedSquare2(Shape square2) {
        clickedRecaction(2);

    }


    public void clickedSquare3(Shape square3) {
        clickedRecaction(3);

    }


    public void clickedSquare4(Shape square4) {
        clickedRecaction(4);

    }


    public void clickedSquare5(Shape square5) {
        clickedRecaction(5);

    }


    public void clickedSquare6(Shape square6) {
        clickedRecaction(6);

    }


    public void clickedSquare7(Shape square7) {
        clickedRecaction(7);

    }


    public void clickedSquare8(Shape square8) {
        clickedRecaction(8);

    }


    public void clickedSquare9(Shape square9) {
        clickedRecaction(9);

    }


    public void clickedRecaction(int squareNum) {

        if (player == 1) {
            printX(squareNum);
            
            if (checkGame().equals("won")) {
                window.removeAllShapes();
                window.addShape(new TextShape(500, 500, "Player " + player + " won!!!", Color.GREEN));
            }
            else if (checkGame().equals("draw")) {
                window.removeAllShapes();
                window.addShape(new TextShape(500, 500, "The Game is a Draw", Color.GREEN));
            }
            
            player = 2;

        }
        else {
            printO(squareNum);
            
            if (checkGame().equals("won")) {
                window.removeAllShapes();
                window.addShape(new TextShape(500, 500, "Player " + player + " won!!!", Color.GREEN));
            }
            else if (checkGame().equals("draw")) {
                window.removeAllShapes();
                window.addShape(new TextShape(500, 500, "The Game is a Draw", Color.GREEN));
            }
            
            player = 1;
        }
        
        

    }


    public void printX(int squareNum) {
        
        if (squareNum == 1) {
            window.addShape(new SquareShape(125, 75, 200, Color.BLUE));
            window.removeShape(square1);
            arrUpdate(1, 1);
        }
        else if (squareNum == 2) {
            window.addShape(new SquareShape(370, 75, 200, Color.BLUE));
            window.removeShape(square2);
            arrUpdate(2, 1);

        }
        else if (squareNum == 3) {
            window.addShape(new SquareShape(670, 75, 200, Color.BLUE));
            window.removeShape(square3);
            arrUpdate(3, 1);

        }
        else if (squareNum == 4) {
            window.addShape(new SquareShape(125, square4.getHeight() + 25, 200,
                Color.BLUE));
            window.removeShape(square4);
            arrUpdate(1, 2);

        }
        else if (squareNum == 5) {
            window.addShape(new SquareShape(370, square4.getHeight() + 25, 200,
                Color.BLUE));
            window.removeShape(square5);
            arrUpdate(2, 2);

        }
        else if (squareNum == 6) {
            window.addShape(new SquareShape(670, square4.getHeight() + 25, 200,
                Color.BLUE));
            window.removeShape(square6);
            arrUpdate(3, 2);

        }
        else if (squareNum == 7) {
            window.addShape(new SquareShape(125, 600, 200, Color.BLUE));
            window.removeShape(square7);
            arrUpdate(1, 3);

        }
        else if (squareNum == 8) {
            window.addShape(new SquareShape(370, 600, 200, Color.BLUE));
            window.removeShape(square8);
            arrUpdate(2, 3);

        }
        else if (squareNum == 9) {
            window.addShape(new SquareShape(670, 600, 200, Color.BLUE));
            window.removeShape(square9);
            arrUpdate(3, 3);

        }

    }


    public void printO(int squareNum) {

        if (squareNum == 1) {
            window.addShape(new CircleShape(125, 75, 200, Color.RED));
            window.removeShape(square1);
            arrUpdate(1, 1);
        }
        else if (squareNum == 2) {
            window.addShape(new CircleShape(370, 75, 200, Color.RED));
            window.removeShape(square2);
            arrUpdate(2, 1);

        }
        else if (squareNum == 3) {
            window.addShape(new CircleShape(670, 75, 200, Color.RED));
            window.removeShape(square3);
            arrUpdate(3, 1);

        }
        else if (squareNum == 4) {
            window.addShape(new CircleShape(125, square4.getHeight() + 25, 200,
                Color.RED));
            window.removeShape(square4);
            arrUpdate(1, 2);

        }
        else if (squareNum == 5) {
            window.addShape(new CircleShape(370, square4.getHeight() + 25, 200,
                Color.RED));
            window.removeShape(square5);
            arrUpdate(2, 2);

        }
        else if (squareNum == 6) {
            window.addShape(new CircleShape(670, square4.getHeight() + 25, 200,
                Color.RED));
            window.removeShape(square6);
            arrUpdate(3, 2);

        }
        else if (squareNum == 7) {
            window.addShape(new CircleShape(125, 600, 200, Color.RED));
            window.removeShape(square7);
            arrUpdate(1, 3);

        }
        else if (squareNum == 8) {
            window.addShape(new CircleShape(370, 600, 200, Color.RED));
            window.removeShape(square8);
            arrUpdate(2, 3);

        }
        else if (squareNum == 9) {
            window.addShape(new CircleShape(670, 600, 200, Color.RED));
            window.removeShape(square9);
            arrUpdate(3, 3);

        }

    }
}
