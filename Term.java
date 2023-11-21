import java.util.Comparator;
/**
*This project is the first
*of three that will involve
*three classes: Term, Binary Search,
*Autocomplete.
*@author Caroline Kirkconnell
*@version 10/04/20
*This project is an autocomplete
*application.
*/

public class Term implements Comparable<Term> {
   public String query;
   public long weight;
   
     /**
     * Initialize a term with the given query and weight.
     * This method throws a NullPointerException if query is null,
     * and an IllegalArgumentException if weight is negative.
     */
   public Term(String query, long weight) {
      if (query == null) {
         throw new java.lang.NullPointerException("Query cannot be null");
      } 
      if (weight < 0) {
         throw new java.lang.IllegalArgumentException("Weight cannot be negative");
      }

      this.query = query;
      this.weight = weight;
   }
   
     /**
     * Compares the two terms in descending order of weight.
     */
   public static Comparator<Term> byReverseWeightOrder() {
      return new Comparator<Term>() {
            public int compare(Term t1, Term t2) {
               if (t1.weight > t2.weight) {
                  return -1;
               } else if (t1.weight == t2.weight) {
                  return 0;
               } else {
                  return 1;
               }
            }
         };
   }
   
     /**
     * Compares the two terms in ascending lexicographic order of query,
     * but using only the first length characters of query. This method
     * throws an IllegalArgumentException if length is less than or equal
     * to zero.
     */
   public static Comparator<Term> byPrefixOrder(int r) {
      if (r < 0) {
         throw new java.lang.IllegalArgumentException("Cannot order with negative number of characters");
      }
      final int ref = r;
      return 
         new Comparator<Term>() {
            public int compare(Term t1, Term t2) {
               String q1 = t1.query;
               String q2 = t2.query;
               int min;
               if (q1.length() < q2.length()) {
                  min = q1.length();
               } 
               else {
                  min = q2.length();
               }
               if (min >= ref) {
                  return q1.substring(0, ref).compareTo(q2.substring(0, ref));
               } 
               else if (q1.substring(0, min).compareTo(q2.substring(0, min)) == 0) {
                  if (q1.length() == min) {
                     return -1;
                  } 
                  else {
                     return 1;
                  }
               } 
               else {
                  return q1.substring(0, min).compareTo(q2.substring(0, min));
               }
            }
         };
   }
   
     /**
     * Compares this term with the other term in ascending lexicographic order
     * of query.
     */
   public int compareTo(Term that) {
      String q1 = this.query;
      String q2 = that.query;
      return q1.compareTo(q2);
   }
   
     /**
     * Returns a string representation of this term in the following format:
     * query followed by a tab followed by weight
     */
   public String toString() {
      return this.weight + "\t" + this.query;
   }
}