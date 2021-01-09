/**
 * @author: Mirazul Islam
 * @date: 9/29/2020
 * class: Piece
 * description: THis is a super class of all the type of piece object and contains all the method that are in common.
 */

import java.util.Arrays;

public class Piece {
    private String Name;
    private String Colour;
    private int[] Position = new int[2];
    int x;
    int y;
    boolean moveBlock=true;


    //Constructor
    public Piece(String name, String colour, int x, int y) {
        Name = name;
        Colour = colour;
        Position[0]=x;
        Position[1]=y;
    }

    //Getters
    public String getName() {
        return Name;
    }

    public String getColour() {
        return Colour;
    }

    public int[] getPosition() {
        return Position;
    }

    public boolean getMove(){
        return moveBlock;
    }

    public int getPositionx() {
        return Position[0];
    }

    public int getPositiony() {
        return Position[1];
    }

    //Setters

    public void setName(String name) {
        Name = name;
    }

    public void setColour(String colour) {
        Colour = colour;
    }

    public void setPosition(int x, int y) {
        Position[0]=x;
        Position[1]=y;
    }

    public void setMove( boolean x){
        moveBlock=x;
    }


    //move object for type fast
    public void move(String direction, int n){}

    //move object for type slow
    public void move(String direction){}



    //toString
    @Override
    public String toString() {
        return Name+Colour;
    }
}

