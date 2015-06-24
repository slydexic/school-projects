import java.awt.*;
import objectdraw.*;

/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Filename: Rectangle.java
 *
 * This file contains the Rectangle class.
 */

/* Name: Rectangle
 * Purpose: Creates a rectangle with width, height, with upper left
 *          corner inherited from ARectangle.
 * Parameters: int width - The width
 *             int height - the height
 */
public class Rectangle extends ARectangle {

    private int width;
    private int height;

    public Rectangle() {
        
        super();
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(int x, int y, int width, int height) {
        
        super("Rectangle",x,y);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point upperLeft, int width, int height) {

        super("Rectangle",upperLeft);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle r) {
     
        super(r);
        this.setWidth(r.getWidth());
        this.setHeight(r.getHeight());
    }

    /* Name: toString
     * Purpose: Returns a String that gives the dimension and position
     *          of the rectangle
     * Parameters: None
     * Return: String - The String with information
     */
    @Override
    public String toString() {
        
        String s = this.getName() + ": Upper Left Corner: "
                    + this.getUpperLeft().toString()
                    +  " Width: " + getWidth()
                    + " Height: " + getHeight();
        return s;
    }

    /* Name: equals
     * Purpose: Checks if parameter and reference are equal
     * Parameters: Object o - The object to check
     * Return: boolean - True or false
     */
    @Override
    public boolean equals(Object o) {

        int x = this.getUpperLeft().getX();
        int y = this.getUpperLeft().getY();
        
        if (o instanceof Rectangle) {
            if ((this.getWidth() == ((Rectangle)o).getWidth())
                  && (this.getHeight() == ((Rectangle)o).getHeight())
                  && (this.getUpperLeft().equals(((Rectangle)o).getUpperLeft()))) {

                return true;
            }
        }
        return false;
    }

    /* Name: draw
     * Purpose: Draws the rectangle onto the canvas
     * Parameters: Drawing canvas - The canvas to draw on
     *             Color c - The color of the shape
     *             boolean fill - Whether to fill the rectangle or not
     * Return: void
     */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {

        if (c == null) {
            c = Color.BLACK;
        }

        if (fill) {
            new FilledRect(this.getUpperLeft().getX(),
                            this.getUpperLeft().getY(),
                            this.getWidth(),this.getHeight(),
                                            canvas).setColor(c);
        }
        else {
            new FramedRect(this.getUpperLeft().getX(),
                            this.getUpperLeft().getY(),
                            this.getWidth(),this.getHeight(),
                                            canvas).setColor(c);
        }
    }
    
    /* Name: getWidth
     * Purpose: Returns the width of rectangle
     * Parameter: None
     * Return: int - The width
     */
    public int getWidth() {
        return this.width;
    }

    /* Name: setWidth
     * Purpose: Sets a new width
     * Parameters: int w - The new width
     * Return: void
     */
    private void setWidth(int w) {
        this.width = w;
    }

    /* Name: getHeight
     * Purpose: Returns the height
     * Parameters: none
     * Return; int - The height
     */
    public int getHeight() {
        return this.height;
    }

    /* Name: setHeight
     * Purpose: sets new height
     * Parameters: int h - The new height
     * Return: None
     */
    private void setHeight(int h) {
        this.height = h;
    }
}
