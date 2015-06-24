
/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Filename: CS8BTurtle_Threaded.java
 * Date: May 31, 2015
 *
 * This file contains the CS8BTurtle_Threaded class, which makes turtles draw
 * onto a canvas, also know as the "World". This class uses threading.
 */

import turtleClasses.*;
import java.awt.Color;

/* Name: CS8BTurtle_Threaded
 * Purpose: This class extends the Turtle class. CS8BTurtle objects behave
 *          just like Turtle objects except there are specific methods
 *          to draw letters and numbers. This class uses threading to
 *          allow multiple turtles draw simultaneously.
 * Parameters: int CHAR_WIDTH - The max width a character should take
 *             int CHAR_HEIGHT - The max height a character should take
 *             int PADDING - The distance between all characters
 *             int LINE_SPACING - The distance from the top of a character
 *                                to the top of the character below it
 *             int START_X - The starting position of the character in
 *                           the x coordinate
 *             int START_Y - The starting position of the character in
 *                           the y coordinate
 *             int CENTER_X - The value added to the x position to center
 *                            the character
 *             int CENTER_Y - The value added to the y position to center
 *                            the character
 *             int PEN_WIDTH - The pen width
 *             Color PEN_COLOR - The pen color
 *             int WORLD_WIDTH - The width of the world
 *             int WORLD_HEIGHT - The height of the world
 *             int DELAY - The delay to show turtles drawing
 *             char ch - The character associated with the turtle
 *             int x,y - The x and y position of the turtle
 */

public class CS8BTurtle_Threaded extends Turtle implements Runnable {

    private final static int CHAR_WIDTH = 40;
    private final static int CHAR_HEIGHT = 80;
    private final static int PADDING = 40;
    private final static int LINE_SPACING = CHAR_HEIGHT + PADDING;

    private final static int START_X = 10;
    private final static int START_Y = 10;

    private final static int PEN_WIDTH = 10;
    private final static Color PEN_COLOR = Color.BLUE;

    private final static int WORLD_WIDTH = 800;
    private final static int WORLD_HEIGHT = 500;

    private final static int DELAY = 500;

    private char ch;
    private int x,y;

    private final static int CENTER_X = PADDING*4;
    private final static int CENTER_Y = PADDING*2;


    public CS8BTurtle_Threaded(World w, char ch, int x, int y, int delay) {
        super(w,delay);

        this.ch = ch; // Associated character for each turtle
        // Turtle's x and y starting position
        this.x = x;
        this.y = y;

        setPenWidth(PEN_WIDTH);
        setPenColor(PEN_COLOR);

        // Turtle will be passed into a thread and the thread will start
        new Thread(this).start();
    }

    /* Name: drawC
     * Purpose: draw the letter C
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */    
    public void drawC(int x, int y) {

        penUp();
        moveTo(x,y);
        turnToFace(getXPos() + 1, getYPos());
        penDown();
        forward(CHAR_WIDTH);
        backward(CHAR_WIDTH);
        turnRight();
        forward(CHAR_HEIGHT);
        turnLeft();
        forward(CHAR_WIDTH);
        
    }

    /* Name: drawS
     * Purpose: draw the letter S
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */
    public void drawS(int x, int y) {

        penUp();
        moveTo(x,y);
        turnToFace(getXPos() + 1, getYPos());
        penDown();
        forward(CHAR_WIDTH);
        backward(CHAR_WIDTH);
        turnRight();
        forward(CHAR_HEIGHT/2);
        turnLeft();
        forward(CHAR_WIDTH);
        turnRight();
        forward(CHAR_HEIGHT/2);
        turnLeft();
        backward(CHAR_WIDTH);
    }

