
/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Filename: Gui2048.java
 * Date: May 24, 2015
 *
 * This file contains the Gui2048 class, which handles the graphical interface
 * and event handling for 2048.
 */


/** Gui2048.java */
/** PA8 Release */

import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;
import java.io.*;

/* Name: Gui2048
 * Purpose: Creates the GUI for 2048.
 * Parameters: Rectangle[][] rectGrid - Stores Rectangles in a grid
 *             Text[][] textGrid - Holds Texts in a grid
 *             Tile[][] tileGrid - Holds Tiles in a grid
 *             Insets insets - The insets for the pane
 *             Text score - The score
 *             Text title - The title
 *             RowConstraints[] rConstrArray - The row constraints for the pane
 *             ColumnConstraints[] cConstrArray - The col constraints for the pane
 *             HBox centerGameOverPane - The center game over pane
 *             HBox topGameOverPane - The top game over pane
 *             Text gameOverText - The game over text
 *             Rectangle centerOpaqueRect - The semi-transparent overlay for center pane
 *             Rectangle topOpaqueRect - The semi-transparent overlay for top pane
 *             GridPane centerPane - The center pane for the rectangles and texts
 *             GridPane topPane - The top pane for the title and score
 *             StackPane centerStackPane - The pane that contains the centerPane
 *                                          and centerGameOverPane
 *             StackPane topCenterPane - The pane that contains the topPane
 *                                       and the topGameOverPane
 *             BorderPane borderPane - The pane that contains the
 *                                     centerStackPane and topStackPane
 *
 */

public class Gui2048 extends Application
{
    private String outputBoard; // The filename for where to save the Board
    private Board board; // The 2048 Game Board

    // Fill colors for each of the Tile values
    private static final Color COLOR_EMPTY = Color.rgb(238, 228, 218, 0.35);
    private static final Color COLOR_2 = Color.rgb(238, 228, 218);
    private static final Color COLOR_4 = Color.rgb(237, 224, 200);
    private static final Color COLOR_8 = Color.rgb(242, 177, 121);
    private static final Color COLOR_16 = Color.rgb(245, 149, 99);
    private static final Color COLOR_32 = Color.rgb(246, 124, 95);
    private static final Color COLOR_64 = Color.rgb(246, 94, 59);
    private static final Color COLOR_128 = Color.rgb(237, 207, 114);
    private static final Color COLOR_256 = Color.rgb(237, 204, 97);
    private static final Color COLOR_512 = Color.rgb(237, 200, 80);
    private static final Color COLOR_1024 = Color.rgb(237, 197, 63);
    private static final Color COLOR_2048 = Color.rgb(237, 194, 46);
    private static final Color COLOR_OTHER = Color.BLACK;
    private static final Color COLOR_GAME_OVER = Color.rgb(238, 228, 218, 0.73);

    private static final Color COLOR_VALUE_LIGHT = Color.rgb(249, 246, 242); // For tiles >= 8
    private static final Color COLOR_VALUE_DARK = Color.rgb(119, 110, 101); // For tiles < 8

    /** Add your own Instance Variables here */

    private Rectangle[][] rectGrid;
    private Text[][] textGrid;
    private Tile[][] tileGrid;
    private Insets insets = new Insets(10,10,10,10);
    private Text score = new Text();
    private Text title = new Text("2048");
    private RowConstraints[] rConstrArray;
    private ColumnConstraints[] cConstrArray;

    private HBox centerGameOverPane = new HBox();
    private HBox topGameOverPane = new HBox();
    private Text gameOverText = new Text("Game Over!");

    private Rectangle centerOpaqueRect = new Rectangle();
    private Rectangle topOpaqueRect = new Rectangle();

    private GridPane centerPane = new GridPane();
    private GridPane topPane = new GridPane();

    private StackPane centerStackPane;
    private StackPane topStackPane;

    private BorderPane borderPane;

