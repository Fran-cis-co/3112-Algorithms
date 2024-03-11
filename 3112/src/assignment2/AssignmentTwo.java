package assignment2;

//Francisco Contreras

import java.util.Random;
import java.util.Scanner;

public class AssignmentTwo {
	
	public static void insertionSort(int[] array) {
		int i;
		int j;
		
		for(i = 1; i <= array.length - 1; i++) {
			int key = array[i]; // create a key
			j = i; // set j to the current iteration of i
			
			// while j is greater than zero so we won't go out of bounds and the key is greater than array[j - 1]
			while((j > 0) && (key < array[j - 1])) {
				array[j] = array[j - 1]; // set the value of array[j - 1] to array[1]
				j--; // decrease j by one
			}
			array[j] = key; // put the current iterated key in its new storage
		}
		
		// print out the sorted array
		for(int x: array) {
			System.out.print(x + " ");
		}
	}
	
	public static void selectionSort(int[] array) {
		for(int i = 0; i <= array.length - 1; i++) {
			int min = i; // set a value called min to the current value of i
			
			// inner for loop that goes through the array but ahead of the outer loop
			for(int j = i + 1; j <= array.length - 1; j++) {
				// if the value of array[j] is less than the value behind it
				if(array[j] < array[min]) {
					min = j; // set the min to j
				}
			}
			// swap array[i] and array[min]
			int temp1 = array[i];
			int temp2 = array[min];
			array[i] = temp2;
			array[min] = temp1;
		}
		
		// print out the sorted array
		for(int x: array) {
			System.out.print(x + " ");
		}
	}
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrayLength;

		// do while code to make sure the scanner gets a proper integer
		do {
			
			System.out.println("Please enter an integer for the array size: ");
			// if the scanner does not have an integer
			while(!sc.hasNextInt()) {
				System.out.println("That is not a integer. Please input a valid integer");
				sc.next(); // get rid of whatever was in the scanner
			}
			arrayLength = sc.nextInt();
			
		} while(arrayLength < 0);
		
		int[] arr = new int[arrayLength]; // initialize array
		arr = randomizeArray(arrayLength); // call method to input random numbers into the array
		
		System.out.println("----- selection Sort -----\n");
		System.out.println("Array before the selction sort algorithm: ");
		for(int x: arr) {
			System.out.print(x + " ");
		}
		System.out.println("\n\nArray after the selection sort algorithm: ");
		selectionSort(arr); // call selection sort method
		
		arr = randomizeArray(arrayLength); // re-randomize the array
		
		System.out.println("\n\n----- Insertion Sort -----\n");
		System.out.println("Array before the insertion sort algorithm: ");
		for(int x: arr) {
			System.out.print(x + " ");
		}
		System.out.println("\n\nArray after the insertion sort algorithm: ");
		insertionSort(arr); // call insertion sort method
		
		sc.close();
	}
	
	public static int[] randomizeArray(int length) {
		int[] temp = new int[length]; // Temporary array
		Random ran = new Random();
		
		
		for(int i = 0; i < length; i++) {
			int randInt = ran.nextInt(100); // generate a random number from 0 to 99
			
			temp[i] = randInt; // set current slot of the array with the random number
		}
		
		return temp; // return the temp array with the randomized numbers
	}

}