    /* Name: draw8
     * Purpose: draw the number 8
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */
    public void draw8(int x,int y) {
        
        penUp();
        moveTo(x,y);
        turnToFace(getXPos() + 1, getYPos());
        penDown();
        forward(CHAR_WIDTH);
        turnRight();
        forward(CHAR_HEIGHT);
        turnRight();
        forward(CHAR_WIDTH);
        turnRight();
        forward(CHAR_HEIGHT);
        backward(CHAR_HEIGHT/2);
        turnRight();
        forward(CHAR_WIDTH);
    }

    /* Name: drawB
     * Purpose: draw the letter B
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */
    public void drawB(int x, int y) {
        
        penUp();
        moveTo(x,y);
        penDown();
        turnToFace(getXPos() + 1, getYPos());
        turn(30);
        forward(CHAR_WIDTH);
        turn(120);
        forward(CHAR_WIDTH);
        turn(-120);
        forward(CHAR_WIDTH);
        turn(120);
        forward(CHAR_WIDTH);
        turnToFace(getXPos(),getYPos() - 1);
        forward(CHAR_HEIGHT);

    }

    /* Name: drawE
     * Purpose: draw the letter E
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */
    public void drawE(int x, int y) {
        
        penUp();
        moveTo(x,y);
        penDown();
        turnToFace(getXPos() + 1,getYPos());
        forward(CHAR_WIDTH);
        backward(CHAR_WIDTH);
        turnRight();
        forward(CHAR_HEIGHT/2);
        turnLeft();
        forward(CHAR_WIDTH);
        backward(CHAR_WIDTH);
        turnRight();
        forward(CHAR_HEIGHT/2);
        turnLeft();
        forward(CHAR_WIDTH);
    }


    /* Name: drawQ
     * Purpose: draw the letter Q
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */
    public void drawQ(int x, int y) {
        
        penUp();
        moveTo(x,y);
        turnToFace(getXPos() + 1, getYPos());
        penDown();
        forward(CHAR_WIDTH*5/6);
        turnRight();
        forward(CHAR_HEIGHT*7/8);
        turnRight();
        forward(CHAR_WIDTH*5/6);
        turnRight();
        forward(CHAR_HEIGHT*7/8);

        turnToFace(getXPos() + 1, getYPos());
        forward(CHAR_WIDTH*5/6);
        turnRight();
        forward(CHAR_HEIGHT*7/8);
        turnToFace(getXPos() + 1, getYPos() + 1);
        forward(CHAR_WIDTH*1/6);
        backward(CHAR_WIDTH*4/6);
    }

    /* Name: drawP
     * Purpose: draw the letter P
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */
    public void drawP(int x, int y) {
        
        penUp();
        moveTo(x,y);
        turnToFace(getXPos() + 1, getYPos());
        penDown();
        forward(CHAR_WIDTH);
        turnRight();
        forward(CHAR_HEIGHT/2);
        turnRight();
        forward(CHAR_WIDTH);
        turnRight();
        forward(CHAR_HEIGHT/2);
        backward(CHAR_HEIGHT);
    }

    /* Name: drawR
     * Purpose: draw the letter R
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */
    public void drawR(int x, int y) {
        
        drawP(x,y);
        turnToFace(getXPos(), getYPos() - 1);
        forward(CHAR_HEIGHT/2);
        turnToFace(getXPos() + 1, getYPos() + 1);
        forward(CHAR_HEIGHT*2/3);
    }

    /* Name: drawN
     * Purpose: draw the letter N
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */
    public void drawN(int x, int y) {
        
        penUp();
        moveTo(x,y);
        penDown();
        turnToFace(getXPos(), getYPos() + 1);
        forward(CHAR_HEIGHT);

        int valueX = getXPos();
        int valueY = getYPos();

        backward(CHAR_HEIGHT);
        turnToFace(valueX + CHAR_WIDTH, valueY);
        forward(CHAR_HEIGHT*9/8);
        turnToFace(getXPos(), getYPos() - 1);
        forward(CHAR_HEIGHT);
    }

