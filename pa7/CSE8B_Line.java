import java.awt.*;
import objectdraw.*;

/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Filename: CSE8B_Line.java
 *
 * This file contains the line class for this project. A line has
 * a start and end point.
 */

/* Name: CSE8B_Line
 * Purpose: This class represents a line. It is a subclass of Shape.
 *          The line has a start and end point.
 * Parameters: Point start - The starting point
 *             Point end - The ending point
 */
public class CSE8B_Line extends Shape {

    private Point start;
    private Point end;

    public CSE8B_Line() {
        
        super("CSE8B_Line");
        this.start = new Point();
        this.end = new Point();
    }

    public CSE8B_Line(Point start, Point end) {

        super("CSE8B_Line");
        this.start = start;
        this.end = end;
    }

    public CSE8B_Line(CSE8B_Line line) {
        
        super(line.getName());
        this.setStart(new Point(line.getStart()));
        this.setEnd(new Point(line.getEnd()));
    }

    /* Name: move
     * Purpose: Moves the line
     * Parameters: int xDelta - How much to move in x-direction
     *             int yDelta - How much to move in y-direction
     * Return: void
     */
    public void move(int xDelta, int yDelta) {
    
        this.getStart().move(xDelta,yDelta);
        this.getEnd().move(xDelta,yDelta);
    }

    /* Name: toString
     * Purpose: Prints out the start and end points.
     * Parameters: None
     * Return: String - The string containing information.
     */
    @Override
    public String toString() {
        
        String s = this.getName() + ": "
                    + this.getStart().toString()
                    + " to " + this.getEnd().toString();

        return s;
    }

    /* Name: equals
     * Purpose: Check if the parameter is equal to the reference
     * Parameters: Object 0 - The object to check
     * Return: boolean - True or false
     */ 
    @Override
    public boolean equals(Object o) {
        
        if (o instanceof CSE8B_Line) {
            if (this.getStart().equals(((CSE8B_Line)o).getStart())
                && this.getEnd().equals(((CSE8B_Line)o).getEnd())) {
                return true;
            }
        }
        return false;
    }

    /* Name: hashCode
     * Purpose: Returns the hashcode of the reference
     * Parameters: None
     * Return: int - The hashcode
     */
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    /* Name: draw
     * Purpose: Draws the line onto the canvas
     * Parameters: DrawingCanvas canvas - The canvas to draw on
     *             Color c - The color of the line
     *             boolean fill - Fill the line or not
     * Return: void
     */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {

        new Line(this.getStart().getX(),
                    this.getStart().getY(),
                    this.getEnd().getX(),
                    this.getEnd().getY(),canvas).setColor(c);
    }

    /* Name: getStart
     * Purpose: Get the start point of the line
     * Parameter: None
     * Return: Point - The start point
     */
    public Point getStart() {
        return this.start;
    }

    /* Name: setStart
     * Purpose: Set a new start point
     * Parameters: Point p - The new start point
     * Return: void
     */
    private void setStart(Point p) {
        this.start = p;
    }
    
    /* Name: getEnd
     * Purpose: Get the end point
     * Parameters: None
     * Return: Point - The end point
     */
    public Point getEnd() {
        return this.end;
    }
    
    /* Name: setEnd
     * Purpose: Sets a new end point
     * Parameters: Point p - The new end point
     * Return: void
     */
    private void setEnd(Point p) {
        this.end = p;
    }
}
