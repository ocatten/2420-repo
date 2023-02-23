/**
 * This class sorts arrayLists that are permuted or sorted in descending or ascending order and compares mergesort
 * and quicksort against one another to find which is faster. No built-in sorting methods can be used unless otherwise
 * specified.
 * 
 * @author Parker Catten @u0580588 & Everett Oglesby
 * @version 02:23:23
 * CS 2420-001_SP-2023
 */

package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSorter {
	
	/**
	 * Takes a generic class object and performs a mergesort on the arrayList of the generic objects.
	 * 
	 * @param arr: ArrayList of generic items to be sorted
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr) {
		
	}
	
	
	
	/**
	 * Takes an arrayList of generic class objects and sorts it through quicksort.
	 * 
	 * @param arr: ArrayList of generic objects to be sorted.
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr) {
		
		// Catch case for smaller arrayLists
		if (arr.size() <= 1) {
			return; // If the array is smaller than 2 elements, it's already sorted.
		}
		
		// Calculate the pivot as the middle of the array and instantiate the low/high indexes
		int low = 0;
		int high = arr.size() - 1;
		int pivot = pivotAtMid(arr); // Easily changeable
		
		
		T objAtPivot = arr.get(pivot);
		// Set the pivot to the end and start making comparisons.
		Collections.swap(arr, high, pivot);
	
		Comparator<T> cmp = new Comparator<T>() { // Makes the comparator to make comparisons with.
			public int compare(T e1, T e2) { return e1.compareTo(e2); } };
		
			
		high = arr.indexOf(objAtPivot) - 1;
		low = 0;
		
		while (low < high) {
			
			while (cmp.compare( arr.get(low), arr.get(pivot) ) > 1) {
				low++;
				System.out.println(" low not found ");
			}
			
			while (cmp.compare( arr.get(high), arr.get(pivot) ) > 1) {
				high--;
				
				System.out.println(" high not found ");
			}
			
			Collections.swap(arr, high, low);
		}
	}
	
	
	/**
	 * Helper method for determining the pivot, so that the code can easily switch between
	 * three different strategies for determining the pivot point on quicksort.
	 * This method returns the center of the array.
	 * 
	 * @param arr: List that the method will compute the pivot point for.
	 * @return int: Index of the pivot.
	 */
	private static <T> int pivotAtMid(ArrayList<T> arr) {
		return arr.size() / 2;
	}
	
	/**
	 * Helper method for determining the pivot, so that the code can easily switch between
	 * three different strategies for determining the pivot point on quicksort.
	 * This method returns the low of the array, or 0.
	 *
	 * @param high: Highest index the method will be sorting for
	 * @return int: Index of the pivot.
	 */
	private static <T> int pivotAtLow(ArrayList<T> arr) {
		return 0;
	}
	
	/**
	 * Helper method for determining the pivot, so that the code can easily switch between
	 * three different strategies for determining the pivot point on quicksort.
	 * This method returns the center of the array.
	 * 
	 * @param arr: List that the method will compute the pivot point for.
	 * @return int: Index of the pivot.
	 */
	private static <T> int pivotAtHigh(ArrayList<T> arr) {
		return arr.size();
	}
	
	
	
	/**
	 * Generates an arrayList of 1 to size in ascending order.
	 * 
	 * @param size: Size of the returned array.
	 * @return ArrayList<Integer>: The sorted arrayList in ascending order from 1 to size
	 */
	public static ArrayList<Integer> generateAscending(int size) {
		
		ArrayList<Integer> returnArr = new ArrayList<Integer>();
		
		// Add a new element, 1 to size to the returned arrayList.
		for (int i = 1; i <= size; i++) {
			returnArr.add(i);
		}
		
		return returnArr;
	}
	
	
	
	/**
	 * Generates a permuted(random) series of numbers from 1 to size and returns an arrayList of them
	 * 
	 * @param size: Greatest value of the values and the size of the returned ArrayList
	 * @return ArrayList<Integer>: Permuted arrayList of 1 to size
	 */
	public static ArrayList<Integer> generatePermuted(int size) {
		
		ArrayList<Integer> returnArr = new ArrayList<Integer>();
		
		// Add a new element, 1 to size to the returned arrayList.
		for (int i = 1; i <= size; i++) {
			returnArr.add(i);
		}
		
		// Now, the sorted list needs to be shuffled:
		Collections.shuffle(returnArr);
		
		return returnArr;
	}
	
	
	
	/**
	 * Generates an arrayList of 1 to size in descending order.
	 * 
	 * @param size: Size of the returned array.
	 * @return ArrayList<Integer>: The sorted arrayList in descending order from 1 to size
	 */
	public static ArrayList<Integer> generateDescending(int size) {
		
		ArrayList<Integer> returnArr = new ArrayList<Integer>();
		
		// Add a new element, size to 1 to the returned arrayList.
		for (int i = size; 0 < i; i--) {
			returnArr.add(i);
		}
		
		return returnArr;
	}
}
