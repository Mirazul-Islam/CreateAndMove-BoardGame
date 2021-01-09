/**
 * @author: Mirazul Islam
 * @date: 9/29/2020
 * class: GameDemo
 * description: This class containg the main method to test out the code for the other class and play the game here.
 */

import java.util.*;

public class GameDemo {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a command (Type help for details):");
        String input = in.nextLine();

        Board board = new Board();


        while (!input.equals("exit")) { // Exit the game if the user input exit.
            String[] word = input.split(" ");
            //To get help if needed. which display a sets of command to play the game.
            if (input.equals("help")) {
                System.out.println("Possible commands are as follows:\n" +
                        "create location [fast][flexible]: Creates a new piece.\n" +
                        "move location direction [spaces]: Moves a piece.\n" +
                        "print: Displays the board.\n" +
                        "help: Displays help.\n" +
                        "exit: Exits the program.\n");


            }else if (input.equals("print")) { //Prints the board
                System.out.print(board);

            }else if (word[0].equals("create")) { //Creates an object depending on the type

                System.out.println("Input a name for the new piece:");
                String name = in.nextLine();
                System.out.println("Input a colour for the new piece:");
                String col = in.nextLine();

                if (word[word.length - 1].equals("fast")) {
                    FastPiece fp = new FastPiece(name, col, Integer.parseInt(word[1]), Integer.parseInt(word[2]));
                    board.add(fp);
                    System.out.println("Created new game piece.");

                } else if (word.length > 3 && word[3].equals("flexible")) {
                    SlowFlexible sf = new SlowFlexible(name, col, Integer.parseInt(word[1]), Integer.parseInt(word[2]));
                    board.add(sf);
                    System.out.println("Created new game piece.");
                } else if (word[word.length - 2].equals("fast") && word[word.length - 1].equals("flexible")) {
                    FastFlexible ff = new FastFlexible(name, col, Integer.parseInt(word[1]), Integer.parseInt(word[2]));
                    board.add(ff);
                    System.out.println("Created new game piece.");
                } else if (word.length == 3) {
                    SlowPiece sp = new SlowPiece(name, col, Integer.parseInt(word[1]), Integer.parseInt(word[2]));
                    board.add(sp);
                    System.out.println("Created new game piece.");
                }else if (word.length <3 && word.length>4) {
                    System.out.print("Please enter in the correct input format. For more details enter help.");
                }
            }else if (word[0].equals("move")) { // Moves an object depending on the type
                if (word.length>4) {
                    if(board.getObject(Integer.parseInt(word[1]), Integer.parseInt(word[2]))!=null) {
                        board.movePos(board.getObject(Integer.parseInt(word[1]), Integer.parseInt(word[2])), Integer.parseInt(word[4]), word[3]);
                    }

                } else if (word.length==4) {
                    if(board.getObject(Integer.parseInt(word[1]), Integer.parseInt(word[2]))!=null) {
                        board.movePos(board.getObject(Integer.parseInt(word[1]), Integer.parseInt(word[2])), 1, word[3]);
                    }
                } else {
                    System.out.println("Please enter in the correct input format. For more details enter help.");
                }

            }else{
                System.out.println("Please enter in the correct input format. For more details enter help.");
            }

            System.out.println("Enter a command (Type help for details):");
            input = in.nextLine();
        }
    }
}
