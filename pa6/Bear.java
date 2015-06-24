import java.awt.*;

/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Date: May 4, 2015
 * File: Bear.java
 * Sources of Help: Java Docs
 *
 * The Bear class is a specific class of the Critter class. This class
 * has its own behaviors for moving, eating, and fighting. It also has
 * its own attributes such as the color (brown or white) and name.
 */

/* Name: Bear
 * Purpose: This class represents a specific type of Critter object, a Bear.
 * Parameters: Color color - The color of the Bear object when it shows
 *                           up in the simulation.
 *             Direction direction - The direction that the object faces.
 */

public class Bear extends Critter {

    public Direction direction;
    public Color color;

    public Bear(boolean grizzly) {

        if (grizzly) {
            this.color = new Color(190,110,50); // brown
        }
        else {
            this.color = Color.WHITE;
        }

    }
    
    /* Name: eat
     * Purpose: Returns true if bear is hungry, which is always true.
     * Parameters: None
     * Return: boolean - True or False
     */
    public boolean eat() {
        return true;
    }
    
    /* Name: getColor
     * Purpose: Returns the color of the bear object.
     * Parameters: None
     * Return: Color - The color of the bear object (white or brown).
     */
    public Color getColor() {
        return this.color;
    }
    
    /* Name: fight
     * Purpose: Returns the attacking move when a bear encounters an opponent.
     * Parameters: String opponent - The name of the opponent.
     * Return: Attack - The type of attack, which is always scratch.
     */
    public Attack fight(String opponent) {
        return Attack.SCRATCH;
    }

    /* Name: getMove
     * Purpose: Returns the direction the Bear faces.
     * Parameters: None
     * Return: Direction - North, South, East, or West.
     */
    public Direction getMove() {

        // If bear faced South previously, face East.
        if (this.direction == Direction.SOUTH) {
            this.direction = Direction.EAST;
        }
        // If bear faced East previously, face South.
        else if (this.direction == Direction.EAST) {
            this.direction = Direction.SOUTH;
        }
        // Bear initially faces South. 
        else {
            this.direction = Direction.SOUTH;
        }
        return this.direction;
    }
    
    /* Name: toString
     * Purpose: Returns the object's name in the simulation.
     * Parameters: None.
     * Return: String - The name.
     */
    @Override
    public String toString() {
        return "B";
    }
}
