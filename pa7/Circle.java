import java.awt.*;
import objectdraw.*;

/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Filename: Circle.java
 *
 * This file contains the Circle class which is a subclass of Shape.
 * This class creates a circle using a Point object.
 */

/* Name: Circle
 * Parameters: Point center - The center location of the Circle
 *             int radius - The radius of the circle
 * Purpose: Creates and manipulates circles.
 */
public class Circle extends Shape {

    private Point center;
    private int radius;

    public Circle() {

        super("Circle");
        this.center = new Point();
        this.radius = 0;
    }

    public Circle(Point center, int radius) {

        super("Circle");
        this.center = center;
        this.radius = radius;
    }

    public Circle(Circle c) {
     
        super(c.getName());
        this.setCenter(new Point(c.getCenter()));
        this.setRadius(c.getRadius());
    }

    /* Name: Move
     * Purpose: Moves the circle
     * Parameters: int xDelta - How much to move in x-direction
     *             int yDelta - How much to move in y-direction
     * Return: void
     */
    public void move(int xDelta, int yDelta) {
        
        this.getCenter().move(xDelta,yDelta);
    }
    
    /* Name: toString
     * Purpose: Returns a String that says the location and
     *          radius of the Circle.
     * Parameters: None
     * Return: String - The circle's information.
     */
    @Override
    public String toString() {
        
        String s = this.getName() + ": Center: "
                    + this.getCenter().toString()
                    + "; " + "Radius: " + this.getRadius();
        return s;
    }

    /* Name: equals
     * Purpose: Checks if the parameter is equal to the reference
     * Parameters: Object 0 - The object to compare
     * Return: boolean - True or False
     */
    @Override
    public boolean equals(Object o) {

        if (o instanceof Circle) {
            if (this.getCenter().equals(((Circle)o).getCenter())
                && (getRadius() == ((Circle)o).getRadius())) {

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
     * Purpose: Draws the circle
     * Parameters: DrawingCanvas canvas - The canvas to draw on.
     *             Color c - The color of the circle
     *             boolean fill - Fill the circle or not
     * Return: void
     */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {
       
        // The upper left corner of the invisible rectangle that
        // covers the circle.
        double x = getCenter().getX() - getRadius();
        double y = getCenter().getY() - getRadius();

        if (c == null) {
            c = Color.BLACK;
        }

        if (fill) {
            new FilledOval(x,y,2*getRadius(),2*getRadius(),canvas).setColor(c);
        }
        else {
            new FramedOval(x,y,2*getRadius(),2*getRadius(),canvas).setColor(c);
        }
    }

    /* Name: getCenter
     * Purpose: Returns the center point of the circle
     * Parameters: None
     * Return: Point - The center
     */
    public Point getCenter() {
        return this.center;
    }
    
    /* Name: setCenter
     * Purpose: Sets the new center of the circle
     * Parameters: Point p - The new center.
     * Return: void
     */
    private void setCenter(Point p) {
        this.center = p;
    }
    
    /* Name: getRadius
     * Purpose: Returns the radius of the circle
     * Parameters: None
     * Return: int - The radius
     */
    public int getRadius() {
        return this.radius;
    }
    
    /* Name: setRadius
     * Purpose: Sets a new radius to the circle
     * Parameters: int r - The new radius
     * Return: void
     */
    private void setRadius(int r) {
        this.radius = r;
    }

}
