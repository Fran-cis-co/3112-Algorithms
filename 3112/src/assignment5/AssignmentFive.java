package assignment5;

// for n = 8, the number of hires were the same for each method
// for n = 10, the number of hires were the same but method 3 took longer
// for n = 12, the number of hires for method 1 and 2 were different, but method 3 took too long
// if n = 50, the program can give the result for methods 1,2, and 4 but with method 3 it will take too long

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AssignmentFive {
	
	// method one
	public static float methodOneHires(int n) {
		float sum = 1;
		
		for(int i = 1; i <= n; i++) {
			sum += (1/i);
		}
		
		return sum;
	}
	
	// method two
	public static float methodTwoHires(int[] arr,int n) {
		int[] numOfHires = new int[10000];
		for(int i = 0; i < 10000; i++) {
			int hires = hireAssistant(randomizeInPlace(arr, n), n);
			numOfHires[i] = hires;
		}
		
		return averageHires(numOfHires);
	}
	
	// method three
	public static float methodThreeHires(int[] arr, int n) {
		List<List<Integer>> allPermutations = permutation(arr);
		int[] numOfHires = new int[allPermutations.size()];
		int k = 0;
		
		for(List<Integer> permutation: allPermutations) {
			int[] temp = new int[permutation.size()];
			for(int i = 0; i < temp.length;i++) {
				temp[i] = permutation.get(i);
			}
			int hires = hireAssistant(temp,n);
			numOfHires[k] = hires;
			k += 1;
		}
		
		return averageHires(numOfHires);
	}
	
	// method four
	public static int methodFourHires(int n) {
		return (int) Math.log(n);
	}
	
	public static void main(String[] args) {
		int n = 4;
		System.out.println("For n = 4 \n");
		
		System.out.println("----- Method 1 -----\n");
		System.out.println("Number of hires: " + methodOneHires(n) + "\n");
		
		int [] arr = new int[n];
		fillArray(arr);
		System.out.println("----- Method 2 -----\n");
		System.out.println("Average Hires in 10,000 randomized arrays: " + methodTwoHires(arr, n) + "\n");
		
		System.out.println("----- Method 3 -----\n");
		System.out.println("Average Hires for n! permutations : " + methodThreeHires(arr, n) + "\n");
		
		System.out.println("----- Method 4 -----\n");
		System.out.println("Number of hires: " + methodFourHires(n) + "\n");
	}
	
	// Helper Methods
	
	// fill the array from 1 to n
	public static int[] fillArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		return arr;
	}
	
	// randomize array
	public static int[] randomizeInPlace(int[] arr, int n) {
		Random ran = new Random();
		
		for(int i = 0; i < n; i++) {
			int ranNum = ran.nextInt(((n-1) - 0) + 1) + 0;
			int temp1 = arr[i];
			int temp2 = arr[ranNum];
			
			arr[i] = temp2;
			arr[ranNum] = temp1;
		}
		return arr;
	}
	
	// hire the best candidates
	public static int hireAssistant(int[] arr,int n) {
		ArrayList<Integer> hires = new ArrayList<Integer>();
		int best = arr[0];
		hires.add(best); // hire the first candidate by default
		
		for(int i = 1; i < n; i++) {
			if(arr[i] < best) {
				best = arr[i];
				hires.add(best);
			}
		}
		
		return hires.size();
	}
	
	// average of number of hires
	public static float averageHires(int[] arr) {
		float sum = 0;
		
		for(int x: arr) {
			sum += x;
		}
		
		float average = sum / arr.length;
		
		return average;
	}
	
	// get the permutations of the list
	public static List<List<Integer>> permutation(int[] arr){
		List<List<Integer>> tempList = new ArrayList<>();
		permutationHelper(tempList, new ArrayList<>(), arr);
		return tempList;
	}
	
	private static void permutationHelper(List<List<Integer>> tempList, List<Integer> res, int[] arr) {
		if(res.size() == arr.length) {
			tempList.add(new ArrayList<>(res));
		} else {
			for(int i = 0; i < arr.length; i++) {
				if(res.contains(arr[i])) {
					continue;
				}
				
				res.add(arr[i]);
				permutationHelper(tempList, res, arr);
				res.remove(res.size() - 1);
			}
		}
	}
	
}
