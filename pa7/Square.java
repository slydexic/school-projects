import java.awt.*;
import objectdraw.*;

/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Filename: Square.java
 *
 * This file contains the Square class.
 */

/* Name: Square
 * Purpose: The Square class extends the Shape class. It has a side length.
 * Parameters: int side - The length of each side of the square
 */
public class Square extends ARectangle {

    private int side;

    public Square() {
    
        super();
        this.side = 0;
    }

    public Square(int x, int y, int side) {
        
        super("Square",x,y);
        this.side = side;
    }

    public Square(Point upperLeft, int side) {
        
        super("Square",upperLeft);
        this.side = side;
    }

    public Square(Square r) {
        
        super(r);
        this.setSide(r.getSide());
    }

    /* Name: toString
     * Purpose: Returns a String of where the points are located
     * Parameters: None
     * Return: String - The String with information
     */
    @Override
    public String toString() {

        String s = this.getName() + ": Upper Left Corner: "
                    + this.getUpperLeft().toString()
                    + " Sides: " + this.getSide();

        return s;
    }
    
    /* Name: equals
     * Purpose: Checks if reference is equal to parameter
     * Parameters: Object o - The object to check
     * Return: boolean - True or false
     */
    @Override
    public boolean equals(Object o) {

        int x = this.getUpperLeft().getX();
        int y = this.getUpperLeft().getY();

        if (o instanceof Square) {
            if ((this.getSide() == ((Square)o).getSide())
                && (this.getUpperLeft().equals(((Square)o).getUpperLeft()))) {

                return true;
            }
        }
        return false;
    }

    /* Name: draw
     * Purpose: Draws the square onto the canvas
     * Parameters: DrawingCanvas canvas - The canvas to draw on
     *             Color c - The color of the triangle
     *             boolean fill - Whether to fill the triangle or not
     * Returns: void
     */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {

        if (c == null) {
            c = Color.BLACK;
        }

        if (fill) {
            new FilledRect(this.getUpperLeft().getX(),
                            this.getUpperLeft().getY(),
                            this.getSide(),this.getSide(),canvas).setColor(c);
        }
        else {
            new FramedRect(this.getUpperLeft().getX(),
                            this.getUpperLeft().getY(),
                            this.getSide(),this.getSide(),canvas).setColor(c);
        }
    }
    
    /* Name: getSide
     * Purpose: Returns the side length of the square
     * Parameters: None
     * Return: int - the side length
     */
    public int getSide() {
        return this.side;
    }

    /* Name: setSide
     * Purpose: Sets new side length
     * Parameters; int s - The new side length
     * Return: void
     */
    private void setSide(int s) {
        this.side = s;
    }
}