    /* Name: drawI
     * Purpose: draw the letter I
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */
    public void drawI(int x, int y) {
        
        penUp();
        moveTo(x,y);
        penDown();
        turnToFace(getXPos() + 1, getYPos());
        forward(CHAR_WIDTH);
        backward(CHAR_WIDTH/2);
        turnRight();
        forward(CHAR_HEIGHT);
        turnLeft();
        forward(CHAR_WIDTH/2);
        backward(CHAR_WIDTH);
    }

    /* Name: drawG
     * Purpose: draw the letter G
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */
    public void drawG(int x, int y) {
    
        penUp();
        moveTo(x,y);
        penDown();
        turnToFace(getXPos() + 1, getYPos());
        forward(CHAR_WIDTH);
        backward(CHAR_WIDTH);
        turnRight();
        forward(CHAR_HEIGHT);
        turnLeft();
        forward(CHAR_WIDTH);
        turnLeft();
        forward(CHAR_HEIGHT/2);
        turnLeft();
        forward(CHAR_WIDTH/2);
    }

    /* Name: draw2
     * Purpose: draw the number 2
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */
    public void draw2(int x, int y) {
    
        penUp();
        moveTo(x,y);
        penDown();
        turnToFace(getXPos() + 1, getYPos());
        forward(CHAR_WIDTH);
        turnRight();
        forward(CHAR_HEIGHT/2);
        turnRight();
        forward(CHAR_WIDTH);
        turnLeft();
        forward(CHAR_HEIGHT/2);
        turnLeft();
        forward(CHAR_WIDTH);
    }

    /* Name: draw0
     * Purpose: draw the number 0
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */
    public void draw0(int x, int y) {
        
        penUp();
        moveTo(x,y);
        penDown();
        turnToFace(getXPos() + 1, getYPos());
        forward(CHAR_WIDTH);
        turnRight();
        forward(CHAR_HEIGHT);
        turnRight();
        forward(CHAR_WIDTH);
        turnRight();
        forward(CHAR_HEIGHT);
    }

    /* Name: draw1
     * Purpose: draw the number 1
     * Parameters: int x - x coordinate
     *             int y - y coordinate
     * Return: void
     */
    public void draw1(int x, int y) {
        
        penUp();
        moveTo(x,y);
        turnToFace(getXPos() + 1, getYPos());
        forward(CHAR_WIDTH/2);
        turnRight();
        penDown();
        forward(CHAR_HEIGHT);
        turnLeft();
        forward(CHAR_WIDTH/2);
        backward(CHAR_WIDTH);
        forward(CHAR_WIDTH/2);
        turnLeft();
        forward(CHAR_HEIGHT);
        turnToFace(getXPos() - 1, getYPos() + 1);
        forward(CHAR_WIDTH/3);
    }

    /* Name: drawPokeball
     * Purpose: Draws a Pokeball from the Pokemon series
     * Parameters: int x,y - The starting X and Y position of the turtle
     * Return: Void
     */
    public void drawPokeball(int x, int y) {
    
         penUp();
         moveTo(x,y);
         turnToFace(getXPos() + 1, getYPos());
         setPenColor(Color.BLACK);
         penDown();
         forward(2*CHAR_WIDTH);
         turnRight();
         forward(2*CHAR_WIDTH);
         turnRight();
         forward(2*CHAR_WIDTH);
         turnRight();
         forward(2*CHAR_WIDTH);
         backward(PEN_WIDTH);
         turnRight();
         forward(PEN_WIDTH);
         int position_X = getXPos();
         int position_Y = getYPos();

         setPenColor(Color.RED);
         for (int i = 1; i <= 3; i++) {

            forward(2*CHAR_WIDTH - (2*PEN_WIDTH));
            penUp();
            moveTo(position_X,position_Y + (i*PEN_WIDTH));
            penDown();
         }

         setPenColor(Color.BLACK);
         forward(((2*CHAR_WIDTH) - (2*PEN_WIDTH))/3);
         penUp();
         forward(PEN_WIDTH);
         penDown();
         setPenWidth(4);
         forward(2);
         setPenWidth(10);
         penUp();
         forward(PEN_WIDTH);
         penDown();
         forward(((2*CHAR_WIDTH) - (2*PEN_WIDTH))/3);

         penUp();
         setPenWidth(2);
         moveTo(position_X,position_Y + ((4*PEN_WIDTH) - 5));
         forward(2*PEN_WIDTH + (PEN_WIDTH/2) - 1);
         penDown();
         forward(PEN_WIDTH + 4);
         setVisible(false);



    }

