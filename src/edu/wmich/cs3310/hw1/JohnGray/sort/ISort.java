package edu.wmich.cs3310.hw1.JohnGray.sort;

public interface ISort {
		
		public int binarySearchIterative(double[] input, double target);
		
		public int binarySearchRecursive(double[] input, double target, int lower, int upper);
		
		public int ternarySearchIterative(double[] input, double target);
		
		public int ternarySearchRecursive(double[] input, double target, int lower, int upper);
		
		public int quadSearchIterative(double[] input, double target);
		
		public int quadSearchRecursive(double[] input, double target, int lower, int upper);

		public int binaryRangeSearch(double[]input, double lower, double upper);
}
