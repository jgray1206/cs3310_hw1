package edu.wmich.cs3310.hw1.JohnGray.search;

public interface ISearch {
		
		public int binarySearchIterative(float[] input, float target);
		
		public int binarySearchRecursive(float[] input, float target, int lower, int upper);
		
		public int ternarySearchIterative(float[] input, float target);
		
		public int ternarySearchRecursive(float[] input, float target, int lower, int upper);
		
		public int quadSearchIterative(float[] input, float target);
		
		public int quadSearchRecursive(float[] input, float target, int lower, int upper);

		public int binaryRangeSearch(float[]input, float lower, float upper);
}
