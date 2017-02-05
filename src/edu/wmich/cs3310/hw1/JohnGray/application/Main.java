package edu.wmich.cs3310.hw1.JohnGray.application;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import edu.wmich.cs3310.hw1.JohnGray.search.Search;

/**
 * This class deals with all user input, timing, and data generation for testing
 * the included search functions in Search.
 * 
 * @author john
 *
 */
public class Main {
	
	/**
	 * The start of the program.
	 * Gets user input, tests accordingly, and prints results.
	 * 
	 * @param args Command line input
	 */
	public static void main(String[] args){
		
		//Initialize objects
		Random rand = new Random();
		Scanner scnr = new Scanner(System.in);
		
		//Declare array/loop variables
		int n;
		float m;
		int loops;
		float target1;
		float target2;
		
		
		//Gets user input for array specifications
		m = getUserFloat("Enter upper bound of random numbers: ", scnr);
		n =	getUserInt("Enter how many random numbers to generate: ",scnr);
		loops = getUserInt("Enter how many times to test each function: ", scnr);
		
		//Declare timing variables
		float[] input;
		long[] outputs = new long[7];
		long[] times = new long[7];
		
		/* Main loop. For each loop, it will generate a random sorted array,
		   a random target, and test each search method with this generated data.
		*/
		for(int i  = 0; i < loops; i++){
			input = randomSortedArray(n,m);
			target1 = rand.nextFloat()*m;
			target2 = rand.nextFloat()*m;
			outputs = testSearches(outputs, input, target1, target2); //retrieves all run times
			times = addArrays(times, outputs); //sums them all up into times
		}	
		
		//Prints out the average times of each search method.
		System.out.printf("Iterative binary search avg time: %d ns\n"
				+ "Recursive binary search avg time: %d ns\n"
				+ "Iterative ternary search avg time: %d ns\n"
				+ "Recursive ternary search avg time: %d ns\n"
				+ "Iterative quadrary search avg time: %d ns\n"
				+ "Recursive quadrary search avg time: %d ns\n"
				+ "Ranged binary search avg time: %d ns\n", 
				times[0]/loops, times[1]/loops, times[2]/loops, //divides all sums by how many
				times[3]/loops, times[4]/loops, times[5]/loops, //loops it ran, giving an average time.
 				times[6]/loops);	
		
		//Close scanner
		scnr.close();
	}
	
	/**
	 * Adds two arrays x,y and stores results in x. 
	 * I used this method for adding times of the 
	 * individual searches.
	 * 
	 * @param x First array. Y gets added to this.
	 * @param y Second array. Gets added to X.
	 * @return Returns X, the sum of both arrays.
	 */
	public static long[] addArrays(long[] x, long[] y){
		
		/* for each float value in y, it will add the corresponding
		   number to x and return x */
		for(int i = 0; i < x.length; i++){
			x[i]+=y[i];
		}
		
		return x;
	}
	
	/**
	 * Produces an array filled with n random numbers of up to m value.
	 * @param n Length of array
	 * @param m Upper bound of possible generated numbers
	 * @return Returns the random array
	 */
	public static float[] randomSortedArray(int n, float m){
		//try/catch in case user inputs too big of numbers
		try{ 
			
			//initialize objects
			float[] randOutput = new float[Math.abs(n)]; //Math.abs to eliminate negative array possibility
			Random rand = new Random();
		
			
			//fill array with n random numbers in range (0,M]
			for(int i = 0; i < n; i++){
				randOutput[i] = (rand.nextFloat()*m);
			}
			
			//Sort array and return
			Arrays.sort(randOutput);
			return randOutput;
			
		}catch(OutOfMemoryError e){
			System.out.println("Inputted Array size to big. Restart and try again.");
			System.exit(0);
		}
		return null;
	}
	
	/**
	 * When called, it will validate and accept user input.
	 * Only accepts a valid float. Continues until it gets one.
	 * @param question A string containing a question to print.
	 * @param scnr A scanner object from main. 
 	 * @return Returns valid user input to store in variable.
	 */
	public static float getUserFloat(String question, Scanner scnr){
		
		//Asks user for what is to be inputed
		System.out.println(question);
		
		
		//Attempts to get input
		try{
			String input = scnr.nextLine();
			float output = Float.parseFloat(input.trim());
			return output;
		}catch(NumberFormatException e){		//if not valid, retry
			return getUserFloat("Sorry. Please enter valid float: ", scnr);
		}
	}
	
	/**
	 * When called, it will validate and accept user input.
	 * Only accepts a valid integer. Continues until it gets one.
	 * @param question A string containing the question to print.
	 * @param scnr A scanner object from main. 
	 * @return Returns valid user input to store in variable.
	 */
	public static int getUserInt(String question, Scanner scnr){
		
		//Asks user for what is to be inputed
		System.out.println(question);
		
		//Attempts to get input
		try{
			String input = scnr.nextLine();
			int output = Integer.parseInt(input.trim());
			return output;
		}catch(NumberFormatException e){		//if not valid, retry
			return getUserInt("Sorry. Please enter valid Integer: ",scnr);
		}
		
	}
	
	/**
	 * Tests each search function with the current instance
	 * of the random array.
	 * @param outputs The run times of each search function.
	 * @param input A random sorted array.
	 * @param target1 Used by all functions: target for search. Random float.
	 * @param target2 Used by binary range search: target for upper bound. Random float.
	 * @return Returns an array containing the run times of each search, in order.
	 */
	public static long[] testSearches(long[] outputs, float[] input, float target1, float target2){
		
		//initialize timing objects and variables
		Search search = new Search();
		long begin, end;
		
		//Tests iterative binary search, stores run time.
		begin = System.nanoTime();
		search.binarySearchIterative(input, target1);
		end = System.nanoTime();
		outputs[0] = end-begin;

		//Tests recursive binary search, stores run time.
		begin = System.nanoTime();
		search.binarySearchRecursive(input, target1, 0, input.length-1);
		end = System.nanoTime();
		outputs[1] = end-begin;
		
		//Tests iterative ternary search, stores run time.
		begin = System.nanoTime();
		search.ternarySearchIterative(input, target1);
		end = System.nanoTime();
		outputs[2] = end-begin;
		
		//Tests recursive ternary search, stores run time.
		begin = System.nanoTime();
		search.ternarySearchRecursive(input, target1, 0, input.length-1);
		end = System.nanoTime();
		outputs[3] = end-begin;
		
		//Tests iterative quad search, stores run time.
		begin = System.nanoTime();
		search.quadSearchIterative(input, target1);
		end = System.nanoTime();
		outputs[4] = end-begin;
		
		//Tests recursive quad search, stores run time.
		begin = System.nanoTime();
		search.quadSearchRecursive(input, target1, 0, input.length-1);
		end = System.nanoTime();
		outputs[5] = end-begin;
		
		//Tests iterative ranged binary search, stores run time.
		begin = System.nanoTime();
		search.binaryRangeSearch(input, target1, target2);
		end = System.nanoTime();
		outputs[6] = end-begin;
		
		//Returns an array of all run times.
		return outputs;
		
		
	}
}
