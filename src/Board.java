/**
 * @author: Mirazul Islam
 * @date: 9/29/2020
 * class: Board
 * description: THis class contains the board and also methods to create and move objects.
 */

import java.util.Arrays;

public class Board {
    private Piece[][] board = new Piece[8][8];

    private int [] positionBlock= new int [64];

    /**
     * This method is used to add the piece.
     * @param object of type Piece that adds the object to the board.
     */
    public void add(Piece object) {
        if ((object.getPositionx() > 8 || object.getPositionx() < 0 ||
                object.getPositiony() > 8 || object.getPositiony() < 0)) {
            System.out.println("You are creating an object outside the board!");
        } else if (object.getPositionx() < 8 && object.getPositionx() >= 0 &&
                object.getPositiony() < 8 && object.getPositiony() >= 0 &&
                board[object.getPositionx()][object.getPositiony()] == null){
            board[object.getPositionx()][object.getPositiony()] = object;
        }else{
            System.out.println("Object already exists! Please create at a different place!");
        }
    }

    /**
     * This method is used to move the piece.
     * @param object of type Piece that adds the object to the board.
     * @param n of type int, decide how to move
     * @param dir of type String decide which direction to move
     */
    public void movePos(Piece object, int n, String dir) {

            int x = object.getPositionx();
            int y = object.getPositiony();

            if (object.getClass() == FastFlexible.class || object.getClass() == FastPiece.class) {
                object.move(dir, n);
            } else if (object.getClass() == SlowPiece.class || object.getClass() == SlowFlexible.class) {
                if (n > 1) {
                    System.out.println("Slow Piece or Slow flexible piece can only move one unit at a time!");
                    object.setMove(false);
                } else {
                    object.move(dir);
                }
            }

            if (board[object.getPositionx()][object.getPositiony()] == null) {
                board[object.getPositionx()][object.getPositiony()] = object;
                board[x][y] = null;
                object.setMove(true);
            } else if (board[object.getPositionx()][object.getPositiony()] != null && object.getMove()) {
                board[x][y] = object;
                object.setMove(true);
                System.out.println("Object already exist!");
            } else {
                object.setMove(true);
            }
    }


    /**
     * This method is used find the piece using the parameter
     * @param x of type int
     * @param y of type int
     */
    public Piece getObject(int x, int y) {
        if (board[x][y] == null) {
            System.out.println("Error: no piece at ("+x+", "+y+")");
            return null;
        } else {

            return board[x][y];
        }
    }



    @Override
    public String toString() {
        for (int i=0; i<=7; i++) {
            for (int j=0; j<=7; j++) {
                if (board[i][j]==null) {
                    System.out.print("-"+"\t");
                } else {
                    System.out.print(board[i][j]);
                }
            }  System.out.println();
        } return "";
    }
}
