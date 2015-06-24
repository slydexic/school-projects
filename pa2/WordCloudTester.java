/*  WordPair
 *
 *  Class to test a WordCloud.  The class expects two command line arguments:
 *  argument[0] is filname
 *  argument[1] is N, where N is the number of commonly occurring words to print
 *  Note that it expects a file with common word occurrences named "commonWords.txt"
 *
 *  Author: Leo Porter 1/10/14
 */


import java.util.*;
import java.io.*;

public class WordCloudTester {

  // method to text the word cloud
  public static void main ( String[] args) throws IOException {
    WordCloud w = new WordCloud();
    System.out.println("Reading in File: "+args[0]);
    w.getWordsFromFile( args[0] );
    
    System.out.println("Removing common words");
    w.removeCommon("commonWords.txt");

    int n = Integer.parseInt(args[1]);
    System.out.println("Displaying the top " + n + " words");
    w.printTopNWords(n);

    //Don't forget to test findWordCount as well
    //An example test is listed below
    System.out.println("Count should be 0. It is..." + 
                       w.findWordCount("the"));
  }

}