    /* Name: start
     * Purpose: Starts the application. Must override from Application.
     * Parameters: Stage primaryStage - The stage for the application.
     * Return: void
     */
    @Override
    public void start(Stage primaryStage)
    {
        // Process Arguments and Initialize the Game Board
        processArgs(getParameters().getRaw().toArray(new String[0]));

        // Create Rectangles, Texts, and Tiles for centerPane
        this.rectGrid = this.makeRectangles(board.GRID_SIZE);
        this.textGrid = this.makeTexts(board.GRID_SIZE);
        this.tileGrid = this.makeTiles(board.GRID_SIZE);
        
        // Create constraints for centerPane
        this.rConstrArray = this.makeRowConstraints(board.GRID_SIZE, 25);
        this.cConstrArray = this.makeColConstraints(board.GRID_SIZE, 25);

        // Set score text, and fonts for score and title
        this.score.setText("Score: " + board.getScore());
        this.score.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
        this.title.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 40));
        
        // Set font for gameOverText
        this.gameOverText.setFont(Font.font("Times New Roman",FontWeight.BOLD,60));
        
        // Set overlay for center of borderPane
        this.centerOpaqueRect.setFill(Color.WHITE);
        this.centerOpaqueRect.setOpacity(.33);
        this.centerOpaqueRect.widthProperty().bind(primaryStage.widthProperty());
        this.centerOpaqueRect.heightProperty().bind(primaryStage.heightProperty());

        // Set insets and style for centerPane
        this.centerPane.setPadding(insets);
        this.centerPane.setStyle("-fx-background-color: rgb(187,173,160)");
        // Set topPane
        this.topPane.setStyle("-fx-background-color: rgb(187,173,160)"); 
        this.topPane.add(title,0,0);
        this.topPane.add(score,1,0);
        this.topPane.setHalignment(score,HPos.CENTER);
        this.topPane.setHalignment(title,HPos.CENTER);
        
        // Create and set constraints for topPane
        ColumnConstraints tCol1 = new ColumnConstraints();
        ColumnConstraints tCol2 = new ColumnConstraints();
        tCol1.setPercentWidth(50);
        tCol2.setPercentWidth(50);
        this.topPane.getColumnConstraints().addAll(tCol1,tCol2);
        
        // Set overlay for top of borderPane
        this.topOpaqueRect.setFill(Color.WHITE);
        this.topOpaqueRect.setOpacity(.33);
        this.topOpaqueRect.widthProperty().bind(topPane.widthProperty());
        this.topOpaqueRect.heightProperty().bind(topPane.heightProperty());
        
        // Set centerGameOverPane
        this.centerGameOverPane.setMinWidth(centerPane.getMinWidth());
        this.centerGameOverPane.setMinHeight(centerPane.getHeight());
        this.centerGameOverPane.setAlignment(Pos.CENTER);
        this.centerGameOverPane.getChildren().addAll(centerOpaqueRect,gameOverText);
        
        // Set topGameOverPane
        this.topGameOverPane.setMinWidth(topPane.getMinWidth());
        this.topGameOverPane.setMinHeight(topPane.getMinHeight());
        this.topGameOverPane.setAlignment(Pos.CENTER);
        this.topGameOverPane.getChildren().add(topOpaqueRect);

        // Create Stackpanes and add other panes
        centerStackPane = new StackPane(gameOverText,centerGameOverPane,centerPane);
        topStackPane = new StackPane(topGameOverPane,topPane);
        
        // Create borderPane and add stackpanes
        this.borderPane = new BorderPane(centerStackPane,topStackPane,null,null,null);
        this.borderPane.setMinWidth(480);
        this.borderPane.setMinHeight(560);

        // Create Scene and set scene to primaryStage
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Gui2048");
        primaryStage.setScene(scene);
        primaryStage.show();

        // ADD ROW AND COLUMN CONSTRAINTS TO CENTER PANE
        for (int i = 0; i < board.GRID_SIZE; i++) {
            centerPane.getRowConstraints().add(rConstrArray[i]);
            centerPane.getColumnConstraints().add(cConstrArray[i]);
        }
        
        // ADD RECTANGLE NODES TO CENTER PANE
        for (int col = 3; col >= 0; col--) {
            for (int row = 3; row >= 0; row--) {
                this.rectGrid[col][row].setFill(Color.GREEN);
                centerPane.add(this.rectGrid[row][col],col,row);
                centerPane.setValignment(this.rectGrid[row][col],VPos.CENTER);
                centerPane.setHalignment(this.rectGrid[row][col],HPos.CENTER);
            }
        }
        // ADD TEXT NODES TO CENTER PANE
        for (int col = 0; col < 4; col ++) {
            for (int row = 0; row < 4; row++) {
                centerPane.add(this.tileGrid[row][col].text,col,row);
                centerPane.setValignment(this.tileGrid[row][col].text,VPos.CENTER);
                centerPane.setHalignment(this.tileGrid[row][col].text,HPos.CENTER);
            }
        }
        // Initial update of GUI
        updateTiles(board.getGrid());
        changeTileColors(tileGrid);
        
        // Set Handler on Scene
        scene.setOnKeyPressed(new myKeyHandler());
        
    }

    /** Add your own Instance Methods Here */

    /* Name: makeRectangles
     * Purpose: Makes rectangles depending on board size
     * Parameters: int boardSize - The board size
     * Return: Rectangle[][] - The grid of rectangles
     */
    private Rectangle[][] makeRectangles(int boardSize) {
        
        Rectangle[][] grid = new Rectangle[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                grid[row][col] = new Rectangle(100,100);
            }
        }
        return grid;
    }
    
    /* Name: makeTexts
     * Purpose: Makes Texts depending on board size
     * Parameters: int boardSize - The board size
     * Return: Text[][] - The grid of Texts
     */
    private Text[][] makeTexts(int boardSize) {
        
        Text[][] grid = new Text[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                grid[row][col] = new Text();
                grid[row][col].setText("0");
                grid[row][col].setFont(Font.font("Times New Roman",
                                                    FontWeight.BOLD, 40));
            }
        }
        return grid;
    }
    
    /* Name: makeTiles
     * Purpose: Makes Tiles depending on board size
     * Parameters: int boardSize - The board size
     * Return: Tile[][] - The grid of Tiles
     */
    private Tile[][] makeTiles(int boardSize) {
    
        Tile[][] grid = new Tile[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                grid[row][col] = new Tile(this.rectGrid[row][col],
                                                  this.textGrid[row][col]);
            }
        }
        return grid;
    }

    /* Name: updateTiles
     * Purpose: Updates the values of the Tiles
     * Parameters: int[][] grid - The grid returned from board.getGrid()
     * Return: void
     */
    private void updateTiles(int[][] grid) {
    
        for (int row = 0; row < board.GRID_SIZE; row++) {
            for (int col = 0; col < board.GRID_SIZE; col++) {
                String s = Integer.toString(grid[row][col]);
                tileGrid[row][col].text.setText(s);

                if (tileGrid[row][col].text.getText().equals("0")) {
                    tileGrid[row][col].text.setVisible(false);
                }
                else {
                    tileGrid[row][col].text.setVisible(true);
                }
            }
        }
    }
    
    /* Name: changeTileColors
     * Purpose: Updates the colors of the Tiles
     * Parameters: Tile[][] grid - The Tile grid
     * Return: void
     */
    public void changeTileColors(Tile[][] grid) {
            
        for (int row = 0; row < board.GRID_SIZE; row++) {
            for (int col = 0; col < board.GRID_SIZE; col++) {
                Tile tile = grid[row][col];
                if (tile.text.getText().equals("2")) {
                    tile.rect.setFill(COLOR_2);
                    tile.text.setFill(COLOR_VALUE_LIGHT);
                }
                else if (tile.text.getText().equals("4")) {
                    tile.text.setFill(COLOR_VALUE_LIGHT);
                    tile.rect.setFill(COLOR_4);
                }
                else if (tile.text.getText().equals("8")) {
                    tile.text.setFill(COLOR_VALUE_LIGHT);
                    tile.rect.setFill(COLOR_8);
                }
                else if (tile.text.getText().equals("0")) {
                    tile.text.setFill(COLOR_VALUE_LIGHT);
                    tile.rect.setFill(COLOR_EMPTY);
                }
                else if (tile.text.getText().equals("16")) {
                    tile.text.setFill(COLOR_VALUE_DARK);
                    tile.rect.setFill(COLOR_16);
                }
                else if (tile.text.getText().equals("32")) {
                    tile.text.setFill(COLOR_VALUE_DARK);
                    tile.rect.setFill(COLOR_32);
                }
                else if (tile.text.getText().equals("64")) {
                    tile.text.setFill(COLOR_VALUE_DARK);
                    tile.rect.setFill(COLOR_64);
                }
                else if (tile.text.getText().equals("128")) {
                    tile.text.setFill(COLOR_VALUE_DARK);
                    tile.rect.setFill(COLOR_128);
                }
                else if (tile.text.getText().equals("256")) {
                    tile.text.setFill(COLOR_VALUE_DARK);
                    tile.rect.setFill(COLOR_256);
                }
                else if (tile.text.getText().equals("512")) {
                    tile.text.setFill(COLOR_VALUE_DARK);
                    tile.text.setFill(COLOR_512);
                }
                else if (tile.text.getText().equals("1024")) {
                    tile.text.setFill(COLOR_VALUE_DARK);
                    tile.rect.setFill(COLOR_1024);
                }
                else if (tile.text.getText().equals("2048")) {
                    tile.text.setFill(COLOR_VALUE_DARK);
                    tile.rect.setFill(COLOR_2048);
                }
                else {
                    tile.text.setFill(COLOR_VALUE_DARK);
                    tile.rect.setFill(COLOR_OTHER);
                }
            }
        }
    }

    /* Name: setScore()
     * Parameters: None
     * Purpose: Updates the score in the GUI
     * Return: void
     */
    private void setScore() {
        this.score.setText("Score: " + board.getScore());
    }
    
    /* Name: makeRowConstraints
     * Purpose: Creates RowConstraints based on percent
     * Parameters: int boardSize - The board size
     *             double percent - The percent height of the GridPane attached to
     * Return: RowConstraints[] - Array of RowConstraints
     */
    private RowConstraints[] makeRowConstraints(int boardSize, double percent) {
        
        RowConstraints[] array = new RowConstraints[boardSize];
        for (int i = 0; i < boardSize; i++) {
            array[i] = new RowConstraints();
            array[i].setPercentHeight(percent);
        }
        return array;
    }

    /* Name: makeColConstraints
     * Purpose: Creates ColumnConstraints based on percent
     * Parameters: int boardSize - The board size
     *             double percent - The percent width of the GridPane attached to
     * Return: ColumnConstraints[] - Array of ColumnConstraints
     */
    private ColumnConstraints[] makeColConstraints(int boardSize, double percent) {
        
        ColumnConstraints[] array = new ColumnConstraints[boardSize];
        for (int i = 0; i < boardSize; i++) {
            array[i] = new ColumnConstraints();
            array[i].setPercentWidth(percent);
        }
        return array;
    }

    /* Name: Tile
     * Purpose: Points to Rectangles and their corresponding Texts for easier
     *          management.
     * Parameters: Rectangle rect - The rectangle
     *             Text text - The associated number for Rectangle
     */
    private class Tile {

        public Rectangle rect;
        public Text text;

        public Tile(Rectangle r, Text t) {
            
            this.rect = r;
            this.text = t;
        }
    }

    /* Name: myKeyHandler
     * Purpose: Handles keyboard inputs for the game. Implements EventHandler.
     * Parameters: None
     */
    private class myKeyHandler implements EventHandler<KeyEvent> {
        
        /* Name: handle
         * Purpose: The method that handles key events and executes Board
         *          methods.
         * Parameters: KeyEvent e - The key
         */
        @Override
        public void handle(KeyEvent e) {
            
            if (e.getCode() == KeyCode.UP) {
                if (board.canMove(Direction.UP)) {
                    System.out.println("Moving Up");
                    board.move(Direction.UP);
                    board.addRandomTile();
                }
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                if (board.canMove(Direction.RIGHT)) {
                    System.out.println("Moving Right");
                    board.move(Direction.RIGHT);
                    board.addRandomTile();
                }
            }
            else if (e.getCode() == KeyCode.LEFT) {
                if (board.canMove(Direction.LEFT)) {
                    System.out.println("Moving Left");
                    board.move(Direction.LEFT);
                    board.addRandomTile();
                }
            }
            else if (e.getCode() == KeyCode.DOWN) {
                if (board.canMove(Direction.DOWN)) {
                    System.out.println("Moving Down");
                    board.move(Direction.DOWN);
                    board.addRandomTile();
                }
            }
            else if (e.getCode() == KeyCode.Q) {
                System.exit(1);
            }
            else if (e.getCode() == KeyCode.S) {
                try {
                    board.saveBoard(outputBoard);
                } catch (IOException exception) {
                    System.out.println("saveBoard threw an Exception");
                }
                System.out.println("Saving Board to " + outputBoard);
            }
            else {
                return;
            }

            setScore();
            updateTiles(board.getGrid());
            changeTileColors(tileGrid);
            
            // Move gameOverPane and gameOverText to front
            if (board.isGameOver()) {
                centerGameOverPane.toFront();
                gameOverText.toFront();
                topGameOverPane.toFront();
            }
        }
    }
    



    /** DO NOT EDIT BELOW */

    // The method used to process the command line arguments
    private void processArgs(String[] args)
    {
        String inputBoard = null;   // The filename for where to load the Board
        int boardSize = 0;          // The Size of the Board

        // Arguments must come in pairs
        if((args.length % 2) != 0)
        {
            printUsage();
            System.exit(-1);
        }

        // Process all the arguments 
        for(int i = 0; i < args.length; i += 2)
        {
            if(args[i].equals("-i"))
            {   // We are processing the argument that specifies
                // the input file to be used to set the board
                inputBoard = args[i + 1];
            }
            else if(args[i].equals("-o"))
            {   // We are processing the argument that specifies
                // the output file to be used to save the board
                outputBoard = args[i + 1];
            }
            else if(args[i].equals("-s"))
            {   // We are processing the argument that specifies
                // the size of the Board
                boardSize = Integer.parseInt(args[i + 1]);
            }
            else
            {   // Incorrect Argument 
                printUsage();
                System.exit(-1);
            }
        }

        // Set the default output file if none specified
        if(outputBoard == null)
            outputBoard = "2048.board";
        // Set the default Board size if none specified or less than 2
        if(boardSize < 2)
            boardSize = 4;

        // Initialize the Game Board
        try{
            if(inputBoard != null)
                board = new Board(inputBoard, new Random());
            else
                board = new Board(boardSize, new Random());
        }
        catch (Exception e)
        {
            System.out.println(e.getClass().getName() + " was thrown while creating a " +
                               "Board from file " + inputBoard);
            System.out.println("Either your Board(String, Random) " +
                               "Constructor is broken or the file isn't " +
                               "formated correctly");
            System.exit(-1);
        }
    }

    // Print the Usage Message 
    private static void printUsage()
    {
        System.out.println("Gui2048");
        System.out.println("Usage:  Gui2048 [-i|o file ...]");
        System.out.println();
        System.out.println("  Command line arguments come in pairs of the form: <command> <argument>");
        System.out.println();
        System.out.println("  -i [file]  -> Specifies a 2048 board that should be loaded");
        System.out.println();
        System.out.println("  -o [file]  -> Specifies a file that should be used to save the 2048 board");
        System.out.println("                If none specified then the default \"2048.board\" file will be used");
        System.out.println("  -s [size]  -> Specifies the size of the 2048 board if an input file hasn't been");
        System.out.println("                specified.  If both -s and -i are used, then the size of the board");
        System.out.println("                will be determined by the input file. The default size is 4.");
    }
}
