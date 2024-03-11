package assignment1;

import java.util.ArrayList;

public class AssignmentOne {
	
	public static void firstNPrimes(int n) {
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		
		int count = 0;
		int testPrime = 2;
		while(count != n) {
			boolean isPrime = true; // set to true by default
			
			// iterate through the numbers till the square root of the tested number
			for(int i = 2; i <= Math.sqrt(testPrime); i++) {
				if(testPrime % i == 0) { // if prime % i is zero set isPrime to false
					isPrime = false;
					break;
				}
			}
			
			// add the number if it is prime to the list and increase the count
			if(isPrime) {
				count++;
				primeNumbers.add(testPrime);
			}
			
			// increase the number to test whether it is a prime
			testPrime++;
		}
		
		// print the prime numbers
		for(int x: primeNumbers) {
			System.out.print(x + " ");
		}
	}
	
	
	public static void primesNotExceedingN(int n) {
		int[] primeNumbers = new int[n]; // create array with size of int n
		
		for(int i = 2; i < primeNumbers.length; i++) {
			primeNumbers[i] = i; // insert all numbers that are possible prime numbers before n
		}
		
		// iterate through up till the square root of n
		for(int i = 2; i < Math.sqrt(n); i++) {
			// if our number is not zero
			if(primeNumbers[i] != 0) {
				// set j to i^2 and increase j by i
				for(int j = (i * i); j < n; j += i) {
					primeNumbers[j] = 0; // eliminate the number that is not the prime
				}
			}
		}
		
		// print all the numbers in the array that are not zero
		for(int x: primeNumbers) {
			if(x != 0) {
				System.out.print(x + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("----- Number 1 -----");
		System.out.println("The first 3 prime numbers: ");
		firstNPrimes(3);
		System.out.println("\nThe first 10 prime numbers: ");
		firstNPrimes(10);
		System.out.println("\nThe first 30 prime numbers: ");
		firstNPrimes(30);
		
		System.out.println("\n\n----- Number 2 -----");
		System.out.println("Primes not exceeding the number 10: ");
		primesNotExceedingN(10);
		System.out.println("\nPrimes not exceeding the number 16: ");
		primesNotExceedingN(16);
		System.out.println("\nPrimes not exceeding the number 25: ");
		primesNotExceedingN(20);

	}


}
