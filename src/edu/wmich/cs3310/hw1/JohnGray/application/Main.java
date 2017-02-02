package edu.wmich.cs3310.hw1.JohnGray.application;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import edu.wmich.cs3310.hw1.JohnGray.sort.Sort;

public class Main {
	
	public static void main(String[] args){
		
		Random rand = new Random();
		Scanner scnr = new Scanner(System.in);
		
		int n;
		double m;
		int loops;
		double target;
		
		m = getUserDouble("Enter upper bound of random numbers: ", scnr);
		n =	getUserInt("Enter how many random numbers to generate: ",scnr);
		loops = getUserInt("Enter how many times to test each function: ", scnr);
		
		for(int i  = 0; i < loops; i++){
			double[] input = randomSortedArray(n,m);
			target = rand.nextDouble()*m;
		}	
		
		scnr.close();
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
}
