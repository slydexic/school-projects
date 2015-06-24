import java.awt.*;

/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Date: May 4, 2015
 * File: Lion.java
 * Sources of Help: Java Docs
 *
 * The Lion class is a specific class of the Critter class. This class
 * has its own behaviors for moving, eating, and fighting. It also has
 * its own attributes such as the color and name.
 */

/* Name: Lion
 * Purpose: This class represents a specific type of Critter object, a Lion.
 * Parameters: boolean fought - Whether the Lion has fought (true) or not (false).
 *             int count - A number used with mod 20 to decide the direction the
 *                         Lion should face at each value of count.
 */

public class Lion extends Critter {

    private boolean fought;
    private int count;

    public Lion() {

        this.count = 0;
        this.fought = false; // Hasn't fought at initialization
    }

    /* Name: getColor
     * Purpose: Returns the color of the Lion
     * Parameters: None
     * Return: Color - Always returns red.
     */
    public Color getColor() {
        return Color.RED;
    }
    
    /* Name: eat
     * Purpose: Tells the simulation if the Lion wants to eat or not.
     * Parameters: None.
     * Return: boolean - True if Lion is hungry, false otherwise.
     */
    public boolean eat() {
        
        // If Lion has fought, reset fought to false and return true.
        if (this.fought) {
            this.fought = false;
            return true;
        }
        return false;

    }
    
    /* Name: getMove
     * Purpose: Returns the direction that the Lion should face.
     * Rarameters: None.
     * Return: Direction - North, South, East, or West.
     */
    public Direction getMove() {
        
        // (this.count % 20) always returns an integer from 0 to 19.
        // this.count is always increasing. Could fail
        // at Java's MAX_VALUE, but highly unlikely.
        // Notice that the conditions span 5 numbers.
        if ((this.count % 20) < 5) { // an integer from 0 to 4.
            ++this.count;
            return Direction.SOUTH;
        }
        // an integer from 5 to 9.
        else if ((this.count % 20) >= 5 && (this.count % 20) < 10) {
            ++this.count;
            return Direction.WEST;
        }
        // an integer from 10 to 14.
        else if ((this.count % 20) >= 10 && (this.count % 20) < 15) {
            ++this.count;
            return Direction.NORTH;
        }
        // an integer from 15 to 19
        else {
            ++this.count;
            return Direction.EAST;
        }
    }
    
    /* Name: toString
     * Purpose: Returns the objects name in the simulation.
     * Parameters: None
     * Return: String - The name of the Lion object.
     */
    @Override
    public String toString() {
        return "L";
    }
     
    /* Name: fight
     * Purpose: Returns the attacking move of the Lion depending on 'fought'.
     * Parameters: String opponent - The oppeonent's name.
     * Return: Attack - Returns the attacking move, Roar or Pounce.
     */
    public Attack fight(String opponent) {
        
        this.fought = true; // fought is true if fight is called.
        // If bear is opponent, Roar.
        if (opponent == "B") {
            return Attack.ROAR;
        }
        // Otherwise, Pounce.
        return Attack.POUNCE;
    }
}
