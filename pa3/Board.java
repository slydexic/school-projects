/**     Sample Board
 *
 *      0   1   2   3
 *  0   -   -   -   -
 *  1   -   -   -   -
 *  2   -   -   -   -
 *  3   -   -   -   -
 *
 *  The sample board shows the index values for the columns and rows
 *  Remember that you access a 2D array by first specifying the row
 *  and then the column: grid[row][column]
 */

import java.util.*;
import java.io.*;

/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Date: April 23, 2015
 * File: Board.java
 *
 * This file handles the board for 2048.
 *
 */

/* Name: Board
 * Purpose: This class manages the board for 2048. It adds tiles,
 *          checks if moves are valid, and loads/saves boards.
 * Parameters: int NUM_START_TILES - Tile limit at start of game.
 *             int TWO_PROBABILITY - Determines probability of tile being 2.
 *             int GRID_SIZE - Number of rows/cols of board.
 *             Random random - Object to run probability checks.
 *             int[][] grid - The 2D array to hold tile values and position.
 *             int score - The player's score.
 */

public class Board
{
    // FIELDS
    public final int NUM_START_TILES = 2;
    public final int TWO_PROBABILITY = 90;
    public final int GRID_SIZE;


    private final Random random;
    private int[][] grid;
    private int score;

    // CONSTRUCTORS
    // Constructs a fresh board with random tiles
    public Board(int boardSize, Random random)
    {
        this.random = random; 
        this.GRID_SIZE = boardSize; 
        this.grid = new int[boardSize][boardSize];
        this.score = 0;

        // Add two random tiles
        for (int i = 0; i < this.NUM_START_TILES; i++) {
            this.addRandomTile();
        }
    }

    // Construct a board based off of an input file 
    public Board(String inputBoard, Random random) throws IOException
    {
        // Make file for scanner to read through
        File inputFile = new File(inputBoard);
        Scanner input = new Scanner(inputFile);
        this.random = random;

        // Copy board information to make remake board
        this.GRID_SIZE = input.nextInt(); 
        this.score = input.nextInt();
        this.grid = new int[this.GRID_SIZE][this.GRID_SIZE];
        for (int row = 0; row < this.GRID_SIZE; row++) {
           for (int col = 0; col < this.GRID_SIZE; col++) {
              this.grid[row][col] = input.nextInt();
           }

        }
    }

    // METHODS
    /*
     * Name: saveBoard
     * Purpose: Saves the board after player quits game.
     * Parameters: String outputBoard - Name of the file when saving.
     * Return: void
     */
    public void saveBoard(String outputBoard) throws IOException
    {
       // Make file for PrintWriter to write to
       File outputFile = new File(outputBoard);
       PrintWriter output = new PrintWriter(outputFile);

       // Copy information from game to output file
       output.println(this.GRID_SIZE);
       output.println(this.score);
       for (int row = 0; row < this.GRID_SIZE; row++) {
          for (int col = 0; col < this.GRID_SIZE; col++) {
             output.print(this.grid[row][col] + " ");
          }
          output.println();
       }
       output.close();
    }

    /* 
     * Name: addRandomTile
     * Purpose: Adds a random tile of value 2 or 4 in an empty space.
     * Parameters: None
     * Return: void
     */
    public void addRandomTile()
    {
       // Count the number of empty tiles
       int count = 0;
       for (int row = 0; row < this.GRID_SIZE; row++) {
          for (int col = 0; col < this.GRID_SIZE; col++) {
             if (this.grid[row][col] == 0) {
                count++;
             }
          }
       }
       if (count == 0) {
          System.out.println("No empty spaces available");
          return;
       }
       // Randomly select tile location
       int location = this.random.nextInt(count);
       int value = this.random.nextInt(100);
       // Reiterate through board and find empty tile location
       int emptyTiles = 0;
       for (int row = 0; row < this.GRID_SIZE; row++) {
          for (int col = 0; col < this.GRID_SIZE; col++) {
             if (this.grid[row][col] == 0) {
                emptyTiles++;
                 if (emptyTiles - 1 == location) {
                    if ( value < this.TWO_PROBABILITY ) {
                       this.grid[row][col] = 2;
                    }
                    else {
                       this.grid[row][col] = 4;
                    }
                 }
             }
          }
       }
    }

