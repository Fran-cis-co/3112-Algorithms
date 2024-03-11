package assignment3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Assignment3 {

	public static void mergeSort(ArrayList<Integer> arr) {
		// if the size of the array is bigger than one
		if (arr.size() > 1) {
			int mid = (arr.size() - 1) / 2; // get the mid section of the array

			// create the left side of the arraylist and fill the values
			ArrayList<Integer> left = new ArrayList<>();
			for (int i = 0; i <= mid; i++) {
				left.add(arr.get(i));
			}

			// recursive call to split the left side till the lists reach the size of 1
			mergeSort(left);

			// create the right side of the arraylist and fill the values
			ArrayList<Integer> right = new ArrayList<>();
			for (int i = mid + 1; i <= arr.size() - 1; i++) {
				right.add(arr.get(i));
			}

			// recursive call to split the right side till the lists reach the size of 1
			mergeSort(right);

			// once everything has been split, merge the lists together
			merge(left, right, arr);
		}
	}

	public static void merge(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> result) {
		int i, j, k;
		i = j = k = 0;
        // while i and j are less than both the respective list sizes

		while (i < list1.size() && j < list2.size()) {
            // set the value of list1[i] at index k in the result array
			if (list1.get(i).compareTo(list2.get(j)) <= 0) {

				result.set(k, list1.get(i));

				i++;

			} else
				//set the value of list[j] at index k in the result array
			{
				result.set(k, list2.get(j));
				j++;
			}
			k++; //increases by one
		}
			//while loop when i is less than list1
		while (i < list1.size()) {
			// set the rest of the value of list1 in the result list
			result.set(k, list1.get(i));
			i++;
			k++;
		}
		//while loop when j is less than list2
		while (j < list2.size()) {
			// set the rest of the values of list2 in the result list
			result.set(k, list2.get(j));
			j++;
			k++;
		}
	}

	public static int binarySearch(ArrayList<Integer> arr, int left, int right, int x) {
        // right greater than 1 is the base case
		if (right > 1) {
			int mid = left + (right - 1) / 2;
            // if the mid value of the array equals x, return the index of where it is

			if (arr.get(mid) == x) {
                // if the mid value of the array equals x, return the index of where it is
				return mid;
			}

			if (arr.get(mid) > x) {
                // if the mid is less than x, then the x should be at the left of the array
				return binarySearch(arr, left, mid - 1, x);
			}
            // if x is greater than the value in the middle of the array, the x value should be at the right of the array
			return binarySearch(arr, mid + 1, right, x);

		}

		return -1; //base case of element is not in the array
	}

	public static ArrayList<Integer> randomizeArray(int length) {

		ArrayList<Integer> temp = new ArrayList<>(); // Temporary array
		Random ran = new Random();

		// random array from 1 to 100
		for (int i = 0; i < length; i++) {
			int randInt = ran.nextInt(100);

			temp.add(randInt);
		}

		return temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length;
		Random r = new Random();

		do {
			//do while loop to get an integer
			System.out.println("Enter a number: ");

			while (!sc.hasNextInt()) {
				System.out.println("Not a number, enter a valid integer");
				sc.next();

			}
			length = sc.nextInt();

		} while (length < 0);

		ArrayList<Integer> arr = new ArrayList<>(); //initailize of the array
		arr = randomizeArray(length);

		System.out.println("\n -----Merge Sort-----");
		System.out.println("Array before Merge sort");//before merge sort
		for (int x : arr) {
			System.out.println(x + " ");

		}
		System.out.println("Array after Merge Sort");//merge sorted array
		mergeSort(arr);

		for (int x : arr) {
			System.out.println(x + " ");
		}

		System.out.println("\n -----Binary Search-----");
		System.out.println("Our Array: "); //binary search array

		for (int x : arr) {
			System.out.println(x + " ");

		}
		int index = r.nextInt(arr.size());//random index from the array

		System.out.println("\n\nIs " + arr.get(index) + " in our array? "); //random integer in our array

		int isInArray = binarySearch(arr, 0, arr.size() - 1, arr.get(index));
		//call the binary search method which will give the index postition of the value

		if (isInArray == -1) {
			System.out.println("The element " + index + " does not exist");

		} else {

			System.out.println("The element " + arr.get(index) + " is present at index " + isInArray);

		}
	}
}
