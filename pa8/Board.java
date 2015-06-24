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
 *             boolean[][] combineGrid - The grid that let's you know if a tile can combine or not.
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

    // The purpose of this grid is to allow combining of tiles. This grid
    // holds the ability for the tile to combine (true) or not (false).
    // When tiles are moving in the board, the values of this board "walk"
    // with the tiles as well.
    private boolean[][] combineGrid;

    // CONSTRUCTORS
    // Constructs a fresh board with random tiles
    public Board(int boardSize, Random random)
    {
        this.random = random;
        if (boardSize >= 2) {
            this.GRID_SIZE = boardSize;
        }
        else {
            this.GRID_SIZE = 2;
        }
        this.grid = new int[this.GRID_SIZE][this.GRID_SIZE];
        this.score = 0;
        this.combineGrid = new boolean[this.GRID_SIZE][this.GRID_SIZE];

        // Add two random tiles
        for (int i = 0; i < this.NUM_START_TILES; i++) {
            this.addRandomTile();
        }

        this.resetCombine();
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
        this.combineGrid = new boolean[this.GRID_SIZE][this.GRID_SIZE];
        this.resetCombine();
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
       // Does this condition ever occur?... I don't think so.
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
                    this.combineGrid[row][col] = true;
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
        // If any move is valid, return false.
        if (this.canMoveLeft()
            || this.canMoveRight()
            || this.canMoveUp()
            || this.canMoveDown()) {
            return false;
        }
        return true;
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
            return this.canMoveLeft();
        }
        else if (direction.equals(Direction.RIGHT)) {
            return this.canMoveRight();
        }
        else if (direction.equals(Direction.UP)) {
            return this.canMoveUp();
        }
        else if (direction.equals(Direction.DOWN)) {
            return this.canMoveDown();
        }
        return false;
    }
    /*
     * Name: move
     * Purpose: Handles the move operations using the helper methods.
     * Parameter: None
     * Return: boolean - True if move was successful, false otherwise.
     */
    public boolean move(Direction direction)
    {
        if (direction.equals(Direction.LEFT)) {
            this.moveLeft();
            return true;
        }
        else if (direction.equals(Direction.RIGHT)) {
            this.moveRight();
            return true;
        }
        else if (direction.equals(Direction.UP)) {
            this.moveUp();
            return true;
        }
        else if (direction.equals(Direction.DOWN)) {
            this.moveDown();
            return true;
        }
        return false;
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
     *          Count the number of valid moves, if >= 0, a valid move is available.
     * Parameters: None
     * Return: boolean - True if specific move is valid, false otherwise.
     */

    private boolean canMoveLeft() {

        int count = 0;
        for (int col = 1; col < this.GRID_SIZE; col++) {
            for (int row = 0; row < this.GRID_SIZE; row++) {
                if (this.grid[row][col] != 0
                    && (this.grid[row][col-1] == 0
                    || this.grid[row][col-1] == this.grid[row][col])) {

                    count++;
                }
            }
        }  
        if (count == 0) {
            return false;
        }
        return true;
    }

    private boolean canMoveRight() {

        int count = 0;
        for (int col = this.GRID_SIZE - 2; col>= 0; col--) {
            for (int row = 0; row < this.GRID_SIZE; row++) {
                if (this.grid[row][col] != 0
                    && (this.grid[row][col+1] == 0
                    ||  this.grid[row][col+1] == this.grid[row][col])) {

                    count++;
                }
            }
        }
        if (count == 0) {
            return false;
        }
        return true;
    }

    private boolean canMoveUp() {
    
        int count = 0;
        for (int row = 1; row < this.GRID_SIZE; row++) {
            for (int col = 0; col < this.GRID_SIZE; col++) {
                if (this.grid[row][col] != 0
                    && (this.grid[row-1][col] == 0
                    || this.grid[row-1][col] == this.grid[row][col])) {

                    count++;
                }
            }
        }
        if (count == 0) {
            return false;
        }
        return true;
    }

    private boolean canMoveDown() {

        int count = 0;
        for (int row = this.GRID_SIZE - 2; row >= 0; row--) {
            for (int col = 0; col < this.GRID_SIZE; col++) {
                if (this.grid[row][col] != 0
                    && (this.grid[row+1][col] == 0
                    ||  this.grid[row+1][col] == this.grid[row][col])) {

                    count++;
                }
            }
        }
        if (count == 0) {
            return false;
        }
        return true;
    }
    /*
     * Name: moveRight, moveLeft, moveUp, moveDown
     * Purpose: Each method performs the move operation for the specific
     *          direction. The methods iterate through the tiles and finds
     *          a tile that can move. The method then "moves" the tile until
     *          it cannot move any longer. Note, a tile can combine while
     *          the method moves the tiles space by space. Once a tile combines
     *          it cannot combine again thanks to the combineGrid object.
     * Parameters: None
     * Return: void
     */

    private void moveRight() {

        for (int row = 0; row < this.GRID_SIZE; row++) {
            for(int col = this.GRID_SIZE - 2; col >= 0; col--) {
                if (this.grid[row][col] != 0) { // Take a non-zero tile
                    int j = col;
                    // indicates if the tile is blocked
                    boolean blocked = false;
                    // This loop moves the tile space by space
                    while (j < this.GRID_SIZE - 1 && !blocked) {
                        // Check if tile one space ahead is 0
                        if (this.grid[row][j + 1] == 0) {
                            // copy tile to next tile, then make current tile 0
                            this.grid[row][j + 1] = this.grid[row][j];
                            this.grid[row][j] = 0;
                            this.combineGrid[row][j + 1] = true;
                            this.combineGrid[row][j] = false;
                        }
                        // Check if tile ahead is the same value as current
                        // tile, and check if tiles can combine
                        else if (this.grid[row][j + 1]
                                  == this.grid[row][j]
                                  && (this.combineGrid[row][j + 1]
                                  && this.combineGrid[row][j])) {
                            // Make tile ahead double the current tile
                            // and make current tile 0
                            this.grid[row][j + 1] = 2 * this.grid[row][j];
                            this.grid[row][j] = 0;
                            // Increase score
                            this.score += this.grid[row][j + 1];
                            // The tile ahead can no longer combine
                            this.combineGrid[row][j + 1] = false;
                            this.combineGrid[row][j] = false;
                        }
                        // The tile is blocked
                        else {
                            blocked = true;
                        }
                        j++;
                    }
                }
            }
        }
        // After moving, reset combineGrid to allow combining for the next move
        this.resetCombine();
    }

    private void moveLeft() {
        for (int row = 0; row < this.GRID_SIZE; row++) {
            for(int col = 1; col < this.GRID_SIZE; col++) {
                if (this.grid[row][col] != 0) {
                    int j = col;
                    boolean blocked = false;
                    while (j > 0 && !blocked) {
                        if (this.grid[row][j - 1] == 0) {

                            this.grid[row][j - 1] = this.grid[row][j];
                            this.grid[row][j] = 0;
                            this.combineGrid[row][j - 1] = true;
                            this.combineGrid[row][j] = false;
                        }
                        else if (this.grid[row][j - 1]
                                  == this.grid[row][j]
                                  && (this.combineGrid[row][j - 1]
                                  && this.combineGrid[row][j])) {
                                  
                            this.grid[row][j - 1] = 2 * this.grid[row][j];
                            this.grid[row][j] = 0;
                            this.score += this.grid[row][j - 1];
                            this.combineGrid[row][j - 1] = false;
                            this.combineGrid[row][j] = false;
                        }
                        else {
                            blocked = true;
                        }
                        j--;
                    }
                }
            }
        }
        this.resetCombine();
    }

    private void moveUp() {
        for (int col = 0; col < this.GRID_SIZE; col++) {
            for (int row = 1; row < this.GRID_SIZE; row ++) {
                if (this.grid[row][col] != 0) {
                    int i = row;
                    boolean blocked = false;
                    while (i > 0 && !blocked) {
                        if (this.grid[i - 1][col] == 0) {
                            this.grid[i - 1][col] = this.grid[i][col];
                            this.grid[i][col] = 0;
                            this.combineGrid[i - 1][col] = true;
                            this.combineGrid[i][col] = false;
                        }
                        else if (this.grid[i - 1][col]
                                  == this.grid[i][col]
                                  && (this.combineGrid[i - 1][col]
                                  && this.combineGrid[i][col])) {

                            this.grid[i - 1][col] = 2 * this.grid[i][col];
                            this.grid[i][col] = 0;
                            this.score += this.grid[i - 1][col];
                            this.combineGrid[i - 1][col] = false;
                            this.combineGrid[i][col] = false;
                        }
                        else {
                            blocked = true;
                        }
                        i--;
                    }
                }
            }
        }
        this.resetCombine();
    }

    private void moveDown() {
        for (int col = 0; col < this.GRID_SIZE; col++) {
            for (int row = this.GRID_SIZE - 2; row >= 0; row--) {
                if (this.grid[row][col] != 0) {
                    int i = row;
                    boolean blocked = false;
                    while (i < this.GRID_SIZE - 1 && !blocked) {
                        if (this.grid[i + 1][col] == 0) {

                            this.grid[i + 1][col] = this.grid[i][col];
                            this.grid[i][col] = 0;
                            this.combineGrid[i + 1][col] = true;
                            this.combineGrid[i][col] = false;
                        }
                        else if (this.grid[i + 1][col]
                                  == this.grid[i][col]
                                  && (this.combineGrid[i + 1][col]
                                  && this.combineGrid[i][col])) {

                            this.grid[i + 1][col] = 2 * this.grid[i][col];
                            this.grid[i][col] = 0;
                            this.score += this.grid[i + 1][col];
                            this.combineGrid[i + 1][col] = false;
                            this.combineGrid[i][col] = false;
                        }
                        else {
                            blocked = true;
                        }
                        i++;
                    }
                }
            }
        }
        this.resetCombine();
    }
    /*
     * Name: resetCombine
     * Purpose: Resets the combineGrid array. We need to do this to allow
     *          tiles to combine for the next move operation.
     * Parameters: None
     * Return: void
     */
    private void resetCombine() {

        for (int row = 0; row < this.GRID_SIZE; row++) {
            for (int col = 0; col < this.GRID_SIZE; col++) {
                if (this.grid[row][col] != 0) {
                    this.combineGrid[row][col] = true;
                }
                else {
                    this.combineGrid[row][col] = false;
                }
            }
        }
    }
}
