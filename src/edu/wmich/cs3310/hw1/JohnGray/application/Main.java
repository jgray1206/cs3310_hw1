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
		
		System.out.println("Enter upper bound of random numbers:");
		m = scnr.nextInt();
		System.out.println("Enter how many random numbers to generate:");
		n = scnr.nextInt();
		System.out.println("How many tests?");
		loops = scnr.nextInt();
		
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
}
