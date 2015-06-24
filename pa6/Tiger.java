import java.util.Random;
import java.awt.*;

/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Date: May 4, 2015
 * File: Tiger.java
 * Sources of Help: Java Docs
 *
 * The Tiger class is a specific class of the Critter class. This class
 * has its own behaviors for moving, eating, and fighting. It also has
 * its own attributes such as color and name.
 */

/* Name: Tiger
 * Purpose: This class represents a specific type of Critter object, a Tiger.
 * Parameters: boolean eat - Is the Tiger hungry or not.
 *             int hungerLevel - The Tigers hunger level, how many times
 *                               it will eat.
 *             Random generator - The Random object for moving.
 *             int value - The value of the random integer.
 *             int count - The number of times the Tiger moves in a direction.
 */
public class Tiger extends Critter{

    private int hungerLevel;
    private Random generator;
    private int value;
    private int count;

    public Tiger(int hunger) {

        this.hungerLevel = hunger;
        this.count = 0;
        this.generator = new Random();
        this.value = this.generator.nextInt(4);
    }
 
    /* Name: eat
     * Purpose: Decides if the Tiger will eat or not depending on hunger.
     * Parameters: None
     * Return: boolean - True if hungry, otherwise false.
     */
    public boolean eat() {

        if (this.hungerLevel > 0) {
            --this.hungerLevel; // Lower hunger after eating.
            return true;
        }
        return false;
    }
    
    /* Name: fight
     * Purpose: Decides what attacking move to use based on hunger.
     * Parameters: String opponent - The name of the opponent.
     * Return: Attack - The attacking move.
     */
    public Attack fight(String opponent) {
        
        if (this.hungerLevel > 0) { // If hungry, Scratch.
            return Attack.SCRATCH;
        }
        // Otherwise Pounce.
        return Attack.POUNCE;
    }
    
    /* Name: getColor
     * Purpose: Returns color of Tiger object, yellow.
     * Parameters: None
     * Return: Color - Returns yellow.
     */
    public Color getColor() {
        return Color.YELLOW;
    }
    
    /* Name: getMove
     * Purpose: Returns the direction that the Tiger will face.
     * Parameters: None
     * Return: Direction - North, South, West, or East.
     */
    public Direction getMove() {

        // If 'count' is >= 3, then reset 'value' for next random direction.
        if (this.count >= 3) {
            this.value = this.generator.nextInt(4); // new value
            this.count = 0; // reset count to 0
        }
        
        ++this.count; // increment count for each call
        if (this.value == 0) {
            return Direction.NORTH;
        }
        else if (this.value == 1) {
            return Direction.SOUTH;
        }
        else if (this.value == 2) {
            return Direction.WEST;
        }
        else { // if value == 3
            return Direction.EAST;
        }
    }
    
    /* Name: toString
     * Purpose: Returns the value of the hunger level as a string.
     * Parameters: None
     * Return: String - The value of the hunger level.
     */
    @Override
    public String toString() {
        
        // This method returns the String of the integer.
        return Integer.toString(hungerLevel);
    }
}
