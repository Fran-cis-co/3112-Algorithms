package assignment4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AssignmentFour {
	// Brute force algorithm
	public static int bruteForceMaxSubArray(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int left = 0;
		int right = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int sum = 0;
			for(int j = i; j < arr.length; j++) {
				sum += arr[j];
				if(sum > maxSum) {
					maxSum = sum;
					left = i;
					right = j;
				}
			}
		}
		return maxSum;
	}
	
	// Divide-and-Conquer algorithm
	public static int findMaxCrossingSubarray(int[] a, int low, int mid, int high) {
		int leftSum = -1000000;
		int sum = 0;
		
		for(int i = mid; i >= low; i--) {
			sum = sum + a[i];
			if (sum > leftSum) {
				leftSum = sum;
			}
		}
		
		sum = 0;
		int rightSum = -1000000;
		
		for(int i = mid + 1; i <= high; i++) {
			sum = sum + a[i];
			if (sum > rightSum) {
				rightSum = sum;
			}
		}
		
		return leftSum + rightSum;
	}
	
	public static int findMaximumSubarray(int[] a, int low, int high) {
		
		if (high == low) { // base case is only one element
			return a[low];
		} else {
			int mid = (low + high) / 2; // Acquire the midpoint of the array
			
			int leftSum = findMaximumSubarray(a, low, mid);
			int rightSum = findMaximumSubarray(a, mid + 1, high);
			int crossSum = findMaxCrossingSubarray(a, low, mid, high);
			
			return Math.max(Math.max(leftSum, rightSum), crossSum);
		}
			
			
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length;
		
		// do while code to make sure the scanner gets a proper integer
		do {

			System.out.println("Please enter an integer for the array size: ");
			// if the scanner does not have an integer
			while (!sc.hasNextInt()) {
				System.out.println("That is not a integer. Please input a valid integer");
				sc.next(); // get rid of whatever was in the scanner
			}
			length = sc.nextInt();

		} while (length < 0);

		int[] arr = new int[length]; // initialize array
		
		arr = randomizeArray(length);
		System.out.println("\n1. Brute Force algorithm\n");
		System.out.println("Our Array: ");
		printArray(arr);
		System.out.println("\n\nMax Subarray: ");
		printArray(maxSubArray(arr));
		int sum1 = bruteForceMaxSubArray(arr);
		System.out.println("\n\nSum of Max Subarray: ");
		System.out.println(sum1);
		
		arr = randomizeArray(length);
		System.out.println("\n2. Divide-and-conquer algorithm\n");
		System.out.println("Our Array: ");
		printArray(arr);
		System.out.println("\n\nMax Subarray: ");
		printArray(maxSubArray(arr));
		int sum2 = findMaximumSubarray(arr, 0, arr.length - 1);
		System.out.println("\n\nSum of Max Subarray: ");
		System.out.println(sum2);
	}

	// method to randomize the array like in assignment 2
	public static int[] randomizeArray(int length) {
		int[] temp = new int[length]; // Temporary array
		Random ran = new Random();

		for (int i = 0; i < length; i++) {
			int randInt = ran.nextInt(20 + 10) - 10;

			temp[i] = (randInt); // set current slot of the array with the random number
		}

		return temp; // return the temp array with the randomized numbers
	}
	
	// method to print array
	public static void printArray(int[] arr) {
		for(int x: arr) {
			System.out.print(x + " ");
		}
	}
	
	// method to find maximum subarray
	public static int[] maxSubArray(int[] arr) {
		int max = Integer.MIN_VALUE;
		int maxEnd = 0;
		int low = 0, high = 0;
		int start = 0;
		
		if (arr.length == 1) {
			return arr;
		}
		
		for(int i = 0; i < arr.length; i++) {
			maxEnd += arr[i];
			
			if(maxEnd < arr[i]) {
				maxEnd = arr[i];
				start = i;
			}
			
			if(max < maxEnd) {
				max = maxEnd;
				low = start;
				high = i;
			}
		}
		return Arrays.copyOfRange(arr,low,high + 1);
	}
}
