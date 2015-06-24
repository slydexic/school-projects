/*
 * Name:  Julius Caesar <--- Replace with your name
 * Login: cs8bXX <--- Use your cs8b course-specific account name
 * Date:  April 2, 2015
 * File:  CaesarTester.java <-- Name of the file
 * Sources of Help: ... (for example: names of people/tutors/students, books, 
 *                       websites, etc.) 
 *
 * Tests Caesar.java using basic strings and rotation values. 
 *
 */

/*
 * Name:    CaesarTester
 * Purpose: To test Caesar.java for correct output.
 */
public class CaesarTester {

  /*
   * Name:       main
   * Purpose:    To call methods in Caesar and test them
   * Parameters: String[] args - command line arguments that are unused
   * Return:     void
   */
  public static void main( String[] args ) {

  /** The main method. THIS IS WHERE YOU SHOULD ADD MORE TESTS
    * FOR encrypt and decrypt methods AND ANY OTHER METHOD
    * THAT YOU CREATE. BE SURE TO TEST YOUR CODE THOROUGHLY
    **/

    Caesar g = new Caesar();
    String blah = g.encrypt("A",-501);
    System.out.println(blah);
    //The Caesar Cipher Tests
    Caesar f = new Caesar();
    boolean fail = false;

    //Test 1
    String message1 = "Cse8b: Programming in Java, Part 2";
    String encryptedAnswer = "Tjv8s: Gifxirddzex ze Armr, Grik 2";
    String encrypted1 = f.encrypt(message1,17);

    if ( !encryptedAnswer.equals(encrypted1) ) {
      System.out.println("Test 1 Failed\n");
      System.out.println(encryptedAnswer);
      System.out.println("does not match");
      System.out.println(encrypted1);
      fail = true;
    } else {
      System.out.println("Test 1 Passed!\n");
    }

    //Test 2
    String encrypted2 ="Byffi yhwlsjncih qilfx";
    String messageAnswer ="Hello encryption world";
    String message2 = f.decrypt(encrypted2,-58);
 
    if ( !messageAnswer.equals(message2) ) {
      System.out.println("Test 2 Failed\n");
      System.out.println(message2);
      System.out.println("does not match");
      System.out.println(messageAnswer);
      fail = true;
    } else {
      System.out.println("Test 2 Passed!\n");
    }

    //Messages that print whether tests were successful or not
    if( !fail ) {
      System.out.println("All Tests Passed!");
    } else {
      System.out.println("At least one test failed");
    }

  }

}
