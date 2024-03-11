package assignment5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Assignment7 {
	// method one
	public static float methodOneHires(int n) {
		 float sum = 0;

		for (int i = 1; i <= n; i++) {
			sum += (1 / (float) i);
		}

		return sum;
	}

	// method two
	public static float methodTwoHires(int[] arr, int n) {
		int[] numOfHires = new int[10000];
		for (int i = 0; i < 10000; i++) {
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

		for (List<Integer> permutation : allPermutations) {
			int[] temp = new int[permutation.size()];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = permutation.get(i);
			}
			int hires = hireAssistant(temp, n);
			numOfHires[k] = hires;
			k += 1;
		}

		return averageHires(numOfHires);
	}

	// method four
	public static float methodFourHires(float n) {
		return (float) Math.log(n);
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println("For n = 4 \n");

		System.out.printf("Number of hires: %.3f", methodOneHires(n));
		System.out.println();

		int[] arr = new int[n];
		fillArray(arr);
		System.out.println("Average Hires in 10,000 randomized arrays: " + methodTwoHires(arr, n) + "\n");

		System.out.printf("Average Hires for n! permutations : %.3f\n", methodThreeHires(arr, n));

		System.out.printf("Number of hires: %.3f\n", methodFourHires(n));
	}

	// Helper Methods

	// fill the array from 1 to n
	public static int[] fillArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		return arr;
	}

	// randomize array
	public static int[] randomizeInPlace(int[] arr, int n) {
		Random ran = new Random();

		for (int i = 0; i < n; i++) {
			int ranNum = ran.nextInt(((n - 1) - 0) + 1) + 0;
			int temp1 = arr[i];
			int temp2 = arr[ranNum];

			arr[i] = temp2;
			arr[ranNum] = temp1;
		}
		return arr;
	}

	// hire the best candidates
	public static int hireAssistant(int[] arr, int n) {
		ArrayList<Integer> hires = new ArrayList<Integer>();
		int best = arr[0];
		hires.add(best); // hire the first candidate by default

		for (int i = 1; i < n; i++) {
			if (arr[i] < best) {
				best = arr[i];
				hires.add(best);
			}
		}

		return hires.size();
	}

	// average of number of hires
	public static float averageHires(int[] arr) {
		int sum = 0;

		for (int x : arr) {
			sum += x;
		}

		float average = sum / (float)arr.length;

		return average;
	}

	// get the permutations of the list
	public static List<List<Integer>> permutation(int[] arr) {
		List<List<Integer>> tempList = new ArrayList<>();
		permutationHelper(tempList, new ArrayList<>(), arr);
		return tempList;
	}

	private static void permutationHelper(List<List<Integer>> tempList, List<Integer> res, int[] arr) {
		if (res.size() == arr.length) {
			tempList.add(new ArrayList<>(res));
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (res.contains(arr[i])) {
					continue;
				}

				res.add(arr[i]);
				permutationHelper(tempList, res, arr);
				res.remove(res.size() - 1);
			}
		}
	}
}
