package edu.wmich.cs3310.hw1.JohnGray.search;

/**
 * This interface is the foundation for my class that will 
 * hold all the searches.
 * @author john
 *
 */
public interface ISearch {
		
		/**
		 * Searches an array for a target via iterative binary search.
		 * @param input Array to search
		 * @param target Target to search for
		 * @return Returns the index of the target. If not found, returns -1.
		 */
		public int binarySearchIterative(float[] input, float target);
		
		/**
		 * Searches an array for a target via recursive binary search.
		 * @param input Array to search
		 * @param target Target to search for
		 * @param lower Placeholder for recursion. This is the index of the lowest number to be considered.
		 * @param upper Also placeholder. Holds index of highest number to be considered for searching.
		 * @return Returns the index of the target. If not found, returns -1.
		 */
		public int binarySearchRecursive(float[] input, float target, int lower, int upper);
		
		/**
		 * Searches an array for a target via iterative ternary (searches 1/3 at a time) search.
		 * @param input Array to search
		 * @param target Target to search for
		 * @return Returns the index of the target. If not found, returns -1.
		 */
		public int ternarySearchIterative(float[] input, float target);
		
		/**
		 * Searches an array for a target via recursive ternary search.
		 * @param input Array to search
		 * @param target Target to search for
		 * @param lower Placeholder for recursion. This is the index of the lowest number to be considered.
		 * @param upper Also placeholder. Holds index of highest number to be considered for searching.
		 * @return Returns the index of the target. If not found, returns -1.
		 */
		public int ternarySearchRecursive(float[] input, float target, int lower, int upper);
		
		/**
		 * Searches an array for a target via iterative quad (searches 1/4 at a time) search.
		 * @param input Array to search
		 * @param target Target to search for
		 * @return Returns the index of the target. If not found, returns -1.
		 */
		public int quadSearchIterative(float[] input, float target);
		
		/**
		 * Searches an array for a target via recursive quad search.
		 * @param input Array to search
		 * @param target Target to search for
		 * @param lower Placeholder for recursion. This is the index of the lowest number to be considered.
		 * @param upper Also placeholder. Holds index of highest number to be considered for searching.
		 * @return Returns the index of the target. If not found, returns -1.
		 */
		public int quadSearchRecursive(float[] input, float target, int lower, int upper);

		/**
		 * Searches for two targets in an array. Returns the number of items between the two target indexes.
		 * @param input Array to search
		 * @param lower lower target to search for
		 * @param upper upper target to search for
		 * @return returns number of items between upper/lower targets. Returns -1 if either are not found.
		 */
		public int binaryRangeSearch(float[]input, float lower, float upper);
}
