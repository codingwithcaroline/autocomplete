import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
/**
*This project is the last
*of three that will involve
*three classes: Term, Binary Search,
*Autocomplete.
*@author Caroline Kirkconnell
*@version 10/04/20
*This project is an autocomplete
*application.
*/

public class Autocomplete {
   public Term[] terms;

	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
   public Autocomplete(Term[] terms) {
      if (terms == null) {
         throw new java.lang.NullPointerException();
      }
      this.terms = terms.clone();
      Arrays.sort(this.terms);
   }
   
	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
   public Term[] allMatches(String prefix) {
      if (prefix == null) {
         throw new java.lang.NullPointerException();
      }
      Term theTerm = new Term(prefix, 0);
      int start = BinarySearchDeluxe.firstIndexOf(terms, theTerm, Term.byPrefixOrder(prefix.length()));
      int end = BinarySearchDeluxe.lastIndexOf(terms, theTerm, Term.byPrefixOrder(prefix.length()));
      int count = start;
      System.out.println("Start: " + start + " End: " + end);
      if (start == -1 || end == -1) {
         // System.out.println("PREFIX: " + prefix);
         throw new java.lang.NullPointerException();
      } // Needed?
      Term[] matches = new Term[end - start + 1];
      //matches = Arrays.copyOfRange(terms, start, end);
      for (int i = 0; i < end - start; i++) {
         matches[i] = this.terms[count];
         count++;
      }
      Arrays.sort(matches, Term.byReverseWeightOrder());
      System.out.println("Finished allmatches");
      return matches; 
   }
   }
