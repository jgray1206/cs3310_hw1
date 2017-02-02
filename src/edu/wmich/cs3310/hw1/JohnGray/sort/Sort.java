package edu.wmich.cs3310.hw1.JohnGray.sort;

public class Sort implements ISort {

	@Override
	public int binarySearchIterative(double[] input, double target) {
		
		int upper = input.length-1;
		int lower = 0;
		int mid;
		
		while(upper>=lower){
			mid = (upper+lower)/2;
			
			if(input[mid]==target){
				return mid;
			}
			
			else if(input[mid]>target){
				upper = mid-1;
			}
			
			else{
				lower = mid+1;
			}
			
		}
		
		return -1;
	}

	@Override
	public int binarySearchRecursive(double[] input, double target, int lower, int upper) {
		
		int mid = (lower+upper)/2;
		
		if(lower>upper){
			return -1;
		}
		else{
			if(input[mid]==target){
				return mid;
			}
			
			else if(input[mid]>target){
				return binarySearchRecursive(input, target, lower, mid-1);
			}
			
			else{
				return binarySearchRecursive(input, target, mid+1, upper);
			}
		}
	}

	@Override
	public int ternarySearchIterative(double[] input, double target) {
		int upper = input.length-1;
		int lower = 0;
		int mid1, mid2;
		
		while(upper>=lower){
			
			mid1 = (upper+lower)/3;
			mid2 = (2*upper+lower)/3;
			
			if(input[mid1]==target){
				return mid1;
			}
			else if(input[mid2]==target){
				return mid2;
			}
			else if(input[mid1]>target){
				upper = mid1-1;
			}
			else if(input[mid2]>target){
				upper=mid2-1;
				lower=mid1+1;
			}
			else{
				lower = mid2+1;
			}
		}
		
		return -1;
	}

	@Override
	public int ternarySearchRecursive(double[] input, double target, int lower, int upper) {
		int mid1 = (upper+lower)/3;
		int mid2 = (2*upper+lower)/3;
		
		if(lower>upper){
			return -1;
		}
		else if (input[mid1]==target){
			return mid1;
		}
		else if(input[mid2]==target){
			return mid2;
		}
		else if(input[mid1]>target){
			return ternarySearchRecursive(input, target, lower, mid1-1);
		}
		else if(input[mid2]>target){
			return ternarySearchRecursive(input, target, mid1+1, mid2-1);
		}
		else{
			return ternarySearchRecursive(input, target, mid2+1, upper);
		}
	}

	@Override
	public int quadSearchIterative(double[] input, double target) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int quadSearchRecursive(double[] input, double target, int lower, int upper) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int binaryRangeSearch(double[] input, double lower, double upper) {
		// TODO Auto-generated method stub
		return 0;
	}

}
