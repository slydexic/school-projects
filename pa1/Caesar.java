// Name: Julius Sphabmixay
// Login: cs8beq
// Date: April 8, 2015
// File: Caesar.java

import java.io.*;
import java.util.*;

// For future PA's, you will write this class header
/*
 * Name:    Caesar
 * Purpose: Encodes and decodes a given string according to the rotation 
 *          value passed in.
 */
public class Caesar {
  // Complete the methods below.  Be sure to add in-line
  // comments for each. You may (and should) also write additional
  // helper methods.  Be sure to make the helper methods private and include
  // in-line comments for each.

  // Although you will not be graded on style this week, you should follow
  // these basic style guidelines nonetheless.   You will be graded on this
  // in weeks to come, so start to practice now.

  // Use proper indenting: Indent each block of code (e.g., method body,
  //   loop body.  Line up the lines in the block so that they are all
  //   indented to the same degree.  See examples of this in the book
  //   and in the code below.
  // Use descriptive variable names: The names of your variables should
  //   describe the data they hold.  Almost always, your variable names
  //   should be words (or abbreviations), not single letters.
  // Write short methods: Break your methods up into submethods if they
  //   are getting too complicated or long.  
  // Write short lines: Each line of code should be no longer than 80
  //   characters, so it can fit in a reasonable size window.  There's a
  //   column number in both vim and emacs.
  //
  // We'll start with these, as these are the most important.  We may add
  // to this list later in the term, but if you do all of the above you're
  // in good shape.

  // For future PA's, you will write this method header
  /* 
   * Name:      encrypt
   * Purpose:   Encrypts a string using the rotation.
   * Parameter: String s - the string to be encrypted
   *            int rotation - the integer difference between what the letter's
   *            original int value is and what it will be changed to.
   * Return:    String - converted string
   */
  public String encrypt(String s, int rotation) {

     char[] encryptArray = new char[s.length()]; // array to hold new letters
     for (int i = 0; i < s.length(); i++) {
        // run encryption if letter and put new letter to array
        if (Character.isLetter(s.charAt(i)) == true) {
           char newLetter = this.changeLetter( s.charAt(i), rotation );
           encryptArray[i] = newLetter;
        }
        // else put non-letter into array
        else {
           encryptArray[i] = s.charAt(i);
        }
     }
     // create string to hold encryption
     String encryption = new String(encryptArray);
     return encryption; // return encryption
  }

  // For future PA's, you will write this method header
  /* 
   * Name:      decrypt
   * Purpose:   Decrypts a string using the rotation.
   * Parameter: String s - the string to be decrypted
   *            int rotation - the integer difference between what the letter's
   *            original int value was and what it was changed to.
   * Return:    String - original string
   */
   // The decrypt method is exactly the same as encrypt method
   // except decrypt returns the revealed message
  public String decrypt(String s, int rotation) {

     char[] decryptArray = new char[s.length()];
     for (int i = 0; i < s.length(); i++) {
        
        if (Character.isLetter(s.charAt(i)) == true) {
           char newLetter = this.changeLetter( s.charAt(i), rotation );
           decryptArray[i] = newLetter;
        }
        else {
           decryptArray[i] = s.charAt(i);
        }
     }
     String decryption = new String(decryptArray);
     return decryption;
  }
// //////////// IMPORTANT ///////////////////
// Please ignore rotForward and rotBackward methods.
// These methods work as well. They were the first methods
// that I made. However, I managed to make the changeLetter
// method, which is overall better than these two methods.
// These two methods are left for me to look back on.
// Thank you.
/*
  public char rotForward(char letter, int rot) {

     String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     String LOWER = "abcdefghijklmnopqrstuvwxyz";
     if (Character.isUpperCase(letter) == true) {
        for (int j = 0; j < UPPER.length(); j++) {
           if ((int) letter == (int) UPPER.charAt(j)) {
              letter = (char) ((int) UPPER.charAt((j + rot) % 26));
              System.out.println("Have a new uppercase letter");
              break;
           }
        }
     }
     else {
        for (int j = 0; j < LOWER.length(); j++) {
           if ((int) letter == (int) LOWER.charAt(j)) {
              letter = (char) ((int) LOWER.charAt((j + rot) % 26));
              System.out.println("Have a new lowercase letter");
              break;
           }
        }
     }
     return letter;
  }

  public char rotBackward(char letter, int rot) {

     String UPPER = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
     String LOWER = "zyxwvutsrqponmlkjihgfedcba";
     if (Character.isUpperCase(letter) == true) {
        for (int j = 0; j < UPPER.length(); j++) {
           if ((int) letter == (int) UPPER.charAt(j)) {
              letter = (char) ((int) UPPER.charAt((j + rot) % 26));
              break;
           }
        }
     }
     else {
        for (int j = 0; j < LOWER.length(); j++) {
           if ((int) letter == (int) LOWER.charAt(j)) {
              System.out.println(letter);
              letter = (char) ((int) LOWER.charAt((j + rot) % 26));
              break;
           }
        }
     }
     return letter;
  }
*/

// Name: changeLetter
// Purpose: Changes the letter to a new letter depending on rotation.
// Parameters: char letter - The letter to be changed.
//             int rot - The desired amount of rotation.
// Return: char - The new letter.

  private char changeLetter( char letter, int rot ) {

     int value = (int) letter; // decimal value of the char
     rot = rot % 26;
     if ( rot < 0 ) {
        rot = -rot;
     }
     if (Character.isUpperCase( letter ) == true) {
        value = value - 65;  // shift value to number between 0-25
        value = value + rot; // add difference to value
        value = value % 26;  // find position of letter
        letter = (char) (value + 65); // assign new letter
     }
     else {
        // same process as if-statement
        value = value - 97;
        value = value + rot;
        value = value % 26;
        letter = (char) (value + 97);
     }

     return letter;
  }
}
