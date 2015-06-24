import java.util.*;
import java.io.*;

/* 
 * Name: Julius Sphabmixay
 * Login: cs8beq
 * Date: April 23, 2015
 * File: GameManager.java
 *
 * This program runs the game 2048. It creates the board, loads a saved
 * boarda and saves the board. It also prints and updates the game board.
 *
 */

/* Name: GameManager
 * Purpose: This class manages the game using the play method.
 * Parameters: Board board - A Board object. It holds the values of tiles.
 *             String outputFileName - The name of the saved board game.
 */

public class GameManager
{
    // FIELDS
    private Board board;    // The actual 2048 board
    private String outputFileName;  // File to save the board to when exiting
    
    // CONSTRUCTORS
    // Creates new game
    public GameManager(int boardSize, String outputBoard, Random random)
    {
        this.outputFileName = outputBoard;
        this.board = new Board(boardSize, random);

    }

    // Load a saved game
    public GameManager(String inputBoard, String outputBoard, Random random)
        throws IOException
    {
        this.outputFileName = outputBoard;
        this.board = new Board(inputBoard, random);

    }
    
    // METHODS --------------------------------------

    // Main play loop
    // Takes in input from the user to specify moves to execute
    // valid moves are:
    //      w - Move up
    //      s - Move Down
    //      a - Move Left
    //      d - Move Right
    //      q - Quit and Save Board
    //
    //  If an invalid command is received then print the controls 
    //  to remind the user of the valid moves.
    //
    //  Once the player decides to quit or the game is over,
    //  save the game board to a file based on the outputFileName
    //  string that was set in the constructor and then return
    //
    //  If the game is over print "Game Over!" to the terminal

    /*
     *  Name: play
     *  Purpose: Plays the game 2048.
     *  Parameters: None
     *  Return: void
     */
    public void play() throws IOException
    {
        // Make scanner for user input
        Scanner userInput = new Scanner(System.in);
        boolean quit = false; // Used to check if player quits

        // Main game loop. As long as the game is not over and player
        // has not quit the game, the game runs.
        while (!this.board.isGameOver() && !quit) {

            this.printControls();
            System.out.println(this.board.toString());
            String input = userInput.next();

            // Checks moves and performs them if valid
            if (input.equals("a")) {
                //System.out.println("Left");
                if (this.board.canMove(Direction.LEFT)) {
                    this.board.move(Direction.LEFT);
                    this.board.addRandomTile();
                }
                else {
                    System.out.println("Can't move left!");
                }
            }
            else if (input.equals("d")) {
                //System.out.println("Right");
                if (this.board.canMove(Direction.RIGHT)) {
                    this.board.move(Direction.RIGHT);
                    this.board.addRandomTile();
                }
                else {
                    System.out.println("Can't move right!");
                }
            }
            else if (input.equals("w")) {
                //System.out.println("Up");
                if (this.board.canMove(Direction.UP)) {
                    this.board.move(Direction.UP);
                    this.board.addRandomTile();
                }
                else {
                    System.out.println("Can't move up!");
                }
            }
            else if (input.equals("s")) {
                //System.out.println("Down");
                if (this.board.canMove(Direction.DOWN)) {
                    this.board.move(Direction.DOWN);
                    this.board.addRandomTile();
                }
                else {
                    System.out.println("Can't move down!");
                }
            }
            // Saves and quits the game if user inputs 'q'
            else if (input.equals("q")) {
                this.board.saveBoard(this.outputFileName);
                System.out.println("Saving game and quitting.");
                quit = true;
            }
            else {
                this.printControls();
                System.out.println(input+" is an invalid move, try again.");
            }
        }
        if (this.board.isGameOver()) {
            System.out.println("Game Over!");
        }
    }
    /* Name: printControls
     * Purpose: Prints controls to terminal
     * Parameters: None
     * Return: void
     */
    private void printControls()
    {
        System.out.println("  Controls:");
        System.out.println("    w - Move Up");
        System.out.println("    s - Move Down");
        System.out.println("    a - Move Left");
        System.out.println("    d - Move Right");
        System.out.println("    q - Quit and Save Board");
        System.out.println();
    }
}
