/**
 * @author: Mirazul Islam
 * @date: 9/29/2020
 * class: FastPiece
 * description: This type of piece can move left and right with n number of steps. (Sub class of Piece class)
 */

public class FastPiece extends Piece{

    public FastPiece(String name, String colour, int x, int y) {
        super(name, colour, x, y);
    }

    /**
     * This method is used to move the piece.
     * @param direction of type String, which is the direction the piece should be moved
     * @param n of type int which decide how much to move
     */
    public void move(String direction, int n){

        if (!direction.equals("left") && !direction.equals("right") ){
            System.out.println("Please enter the correct direction.");
            super.setMove(false);
        }else if(direction.equals("right") && super.getPosition()[1]+n<=7){
            super.setPosition(super.getPositionx(), super.getPositiony()+n);
        }else if(direction.equals("left") && super.getPosition()[1]-n>=0){
            super.setPosition(super.getPositionx(), super.getPositiony()-n);
        }else{
            super.setMove(false);
            System.out.println("You are moving your object out of the board.");
        }
    }



    @Override
    public String toString() {
        return super.toString()+"F";
    }
}
