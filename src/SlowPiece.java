/**
 * @author: Mirazul Islam
 * @date: 9/29/2020
 * class: SlowPiece
 * description: This type of piece can move left and right. (Sub class of Piece class)
 */


public class SlowPiece extends Piece{

    //Constructor
    public SlowPiece(String name, String colour, int x, int y) {
        super(name, colour, x, y);
    }

    /**
     * This method is used to move the piece.
     * @param direction of type String, which is the direction the piece should be moved
     */
    public void move(String direction){
        if (!direction.equals("left") && !direction.equals("right")){
            System.out.println("Please enter the correct direction.");
            super.setMove(false);
        }else if(direction.equals("right") && super.getPosition()[1]!=7){
            super.setPosition(super.getPositionx(), super.getPositiony()+1);
        }else if(direction.equals("left") && super.getPosition()[1]!=0){
            super.setPosition(super.getPositionx(), super.getPositiony()-1);
        }else{
            super.setMove(false);
            System.out.println("You are moving your object out of the board.");
        }
    }

    //toString method
    @Override
    public String toString() {
        return super.toString()+"S";
    }
}
