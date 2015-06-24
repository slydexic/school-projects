
/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Filename: CS8BTurtle.java
 * Date: May 31, 2015
 *
 * This file contains the CS8BTurtle class, which makes turtles draw
 * onto a canvas, also know as the "World".
 */

import turtleClasses.*;
import java.awt.Color;


/* Name: CS8BTurtle
 * Purpose: This class extends the Turtle class. CS8BTurtle objects behave
 *          just like Turtle objects except there are specific methods
 *          to draw letters and numbers.
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
 */
public class CS8BTurtle extends Turtle {

    private final static int CHAR_WIDTH = 40;
    private final static int CHAR_HEIGHT = 80;
    private final static int PADDING = 40;
    private final static int LINE_SPACING = CHAR_HEIGHT + PADDING;

    private final static int START_X = 10;
    private final static int START_Y = 10;

    private final static int CENTER_X = 4*PADDING;
    private final static int CENTER_Y = 2*PADDING;

    private final static int PEN_WIDTH = 10;
    private final static Color PEN_COLOR = Color.BLUE;

    private final static int WORLD_WIDTH = 800;
    private final static int WORLD_HEIGHT = 500;

    private final static int DELAY = 500;

    public CS8BTurtle(World w, int delay) {
        super(w,delay);
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

    
    public static void main(String[] args) {
        
        World w = new World(WORLD_WIDTH,WORLD_HEIGHT);
        CS8BTurtle myTurtle = new CS8BTurtle(w,DELAY);

        myTurtle.setPenWidth(PEN_WIDTH);
        myTurtle.setPenColor(PEN_COLOR);

        myTurtle.drawC(START_X + CENTER_X,START_Y + CENTER_Y);
        myTurtle.drawS(START_X + (2*PADDING) + CENTER_X,START_Y + CENTER_Y);
        myTurtle.draw8(START_X + (4*PADDING) + CENTER_X,START_Y + CENTER_Y);
        myTurtle.drawB(START_X + (6*PADDING) + CENTER_X,START_Y + CENTER_Y);
        myTurtle.drawE(START_X + (8*PADDING) + CENTER_X,START_Y + CENTER_Y);
        myTurtle.drawQ(START_X + (10*PADDING) + CENTER_X,START_Y + CENTER_Y);


        myTurtle.drawS(START_X + CENTER_X, 
                        START_Y + (LINE_SPACING) + CENTER_Y);
        myTurtle.drawP(START_X + (2*PADDING) + CENTER_X,
                        START_Y + (LINE_SPACING) + CENTER_Y);

        myTurtle.drawR(START_X + (4*PADDING) + CENTER_X,
                        START_Y + (LINE_SPACING) + CENTER_Y);

        myTurtle.drawI(START_X + (6*PADDING) + CENTER_X,
                        START_Y + (LINE_SPACING) + CENTER_Y);

        myTurtle.drawN(START_X + (8*PADDING) + CENTER_X,
                        START_Y + (LINE_SPACING) + CENTER_Y);

        myTurtle.drawG(START_X + (10*PADDING) + CENTER_X,
                        START_Y + (LINE_SPACING) + CENTER_Y);


        myTurtle.draw2(START_X + (2*PADDING) + CENTER_X,
                        START_Y + (2*LINE_SPACING) + CENTER_Y);

        myTurtle.draw0(START_X + (4*PADDING) + CENTER_X,
                        START_Y + (2*LINE_SPACING) + CENTER_Y);

        myTurtle.draw1(START_X + (6*PADDING) + CENTER_X,
                        START_Y + (2*LINE_SPACING) + CENTER_Y);

        myTurtle.drawS(START_X + (8*PADDING) + CENTER_X,
                        START_Y + (2*LINE_SPACING) + CENTER_Y);
    }

}
