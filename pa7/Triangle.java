import java.awt.*;
import objectdraw.*;

/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Filename: Triangle.java
 *
 * This file contains the Triangle class. It is a subclass of Shape.
 */

/* Name: Triangle
 * Purpose: Creates a triangle with 3 points to connect.
 * Parameters: Point p1 - First point
 *             Point p2 - Second point
 *             Point p3 - Third point
 */

public class Triangle extends Shape {

    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle() {
        
        super("Triangle");
        this.p1 = new Point();
        this.p2 = new Point();
        this.p3 = new Point();
    }

    public Triangle(Point p1, Point p2, Point p3) {
        
        super("Triangle");
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Triangle(Triangle tri) {
        
        super(tri.getName());
        this.setp1(new Point(tri.getp1()));
        this.setp2(new Point(tri.getp2()));
        this.setp3(new Point(tri.getp3()));
    }

    public void move(int xDelta, int yDelta) {
     
        this.getp1().move(xDelta,yDelta);
        this.getp2().move(xDelta,yDelta);
        this.getp3().move(xDelta,yDelta);
    }

    /* Name: toString
     * Purpose: Returns a String with the three points
     * Parameters: None
     * Return: String - The string with information
     */
    @Override
    public String toString() {

        String s = this.getName() + ": "
                    + this.getp1().toString() + ", "
                    + this.getp2().toString() + ", "
                    + this.getp3().toString();

        return s;
    }
    
    /* Name: equals
     * Purpose: Checks if the parameter is equal to the reference
     * Parameters: Object o - The object to check
     * Return: boolean - True or false
     */
    @Override
    public boolean equals(Object o) {

        
        if (o instanceof Triangle) {
            if ((this.getp1().equals(((Triangle)o).getp1()))
                  && (this.getp2().equals(((Triangle)o).getp2()))
                  && (this.getp3().equals(((Triangle)o).getp3()))) {
                  
                return true;
            }
        }
        return false;
    }

    /* Name: hashCode
     * Purpose: Returns the hashcode of reference
     * Parameters: None
     * Return: int - The hashcode
     */
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    /* Name: draw
     * Purpose: Draws the triangle onto the canvas
     * Parameters: Drawing canvas - The canvas to draw on
     *             Color c - The color of the triangle
     *             boolean fill - Whether to fill the triangle or not
     * Return: void
     */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {

        int p1X = this.getp1().getX();
        int p1Y = this.getp1().getY();
        int p2X = this.getp2().getX();
        int p2Y = this.getp2().getY();
        int p3X = this.getp3().getX();
        int p3Y = this.getp3().getY();


        if (c == null) {
            c = Color.BLACK;
        }

        if (fill) {

            new Line(p1X,p1Y,p2X,p2Y,canvas).setColor(c);
            new Line(p2X,p2Y,p3X,p3Y,canvas).setColor(c);
            new Line(p3X,p3Y,p1X,p1Y,canvas).setColor(c);
        }
        else {

            new Line(p1X,p1Y,p2X,p2Y,canvas).setColor(c);
            new Line(p2X,p2Y,p3X,p3Y,canvas).setColor(c);
            new Line(p3X,p3Y,p1X,p1Y,canvas).setColor(c);
        }

    }

    /* Name: getp1
     * Purpose: returns first point
     * Parameters: None
     * Return: Point - The first point
     */
    public Point getp1() {
        return this.p1;
    }
    
    /* Name: getp2
     * Purpose: returns second point
     * Parameters: None
     * Return: Point - the second point
     */
    public Point getp2() {
        return this.p2;
    }
    
    /* Name: getp3
     * Purpose: returns third point
     * Parameters: None
     * Return: Point - Third point
     */
    public Point getp3() {
        return this.p3;
    }

    /* Name: setp1
     * Purpose: sets new first point
     * Parameters: Point p - The new second point
     * Return: void
     */
    private void setp1(Point p) {
        this.p1 = p;
    }

    /* Name: setp2
     * Purpose: sets new second point
     * Parameters: Point p - new second point
     * Return: void
     */
    private void setp2(Point p) {
        this.p2 = p;
    }

    /* Name: setp3
     * Purpose: sets new third point
     * Parameters: Point p - new third point
     * Return: void
     */
    private void setp3(Point p) {
        this.p3 = p;
    }
}
