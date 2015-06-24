/* 
 *  Name: Jane-Joe Gogh
 *  Login: cs8bXX
 *  Date: April 2, 2015
 *  File: ArraysTester.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 1.
 *  This tests the class FunWithIntArrays.  FunWithIntArrays is buggy, so
 *  you may wish to test with just pieces of this code before testing
 *  all of it.  We will use our own copy of this file, so when you do
 *  your final testing, ensure it is with the original.
 *  
 */

/*
 * Name:    ArraysTester
 * Purpose: To test the class FunWithIntArrays.
 */
public class ArraysTester {
    
  /*
   * Name:       main
   * Purpose:    To call methods in FunWithIntArrays and test them
   * Parameters: String[] args - command line arguments that are unused
   * Return:     void
   */
  public static void main(String[] args) {
    
    int [] tester = {2,7,1,22,5,53,21,9};
    System.out.println("Creating Initial Array:");
    FunWithIntArrays.printArray(tester);

    // check array copy
    System.out.println("\nCreating Array Copy:");
    int [] copy = FunWithIntArrays.arrayCopy(tester);
    FunWithIntArrays.printArray(copy);

    //check min
    System.out.println("\nMin element is: "+
    FunWithIntArrays.findMin(tester));

    //check max
    System.out.println("\nMax element is: "+
    FunWithIntArrays.findMax(tester));

    //check reverse
    System.out.println("\nTesting Reversed Array");
    int [] reverse = FunWithIntArrays.arrayReverse(tester);
    FunWithIntArrays.printArray(reverse);
  }
}
