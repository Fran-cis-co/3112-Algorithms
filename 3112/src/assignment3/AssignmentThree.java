package assignment3;

// Francisco Contreras

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class AssignmentThree {
	
	public static void mergeSort(ArrayList<Integer> arr) {
		//if the size of the array is bigger than one
		if(arr.size() > 1) {
			int mid = (arr.size() - 1) / 2; // get the mid section of the array
			
			// create the left side of the arraylist and fill the values
			ArrayList<Integer> left = new ArrayList<>();
			for(int i = 0; i <= mid; i++) {
				left.add(arr.get(i));	
			}
			
			// recursive call to split the left side till the lists reach the size of 1
			mergeSort(left);
			
			// create the right side of the arraylist and fill the values
			ArrayList<Integer> right = new ArrayList<>();
			for(int i = mid + 1; i <= arr.size() - 1; i++) {
				right.add(arr.get(i));
			}
			
			// recursive call to split the right side till the lists reach the size of 1
			mergeSort(right);
			
			// once everything has been split, merge the lists together
			merge(left, right, arr);	
		}

	}
	
	public static void merge(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> result) {
		int i,j,k;
		i = j = k = 0;
		
		// while i and j are less than both the respective list sizes
		while(i < list1.size() && j < list2.size()) {
			
			//if list1[i] is less than list2[j]
			if(list1.get(i).compareTo(list2.get(j)) <= 0) {
				// set the value of list1[i] at index k in the result array
				result.set(k, list1.get(i));
				i++;
			} else {
				//set the value of list[j] at index k in the result array
				result.set(k, list2.get(j));
				j++;
			}
			k++; // increase k by one
		}
		
		// while i is less than list1 size
		while(i < list1.size()) {
			// set the rest of the values of list1 in the result list
			result.set(k, list1.get(i));
			i++;
			k++;
		}
		
		// while j is less than list2 size
		while(j < list2.size()) {
			// set the rest of the values of list2 in the result list
			result.set(k, list2.get(j));
			j++;
			k++;
		}
	}
	
	public static int binarySearch(ArrayList<Integer> arr, int left, int right, int x) {
		
		// right greater than 1 is the base case
		if(right > 1) { 
			int mid = left + (right - 1) / 2; // get the middle of the array
			
			if(arr.get(mid) == x) {
				// if the mid value of the array equals x, return the index of where it is
				return mid; 
			}
			
			if(arr.get(mid) > x) {
				// if the mid is less than x, then the x should be at the left of the array
				return binarySearch(arr, left, mid - 1, x);
			}
			
			// if x is greater than the value in the middle of the array, the x value should be at the right of the array
			return binarySearch(arr, mid + 1, right, x);

		}
		
		// base case is that if the element is not in the array
		return -1;	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length;
		Random r = new Random();

		// do while code to make sure the scanner gets a proper integer
		// The same method used as in assignment 2
		do {

			System.out.println("Please enter an integer for the array size: ");
			// if the scanner does not have an integer
			while (!sc.hasNextInt()) {
				System.out.println("That is not a integer. Please input a valid integer");
				sc.next(); // get rid of whatever was in the scanner
			}
			length = sc.nextInt();

		} while (length < 0);
		
		ArrayList<Integer> arr = new ArrayList<>(); // initialize array
		arr = randomizeArray(length);
		
		System.out.println("\n----- Merge Sort -----\n");
		System.out.println("Array before the merge sort algorithm");
		for(int x: arr) {
			System.out.print(x + " ");
		}
		System.out.println("\n\nArray after the merge sort algorithm: ");
		mergeSort(arr);
		
		for(int x: arr) {
			System.out.print(x + " ");
		}
		
		System.out.println("\n\n----- Binary Search -----\n");
		System.out.println("Our array: ");
		
		for(int x: arr) {
			System.out.print(x + " ");
		}
		
		int index = r.nextInt(arr.size()); // get a random index from the array
		
		System.out.println("\n\nIs " + arr.get(index) + " in our array? : ");
		int isInArray = binarySearch(arr, 0, arr.size() - 1, arr.get(index)); // call the binarySearch method and get which index the value is at
		
		
		if(isInArray == -1) {
			System.out.println("The element " + index + " is not present");
		} else {
			System.out.println("The element " + arr.get(index) + " is present at index " + isInArray);
		}
		
		sc.close();	
	}
	
	// method to randomize the array like in assignment 2
	public static ArrayList<Integer> randomizeArray(int length) {
		ArrayList<Integer> temp = new ArrayList<>(); // Temporary array
		Random ran = new Random();
		
		for(int i = 0; i < length; i++) {
			int randInt = ran.nextInt(100);
			
			temp.add(randInt); // set current slot of the array with the random number
		}
		
		return temp; // return the temp array with the randomized numbers
	}
	
	public static void printArray(ArrayList<Integer> arr) {
		for(int x: arr) {
			System.out.print(x + " ");
		}
	}

}
