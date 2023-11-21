import java.util.Comparator;
/**
*This project is the second
*of three that will involve
*three classes: Term, Binary Search,
*Autocomplete.
*@author Caroline Kirkconnell
*@version 10/04/20
*This project is an autocomplete
*application.
*/
public class BinarySearch {
     /**
     * Returns the index of the first key in a[] that equals the search key, 
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
   public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if (a == null || key == null || comparator == null) {
         throw new java.lang.NullPointerException();
      }
      if (a.length == 0) {
         return -1;
      }
      int left = 0;
      int right = a.length - 1;
      while (left + 1 < right) {
         int middle = left + (right - left)/2;
         if (comparator.compare(key, a[middle]) <= 0) {
            right = middle;
         } else {
            left = middle;
         }
      }
      if (comparator.compare(key, a[left]) == 0) {
         return left;
      }
      if (comparator.compare(key, a[right]) == 0) {
         return right;
      }
      return -1;
   
   }
   
  /**
     * Returns the index of the last key in a[] that equals the search key, 
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
   public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if (a == null || key == null || comparator == null) {
         throw new java.lang.NullPointerException();
      }
      if (a == null || a.length == 0) {
         return -1;
      }
      int left = 0;
      int right = a.length - 1;
      while (left + 1 < right) {
         int middle = left + (right - left)/2;
         if (comparator.compare(key, a[middle]) < 0) {
            right = middle;
         } else {
            left = middle;
         }
      }
      if (comparator.compare(key, a[right]) == 0) {
         return right;
      }
      if (comparator.compare(key, a[left]) == 0) {
         return left;
      }
      return -1;
   }
}