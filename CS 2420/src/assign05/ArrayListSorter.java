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
	    // Create a new temporary list to sort
	    ArrayList<T> tempList = new ArrayList<>(arr);
	    // Sort the new list
	    sort(tempList, 0, tempList.size() - 1);
	    System.out.println(tempList.toString() + " temp list");
	    arr = tempList;
	}

	// Helper method for merge sort driver
	public static <T extends Comparable<? super T>> void sort(ArrayList<T> tempList, int start, int end) {
	    if (start < end) {
	        int mid = (start + end) / 2;

	        // Sort the first and second half
	        sort(tempList, start, mid);
	        sort(tempList, mid + 1, end);

	        // Merge the sorted halves
	        merge(tempList, start, mid, end);
	    }
	}

	// Merges the two sub-arrays together
	private static <T extends Comparable<? super T>> void merge(ArrayList<T> tempList, int left, int mid, int right) {
	    // Find sizes of two sub-arrays to be merged
	    int list1 = mid - left + 1;
	    int list2 = right - mid;

	    // Create temp arrays
	    ArrayList<T> leftSide = new ArrayList<>(Collections.nCopies(list1, null));
	    ArrayList<T> rightSide = new ArrayList<>(Collections.nCopies(list2, null));

 
        /*Copy data to temp arrays*/
        for (int i=0; i < list1; ++i)
        	leftSide.set(i, tempList.get(left + i));
        for (int j=0; j < list2; ++j)
        	rightSide.set(j, tempList.get(mid + 1 + j));
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;
 
        // Initial index of merged sub-array array
        int k = left;
        while (i < list1 && j < list2)
        {
            if(leftSide.get(i).compareTo(rightSide.get(j)) < 0) {
            	tempList.set(k, leftSide.get(i));
            	i++;
            }
            else {
            	tempList.set(k, rightSide.get(j));
            	j++;
            }
            k++;
        }  
        
        //Copy the remaining elements of the left hand side list if any
        //to the temporary list
        while(i < list1) {
        	tempList.set(k, leftSide.get(i));
        	i++;
        	k++;
        }
        
        while(j < list2) {
        	tempList.set(k, rightSide.get(j));
        	j++;
        	k++;
        }
	}
	
	
	
	/**
	 * Takes an arrayList of generic class objects and sorts it through quicksort.
	 * 
	 * @param arr: ArrayList of generic objects to be sorted.
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr) {
		/*
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
		}*/
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
