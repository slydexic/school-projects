import java.awt.*;
import objectdraw.*;

/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Filename: Shape.java
 *
 * This file contains a abstract class for shapes. The methods move()
 * and draw() are abstract methods that all other shapes (subclasses)
 * must implement.
 */

/* Name: Shape
 * Purpose: Shape is an abstract class for other shapes.
 * Parameters: String name - The name of the shape.
 */
public abstract class Shape {

    private String name;

    public Shape() {
        this.name = "Shape";
    }

    public Shape(String name) {
        this.name = name;
    }

    /* Name: getName
     * Purpose: Returns name of shape object.
     * Parameters: None
     * Return: String - The name.
     */
    public String getName() {
        return this.name;
    }

    /* Name: setName
     * Purpose: Sets the name of the object.
     * Parameters: String name - The new name.
     * Return: void
     */
    private void setName(String name) {
        this.name = name;
    }

    /* Copy this as is in your Shape.java */ 
    @Override 
    public boolean equals( Object o ) { 
        String s = "\n**********************************************************\n" 
                + "This should never print. If it does print, then\n" 
                + "you did not override equals() properly in class " 
                + this.getClass().getName() + "\n" 
                + "**********************************************************\n"; 
        System.out.println( s ); 
        return this == o; 
    }
    
    /* Name: move
     * Purpose: To move position of shapes. Implemented in subclasses.
     * Parameters: int xDelta - How much to move in x direction.
     *             int yDelta - How much to move in y direction.
     * Return: void
     */
    public abstract void move(int xDelta, int yDelta);

    /* Name: draw
     * Purpose: Draws shapes. Implemented in subclasses.
     * Parameters: Drawing canvas - The canvas to draw on.
     *             Color c - The color of the shape.
     *             boolean fill - Fill the inside of the shape or not.
     * Return: void
     */
    public abstract void draw(DrawingCanvas canvas, Color c, boolean fill);
}
