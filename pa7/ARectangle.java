
/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Filename: ARectangle.java
 *
 * This file contains the abstract class for a rectangle.
 * This is because ARectangle can be a square or rectangle (subclasses).
 * ARectangle is a subclass of Shape.
 */

/* Name: ARectangle
 * Purpose: Abstract class for Square and Rectangle subclasses
 * Parameters: Point upperLeft - The upperLeft point of the rectangle.
 */
public abstract class ARectangle extends Shape {

    private Point upperLeft;

    public ARectangle() {

        super("ARectangle");
        this.upperLeft = new Point(0,0);
    }

    public ARectangle(String name, int x, int y) {

        super(name);
        this.upperLeft = new Point(x,y);
    }

    public ARectangle(String name, Point upperLeft) {

        super(name);
        this.upperLeft = upperLeft;
    }

    public ARectangle(ARectangle r) {
     
        super(r.getName());
        this.setUpperLeft(new Point(r.getUpperLeft()));
    }

    /* Name: move
     * Purpose: Move the shape.
     * Parameters: int xDelta - How much to move in x-direction.
     *             int yDelta - How much to move in y-direction.
     * Return: void
     */
    public void move(int xDelta, int yDelta) {
        
        this.getUpperLeft().move(xDelta,yDelta);
    }

    /* Name: toString
     * Purpose: Prints out a String that gives the upper left point.
     * Parameters: None
     * Return: void
     */
    @Override
    public String toString() {

        String s = this.getName() + ": Upper Left Corner:"
                            + this.getUpperLeft().toString();
        return s;
    }

    /* Name: equals
     * Purpose: Checks if parameter is equal to reference
     * Parameters: Object 0 - The object to compare
     * Return: boolean - True or False
     */
    @Override
    public boolean equals(Object o) {
        
        if (o instanceof ARectangle) {
            if (this.getUpperLeft().equals(((ARectangle)o).getUpperLeft())) {
                return true;
            }
        }
        return false;
    }

    /* Name: hashCode
     * Purpose: Returns the hashcode of the reference
     * Parameters: None.
     * Return: int - The hashcode
     */
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    /* Name: getUpperLeft()
     * Purpose: Returns upper left corner of rectangle
     * Parameters: None
     * Return: Point - The upper left corner.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /* Name: setUpperLeft
     * Purpose: sets new upper left corner
     * Parameters: Point p- The new upper left corner
     * Return: void
     */
    private void setUpperLeft(Point p) {
        this.upperLeft = p;
    }

}
