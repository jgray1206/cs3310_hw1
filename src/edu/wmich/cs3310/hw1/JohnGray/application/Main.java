package edu.wmich.cs3310.hw1.JohnGray.application;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import edu.wmich.cs3310.hw1.JohnGray.search.Search;

public class Main {
	
	public static void main(String[] args){
		
		Random rand = new Random();
		Scanner scnr = new Scanner(System.in);
		
		int n;
		double m;
		int loops;
		
		m = getUserDouble("Enter upper bound of random numbers: ", scnr);
		n =	getUserInt("Enter how many random numbers to generate: ",scnr);
		loops = getUserInt("Enter how many times to test each function: ", scnr);
		
		double target1;
		double target2;
		double[] input;
		long[] outputs = new long[7];
		long[] times = new long[7];
		
		for(int i  = 0; i < loops; i++){
			input = randomSortedArray(n,m);
			target1 = rand.nextDouble()*m;
			target2 = rand.nextDouble()*m;
			outputs = testSearches(outputs, input, target1, target2);
			times = addArrays(times, outputs);
		}	
		
		System.out.printf("Iterative binary search avg time: %d ns\n"
				+ "Recursive binary search avg time: %d ns\n"
				+ "Iterative ternary search avg time: %d ns\n"
				+ "Recursive ternary search avg time: %d ns\n"
				+ "Iterative quadrary search avg time: %d ns\n"
				+ "Recursive quadrary search avg time: %d ns\n"
				+ "Ranged binary search avg time: %d ns\n", 
				times[0]/loops, times[1]/loops, times[2]/loops,
				times[3]/loops, times[4]/loops, times[5]/loops,
				times[6]/loops);	
		
		scnr.close();
	}
	
	public static long[] addArrays(long[] x, long[] y){
		
		for(int i = 0; i < x.length; i++){
			x[i]+=y[i];
		}
		
		return x;
	}
	
	public static double[] randomSortedArray(int n, double m){
		
		double[] randOutput = new double[n];
		Random rand = new Random();
		
		for(int i = 0; i < n; i++){
			randOutput[i] = (rand.nextDouble()*m);
		}
		
		Arrays.sort(randOutput);
		return randOutput;
	}
	
	public static double getUserDouble(String question, Scanner scnr){
		
		System.out.println(question);
		
		try{
			String input = scnr.nextLine();
			double output = Double.parseDouble(input.trim());
			return output;
		}catch(NumberFormatException e){
			return getUserDouble("Sorry. Please enter valid Double: ", scnr);
		}
	}
	
	public static int getUserInt(String question, Scanner scnr){
		
		System.out.println(question);
		
		try{
			String input = scnr.nextLine();
			int output = Integer.parseInt(input.trim());
			return output;
		}catch(NumberFormatException e){
			return getUserInt("Sorry. Please enter valid Integer: ",scnr);
		}
		
	}
	
	public static long[] testSearches(long[] outputs, double[] input, double target1, double target2){
		
		Search search = new Search();
		long begin, end;
		
		begin = System.nanoTime();
		search.binarySearchIterative(input, target1);
		end = System.nanoTime();
		outputs[0] = end-begin;
		
		begin = System.nanoTime();
		search.binarySearchRecursive(input, target1, 0, input.length-1);
		end = System.nanoTime();
		outputs[1] = end-begin;
		
		begin = System.nanoTime();
		search.ternarySearchIterative(input, target1);
		end = System.nanoTime();
		outputs[2] = end-begin;
		
		begin = System.nanoTime();
		search.ternarySearchRecursive(input, target1, 0, input.length-1);
		end = System.nanoTime();
		outputs[3] = end-begin;
		
		begin = System.nanoTime();
		search.quadSearchIterative(input, target1);
		end = System.nanoTime();
		outputs[4] = end-begin;
		
		begin = System.nanoTime();
		search.quadSearchRecursive(input, target1, 0, input.length-1);
		end = System.nanoTime();
		outputs[5] = end-begin;
		
		begin = System.nanoTime();
		search.binaryRangeSearch(input, target1, target2);
		end = System.nanoTime();
		outputs[6] = end-begin;
		
		return outputs;
		
		
	}
}
