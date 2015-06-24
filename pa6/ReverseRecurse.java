
import java.util.Scanner;
import java.lang.System;
import java.util.ArrayList;
import java.lang.Integer;

/* Name: Julius Sphabmixay
 * Login: cs8beq
 * Date: May 11, 2015
 * File: ReverseRecurse.java
 * Sources of help: Java Docs
 *
 * This program asks the user to make an array of integers to reverse.
 * The methods used to reverse the array are recursive. The first method
 * reverses the array by switching the integers at the lowest and highest
 * index, then calls the method within itself to reverse the next lowest
 * and highest index until there is one or two elements left to reverse.
 * The second method creates a new array with the elements reversed. The
 * method will copy the elements at the lowest and highest index to the
 * new array at reversed positions. Then will call the method within
 * itself to do the same process again until the base case is reached.
 * At that point the method returns portions of the reversed array until
 * the array is completely reversed.
 */

/* Name: ReverseRecurse
 * Purpose: This class reverses the user's array by recusive methods.
 * Parameters: Scanner input - Scanner to take user's input.
 *             int size - User's desired max array size.
 *             int[] usersArray - The user's array.
 *             ArrayList<Integer> list - The list to take in user's integers.
 *             int min - The minimum size of usersArray.
 */

public class ReverseRecurse {

    private Scanner input = new Scanner(System.in);
    private int size;
    private int[] usersArray;
    private ArrayList<Integer> list = new ArrayList(0); // Starts at size 0.
    private int min;
 
 /* Name: initArray
  * Purpose: Helps create the user's array.
  * Parameters: None
  * Return: int[] - The array that the user makes.
  */
    public int[] initArray() {

        System.out.print(PA6Strings.MAX_NUM);
        // Initialize the desired size. Will keep asking for a positive integer.
        while (this.size == 0) {
            if (this.input.hasNextInt()) {
                int next = input.nextInt();
                // The array size must be positive.
                if (next > 0) {
                    this.size = next;
                }
                else {
                    System.out.print(PA6Strings.TOO_SMALL);
                }
            }
            // User decides to EOF
            else {
                System.exit(1);
            }
        }
        // The list takes in all of the user's integers
        System.out.print(PA6Strings.ENTER_INTS);
        while (this.input.hasNextInt()) {
            list.add(this.input.nextInt());
        }
        // Create array size = min(this.size,this.list.size());
        if (this.list.size() <= this.size) {
            this.min = this.list.size();
        }
        else {
            this.min = this.size;
        }
        this.usersArray = new int[this.min];

        for (int i = 0; i < this.min; i++) {
            this.usersArray[i] = list.get(i).intValue();
        }
        return this.usersArray;
    }

    /* Name: printArray
     * Purpose: Prints out the integers in the array.
     * Parameters: int[] array - The array of interest.
     * Return: void
     */
    public void printArray(int[] array) {
        
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }
        else {
            System.out.print(PA6Strings.EMPTY);
        }
        System.out.println();
    }
    
    /* Name: reverse
     * Purpose: Reverses the elements within the passed array.
     * Parameters: int[] array - The array to be reversed.
     *             int low - The lowest index of the array.
     *             int high - the highest index of the array.
     * Return: int[] - The reversed array.
     */
    public int[] reverse(int[] array, int low, int high) {

        // Check for null array or empty array.
        if (array == null) {
            return array;
        }
        else if (array.length == 0) {
            System.out.println("Error, array is empty.");
            return array;
        }
        // Switch elements at low and high.
        int first = array[low];
        int last = array[high];
        array[low] = last;
        array[high] = first;

        // Base Case: When there are only 2 or 1 elements left.
        if ((low + 1 == high) || (low == high)) {
            return array;
        }
        // Continue recursion
        else {
            return this.reverse(array,low + 1, high - 1);
        }
    }
    
    /* Name: reverse
     * Purpose: Returns the reversed array, but retains the original array
     * Parameters: int[] array - The array of interest.
     * Return: int[] - The new array with elements reversed.
     */
    public int[] reverse(int[] array) {
        
        // Check for null array or empty array.
        if (array == null) {
            return array;
        }
        else if (array.length == 0) {
            System.out.println("Error, array is empty.");
            return array;
        }
        
        // copyArray will be the array to return.
        // Copy elements at lowest and highest index and reverse their
        // position in copyArray.
        int[] copyArray = new int[array.length];
        copyArray[0] = array[array.length-1];
        copyArray[array.length-1] = array[0];

        // Base Case: When the array has 1 or 2 elements left.
        if (array.length == 1) {
            return copyArray;
        }
        else if (array.length == 2) {
            return copyArray;
        }
        else {
            // newArray contains the remaining elements to be reversed
            int[] newArray = new int[array.length-2];
            System.arraycopy(array,1,newArray,0,newArray.length);

            // reverseArray is the array that gets returned by passing newArray
            // and its elements are copied in to copyArray.
            int[] reverseArray = this.reverse(newArray);
            System.arraycopy(reverseArray,0,copyArray,1,reverseArray.length);
            return copyArray;
        }
    }
}
