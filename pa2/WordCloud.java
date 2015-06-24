import java.util.*;
import java.io.*;

/*
 * Name: Julius Sphabmixay
 * Login: cs8beq
 * Date: April 13, 2015
 * File: WordCloud.java
 *
 * This program creates a list to hold all the distinct words found within
 * a text file. The program counts the number of times a word appears
 * and can also remove commonly used words. This program is a basic
 * "word cloud".
 */

/* Name: WordCloud
 * Purpose: This class is used to make a "word cloud".
 * Parameters: ArrayList<WordCloud> list - A WordCloud object only has an
 *                                         ArrayList object as a field.
 *                                         This list references WordPair objects.
 */

public class WordCloud {

  // The ArrayList to store the words and their associated counts
  ArrayList<WordPair> list; // this is a field 
 
  // construct the list
  // this is a constructor
  public WordCloud() {
    list = new ArrayList<WordPair>();
  }

  /* Name: getWordsFromFile
   * Purpose: Gets all the unique words found in a text file.
   * Parameters: String filename - The name of the text file to read.
   * Return: void
   */
  public void getWordsFromFile( String filename ) throws IOException {
     // The scanner object to run through the text file
     Scanner input = new Scanner ( new File(filename) );
     while ( input.hasNext() ) {
        // Used to indicate whether a word whould be added to the ArrayList
        boolean indicator = false;
        WordPair testWordPair = new WordPair( input.next() );
        String testWord = testWordPair.getWord();
        // Check through the list to count words
        for ( int i = 0; i < this.list.size(); i++ ) {

           WordPair currentWordPair = this.list.get(i);
           String currentWord = currentWordPair.getWord();
           if ( currentWord.toUpperCase().equals( testWord.toUpperCase() ) ) {

              currentWordPair.increment();
              indicator = true; // indicator is true because we incremented
           }
        }
        // if indicator remains false, add the new WordPair to list
        if ( indicator == false ) {
           this.list.add( testWordPair );
        }
     }
  }

  /* Name: getList
   * Purpose: To get the list of WordPairs
   * Parameters: None
   * Return: the ArrayList<Word> object
   */
  public ArrayList<WordPair> getList(){
    return list;
  }

  /* Name: findWordCount
   * Purpose: To get the number of times a word appears
   * Parameters: String word - The word desired
   * Return: The integer number of times the word appears
   */
  public int findWordCount(String word){
     for ( int i = 0; i < this.list.size(); i++ ) {

        WordPair currentWordPair = this.list.get(i);
        // if word is found, return the count of the word
        if ( currentWordPair.getWord().equals( word ) ) {

           int count = currentWordPair.getCount();
           return count;
        }
     }
     return 0; // if word not found, return 0
  }
  /* Name: removeCommon
   * Purpose: To remove commonly used words
   * Parameters: String omitFilename - The name of the file containing
   *                                   all the common words
   * Return: void
   */
  public void removeCommon( String omitFilename ) throws IOException {
     // Scanner object runs through the file with common words
     Scanner input = new Scanner(new File(omitFilename) );
     // Create a new ArrayList to put uncommon words in to
     ArrayList<WordPair> newList = new ArrayList();
     while ( input.hasNext() ) {

        WordPair commonWordPair = new WordPair( input.next() );
        String commonWord = commonWordPair.getWord();
        // Run through list to find common words in list
        for ( int i = 0; i < this.list.size(); i++ ) {

           WordPair currentWordPair = this.list.get(i);
           String currentWord = currentWordPair.getWord();
           // if a common word is found in the list, then we set its
           // count to -1 to mark it down as a common word
           if ( commonWord.toUpperCase().equals( currentWord.toUpperCase() ) ) {
              currentWordPair.setCount(-1);
           }
        }
     }
     // We copy all the WordPairs with positive word count to the
     // new ArrayList that was created. Leave the common words behind.
     // This indirectly removes the common words.
     for ( int j = 0; j < this.list.size(); j++ ) {

        WordPair currentWordPair = this.list.get(j);
        if ( currentWordPair.getCount() > 0 ) {
           newList.add( currentWordPair );
        }
     }
     // Set new ArrayList
     this.list = newList;
  }
  /* Name: printTopNWords
   * Purpose: Finds and prints the top words in the ArrayList
   * Parameters: int n - The number of top words desired
   * Return: void
   */
  // Since the words in the list appear in order, we do not
  // need to directly consider words with equal counts.
  public void printTopNWords(int n) {
     // Run this method n times
     int j = 0;
     while ( j < n ) {
        // Run through list to find WordPair with max count
        WordPair maxWordPair = this.list.get(0);
        int i = 1;
        while ( i < this.list.size() ) {

           WordPair currentWordPair = this.list.get(i);
           int currentCount = currentWordPair.getCount();
           // Find max by comparing counts and replacing the maxWordPair
           // if another WordPair count is higher
           if ( maxWordPair.getCount() < currentCount ) {
              maxWordPair = currentWordPair;
           }
           i++;
        }
        j++;
        System.out.print(maxWordPair.getWord() + "("+ maxWordPair.getCount()+") ");
        // Set maxWordPair to negative count to find next max count words
        maxWordPair.setCount( -maxWordPair.getCount() );
     }
     // Reset negative word counts to positive counts
     for ( int k = 0; k < this.list.size(); k++ ) {

        WordPair currentWordPair = this.list.get(k);
        int currentCount = currentWordPair.getCount();
        if ( currentCount < 0 ) {
           currentWordPair.setCount( -currentCount );
        }
     }
     // Output needs a new line
     System.out.println("\n");
  }

}