    /*
     * Name: isGameOver
     * Purpose: Checks if the game is over when there are no valid moves
     * Parameters: None
     * Return: boolean - True if game is over, false otherwise.
     */
    public boolean isGameOver()
    {
        // If no moves are valid, game over
        if (!this.canMoveLeft()
            && !this.canMoveRight()
            && !this.canMoveUp()
            && !this.canMoveDown()) {
            return true;
        }
        return false;
    }
    
    /*
     * Name: canMove
     * Purpose: Checks if player moves are valid
     * Parameters: Direction direction - The keyboard input direction
     *                                   that is from the Direction class.
     * Return: boolean - True if move is valid, false if no moves valid.
     */
    public boolean canMove(Direction direction)
    {
        // Checks if moves are valid using helper methods
        if (direction.equals(Direction.LEFT)) {
            this.canMoveLeft();  
        }
        else if (direction.equals(Direction.RIGHT)) {
            this.canMoveRight();
        }
        else if (direction.equals(Direction.UP)) {
            this.canMoveUp();
        }
        else if (direction.equals(Direction.DOWN)) {
            this.canMoveDown();
        }
        return false;
    }

    // TODO PA4
    // Perform a move Operation
    public boolean move(Direction direction)
    {
        return true;
    }

    // Return the reference to the 2048 Grid
    public int[][] getGrid()
    {
        return grid;
    }

    // Return the score
    public int getScore()
    {
        return score;
    }

    @Override
    public String toString()
    {
        StringBuilder outputString = new StringBuilder();
        outputString.append(String.format("Score: %d\n", score));
        for (int row = 0; row < GRID_SIZE; row++)
        {
            for (int column = 0; column < GRID_SIZE; column++)
                outputString.append(grid[row][column] == 0 ? "    -" :
                                    String.format("%5d", grid[row][column]));

            outputString.append("\n");
        }
        return outputString.toString();
    }

    /*
     * Name: canMoveLeft, canMoveRight, canMoveUp, canMoveDown
     * Purpose: Each method checks specifically if the direction is valid.
     * Parameters: None
     * Return: boolean - True if specific move is valid, false otherwise.
     */

    private boolean canMoveLeft() {

       // Iterates through each tile to see if the the tile can move
       for (int col = 1; col < this.GRID_SIZE; col++) {
           for (int row = 0; row < this.GRID_SIZE; row++) {
               if (this.grid[row][col-1] == 0 ||
                               this.grid[row][col-1] == this.grid[row][col]) {
                   return true;
               }
           }
       }
       return false;
    }

    private boolean canMoveRight() {
        // Iterates through each tile to see if the tile can move
        for (int col = this.GRID_SIZE - 2; col >= 0; col--) {
            for (int row = 0; row < this.GRID_SIZE; row++) {
                if (this.grid[row][col+1] == 0 ||
                                this.grid[row][col-1] == this.grid[row][col]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canMoveUp() {
        // Iterates through each tile to see if tile can move
        for (int row = 1; row < this.GRID_SIZE; row++) {
            for (int col = 0; col < this.GRID_SIZE; col++) {
                if (this.grid[row-1][col] == 0 ||
                                this.grid[row-1][col] == this.grid[row][col]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canMoveDown() {
        // Iterates through each tile to see if tile can move
        for (int row = this.GRID_SIZE - 2; row >= 0; row--) {
            for (int col = 0; col < this.GRID_SIZE; col++) {
                if (this.grid[row+1][col] == 0 ||
                                this.grid[row+1][col] == this.grid[row][col]) {
                    return true;
                }
            }
        }
        return false;
    }
}
