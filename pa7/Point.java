

/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Filename: Point.java
 *
 * This file contains the Point class. This class holds coordinates for
 * shapes to use.
 */

/* Name: Point
 * Purpose: This object is used to hold coordinates for shape objects.
 * Parameters: int x - The x-coordinate
 *             int y - The y-coordinate
 */
public class Point {

    private int x;
    private int y;

    public Point() {
        
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public Point(Point point) {

        this.x = point.getX();
        this.y = point.getY();
    }
    
    /* Name: getX
     * Purpose: Returns x-coordiante
     * Parameters: None
     * Return: int - The x-coordinate
     */
    public int getX() {
        return this.x;
    }
    
    /* Name: getY
     * Purpose: Returns y-coordinate
     * Parameters: None
     * Return: int - The y-coordinate
     */
    public int getY() {
        return this.y;
    }
    
    /* Name: setX
     * Purpose: Sets a new x-coordinate
     * Parameters: int x - The new x-coordinate
     * Return: void
     */
    private void setX(int x) {
        this.x = x;
    }

    /* Name: setY
     * Purpose: Sets a new y-coordinate
     * Parameters: int y - The new y-coordinate
     * Return: void
     */
    private void setY(int y) {
        this.y = y;
    }
    
    /* Name: move
     * Purpose: Moves the location of the point
     * Parameters: int xDelta - How much to move in x direction
     *             int yDelta - How much to move in y direction
     * Return: void
     */
    public void move(int xDelta, int yDelta) {

        this.setX(this.getX() + xDelta);
        this.setY(this.getY() + yDelta);
    }
    
    /* Name: toString
     * Purpose: Prints the location of the point as a String
     * Parameters: None
     * Return: String - The sentence.
     */
    @Override
    public String toString() {
        return "Point: (" + getX() + "," + getY() + ")";
    }

    /* Name: equals
     * Parameters: Object o - The object to compare.
     * Purpose: To check if parameter is equal to reference
     * Return: boolean - True or False
     */
    @Override
    public boolean equals(Object o) {
        
        if (o instanceof Point) {
            if ((this.getX() == ((Point)o).getX())
                && (this.getY() == ((Point)o).getY())) {
                return true;
            }
        }
        return false;
    }

    /* Name: hashCode
     * Purpose: Returns the hashcode of reference
     * Parameters: None
     * Return: int
     */
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