    /* Name: run
     * Purpose: Implemented from Runnable interface. This method will
     *          be called when a Thread is started. Thus, each turtle
     *          will call this method.
     * Parameters: None
     * Return: void
     */
    public void run() {
        
        switch(this.ch) {
            case 'C': this.drawC(this.x,this.y); break;
            case 'S': this.drawS(this.x,this.y); break;
            case 'E': this.drawE(this.x,this.y); break;
            case '8': this.draw8(this.x,this.y); break;
            case 'B': this.drawB(this.x,this.y); break;
            case 'Q': this.drawQ(this.x,this.y); break;
            case 'P': this.drawP(this.x,this.y); break;
            case 'R': this.drawR(this.x,this.y); break;
            case 'I': this.drawI(this.x,this.y); break;
            case 'N': this.drawN(this.x,this.y); break;
            case 'G': this.drawG(this.x,this.y); break;
            case '2': this.draw2(this.x,this.y); break;
            case '0': this.draw0(this.x,this.y); break;
            case '1': this.draw1(this.x,this.y); break;
            case '5': this.drawS(this.x,this.y); break;
            case 'p': this.drawPokeball(this.x,this.y); break;
        }
   }

    public static void main(String[] args) {
        
        World w = new World(WORLD_WIDTH,WORLD_HEIGHT);


        new CS8BTurtle_Threaded(w,'C',
                                START_X + CENTER_X,START_Y + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'S',
                                START_X + (2*PADDING) + CENTER_X,
                                            START_Y + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'8',
                                START_X + (4*PADDING) + CENTER_X,
                                            START_Y + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'B',
                                START_X + (6*PADDING) + CENTER_X,
                                            START_Y + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'E',
                                START_X + (8*PADDING) + CENTER_X,
                                            START_Y + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'Q',
                                START_X + (10*PADDING) + CENTER_X,
                                            START_Y + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'S',
                                START_X + CENTER_X,
                                START_Y + (LINE_SPACING) + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'P',
                                  START_X + (2*PADDING) + CENTER_X,
                                  START_Y + (LINE_SPACING) + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'R',
                                  START_X + (4*PADDING) + CENTER_X,
                                  START_Y + (LINE_SPACING) + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'I',
                                  START_X + (6*PADDING) + CENTER_X,
                                  START_Y + (LINE_SPACING) + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'N',
                                  START_X + (8*PADDING) + CENTER_X,
                                  START_Y + (LINE_SPACING) + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'G',
                                  START_X + (10*PADDING) + CENTER_X,
                                  START_Y + (LINE_SPACING) + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'2',
                                  START_X + (2*PADDING) + CENTER_X,
                                  START_Y + (2*LINE_SPACING) + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'0',
                                  START_X + (4*PADDING) + CENTER_X,
                                  START_Y + (2*LINE_SPACING) + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'1',
                                  START_X + (6*PADDING) + CENTER_X,
                                  START_Y + (2*LINE_SPACING) + CENTER_Y,DELAY);
        new CS8BTurtle_Threaded(w,'5',
                                  START_X + (8*PADDING) + CENTER_X,
                                  START_Y + (2*LINE_SPACING) + CENTER_Y,DELAY);

        new CS8BTurtle_Threaded(w,'p',
                                  START_X + (10*PADDING) + CENTER_X,
                                  START_Y + (2*LINE_SPACING) + CENTER_Y,DELAY);
        }

}
