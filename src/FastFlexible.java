/**
 * @author: Mirazul Islam
 * @date: 9/29/2020
 * class: FastFlexible
 * description: This type of piece can move left, right, up and down with n number of steps. (Sub class of Piece class)
 */

public class FastFlexible extends Piece{

    public FastFlexible(String name, String colour, int x, int y) {
        super(name, colour, x, y);
    }

    /**
     * This method is used to move the piece.
     * @param direction of type String, which is the direction the piece should be moved
     * @param n of type int which decide how much to move
     */
    public void move(String direction, int n){

        if (!direction.equals("left") && !direction.equals("right") && !direction.equals("down") && !direction.equals("up") ){
            System.out.println("Please enter the correct direction.");
            super.setMove(false);
        }else if (direction.equals("up") && super.getPosition()[0]-n>=0){
            super.setPosition(super.getPositionx()-n, super.getPositiony());
        }else if(direction.equals("down")  && super.getPosition()[0]+n<=7){
            super.setPosition(super.getPositionx()+n, super.getPositiony());
        }else if(direction.equals("right") && super.getPosition()[1]+n<=7){
            super.setPosition(super.getPositionx(), super.getPositiony()+n);
        }else if(direction.equals("left") && super.getPosition()[1]-n>=0){
            super.setPosition(super.getPositionx(), super.getPositiony()-n);
        }else{
            super.setMove(false);
             System.out.println("Please do not move your object out of the board");
        }
    }

    @Override
    public String toString() {
        return super.toString()+"FF";
    }
}
