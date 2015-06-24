
import java.awt.*;
import java.util.Random;
import java.lang.Integer;

/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Date: May 14, 2015
 * Filename: MyCritter.java
 *
 * This program is an extension of the Critter class. It has unique behaviors
 * that are meant to destroy other critters in the simulation. The defining
 * behavior is its attack method. This critter switches between attack styles.
 * The first style is meant to destroy all critters except the Hard bot. The
 * other style is made solely to kill the Hard bot.
 */

/* Name: MyCritter
 * Purpose: Extends Critter class to make a different critter.
 * Parameters: Random generator - Generates random integers for methods.
 *             int value1 - Value holds random integer for getMove()
 *             int value2 - Value holds random integer for randomAttack().
 *             int count - Counts the number of times the critter moves
 *                         a specific direction.
 *             int countMoves - Counts the number of times the critter moves.
 *             String face - Holds the String representation of the critter.
 */

public class MyCritter extends Critter {

    private Random generator;
    private int value1;
    private int value2;
    private int count;
    private int countMoves;
    public String face;

    public MyCritter() {
        
        this.generator = new Random();
        this.count = 0;
        this.countMoves = 0;
        this.face = "B";
    }

/* Name: eat
 * Purpose: Says if the critter will eat or not.
 * Parameters: None.
 * Return: boolean - True or false.
 */
    public boolean eat() {
            return true;
    }

/* Name: getColor
 * Purpose: Returns the color of the critter.
 * Parameters: None.
 * Return: Color - The color of the critter.
 */
    public Color getColor() {
        return Color.BLUE;
    }

/* Name: fight
 * Purpose: Returns the attacking move based on the opponent.
 * Parameter: String opponent - String representation of opponent.
 * Return: Attack - The attacking move.
 */
    public Attack fight(String opponent) {
        
        // The critter uses the body of this if-statement every 35 moves.
        // Else it will use the other body for the other 10 moves.
        // These are the two attack styles.
        if (this.countMoves % 45 <= 34) {
            // Attacking move against Bears.
            if (opponent.equals("B") || opponent.equals("b")) {
                return Attack.ROAR;
            }
            // Attacking move against Lions.
            else if (opponent.equals("L") || opponent.equals("l")) {
                return Attack.POUNCE;
            }
            // Attacking move against full Tigers.
            else if (opponent.equals("0")) {
                return Attack.SCRATCH;
            }
            // Attacking move against hungry Tigers.
            else if (opponent.equals("1")
                      || opponent.equals("2")
                      || opponent.equals("3")
                      || opponent.equals("4")
                      || opponent.equals("5")
                      || opponent.equals("6")
                      || opponent.equals("7")
                      || opponent.equals("8")
                      || opponent.equals("9")
                      || opponent.equals("10")) {

                return Attack.ROAR;
            }
            // Random attack against everything else.
            else {
                return this.randomAttack();
            }
        }
        // Second attack style meant to fight against Hard bot.
        else {
            // Attacking move against Hard bot pretending to be Bear.
            // Still works against regular Bears.
            if (opponent.equals("B") || opponent.equals("b")) {
                return Attack.POUNCE;
            }
            // Attacking move against Hard bot pretending to be Lion.
            // Still works against regular Lions.
            else if (opponent.equals("L") || opponent.equals("l")) {
                return Attack.POUNCE;
            }
            // Attacking move against full Tigers.
            else if (opponent.equals("0")) {
                return Attack.SCRATCH;
            }
            // Attacking move against hungry Tigers.
            else if (opponent.equals("1")
                      || opponent.equals("2")
                      || opponent.equals("3")
                      || opponent.equals("4")
                      || opponent.equals("5")
                      || opponent.equals("6")
                      || opponent.equals("7")
                      || opponent.equals("8")
                      || opponent.equals("9")
                      || opponent.equals("10")) {

                return Attack.ROAR;
            }
            // Random attack against everything else.
            else {
                return this.randomAttack();
            }
        }
    }
    
    /* Name: getMove
     * Purpose: Returns the direction for the critter. Also counts moves.
     * Parameter: None.
     * Return: Direction - The direction to face.
     */
    public Direction getMove() {
        
        // This critter moves just like the Tiger, except 2 more steps taken.
        // Reset count and pick new random integer after 5 steps.
        if (this.count >= 5) {
            this.value1 = this.generator.nextInt(4);
            this.count = 0;
        }

        ++this.count; // Counts number of steps in direction taken.
        ++this.countMoves; // Count the number of moves made.
        if (this.value1 == 0) {
            return Direction.NORTH;
        }
        else if (this.value1 == 1) {
            return Direction.SOUTH;
        }
        else if (this.value1 == 2) {
            return Direction.EAST;
        }
        else {
            return Direction.WEST;
        }

    }
    
    /* Name: toString
     * Purpose: Returns string to represent MyCritter. Also meant to
     *          fool the bots to using certain moves.
     * Parameter: None.
     * Return: String - The representation.
     */
    public String toString() {
            return "B";
    }
    
    /* Name: randomAttack
     * Purpose: Helper method that handles random attacking.
     * Parameter: None.
     * Return: Attack - The random attacking move.
     */
    private Attack randomAttack() {
    
        this.value2 = this.generator.nextInt(3);

        if (this.value2 == 0) {
            return Attack.ROAR;
        }
        else if (this.value2 == 1) {
            return Attack.SCRATCH;
        }
        else {
            return Attack.POUNCE;
        }
    }
}
