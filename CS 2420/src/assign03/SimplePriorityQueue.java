package assign03;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SimplePriorityQueue<E> implements PriorityQueue<E> {
	
	E[] data = (E[]) new Object[0];
	
	/**
	 * Simple Priority Queue constructor
	 */
	public SimplePriorityQueue() { }
	
	/**
	 * Simple Priority Queue constructor that will sort
	 * the array via comparator
	 */
	public SimplePriorityQueue(Comparator<? super E> cmp) { }

	
	
	/**
	 * Retrieves, but does not remove, the maximum element in this priority
	 * queue.
	 * 
	 * @return the maximum element
	 * @throws NoSuchElementException if the priority queue is empty
	 */
	public E findMax() throws NoSuchElementException {
		
		// Catch case for an empty list
		if(data.length == 0) {	
			throw new NoSuchElementException();
		}
		
		return data[data.length-1];
	}

	
	
	/**
	 * Retrieves and removes the maximum element in this priority queue.
	 * 
	 * @return the maximum element
	 * @throws NoSuchElementException if the priority queue is empty
	 */
	public E deleteMax() throws NoSuchElementException {
		
		// Catch case for an empty list
		if(data.length == 0) {	
			throw new NoSuchElementException();
		}
		
		
		E max = data[data.length-1];
		
		//Create new array without the max variable
		E[] dataDeleted =  (E[]) new Object[data.length-1];
		for(int i = 0; i < data.length - 1; i++) {
			dataDeleted[i] = data[i];
		}
		
		//Data equals new list of data minus the largest variable
		data = dataDeleted;
		//Return max variable
		return max;
	}

	
	
	/**
	 * Inserts the specified element into this priority queue.
	 * 
	 * @param item - the element to insert
	 */
	public void insert(E item) {
		
		// Create new list thats one larger than the current list to 
		// place the new item in.
		E[] newDataArray =  (E[]) new Object[data.length + 1];
		
		
		// Find location in array to place item
		int addedIndex = binarySearch(item);
		//System.out.println("addedIndex: " + addedIndex); // Shows what it's adding specifically
		
		// Creates a flag that notifies the algorithm if the new element has been added for tracking.
		boolean ifAdded = false;
	
		for(int i = 0; i < data.length + 1; i++) {
			
			if(i == addedIndex) {
				
				newDataArray[i] = item;
				//boolean flag to show that the new item has been added
				ifAdded = true;
				continue;
			}
		
			// If the item has not been added transfer the list over to the new
			//  list according to the corresponding index
			else if(!ifAdded) {
				newDataArray[i] = data[i];
				continue;
			}
			// If the item has been added transfer the list over to the new
			//list according to the previous index
			else {
				newDataArray[i] = data[i-1];
			}
		}
		
		// Make the new list equal to the current list
		data = newDataArray;
	}
	
	
	
	/**
	 * Helper method that does a binary search for the data array
	 * 
	 * @param item
	 * @throws NoSuchElementException if the array doesn't have that index
	 */
	public int binarySearch(E item) throws NoSuchElementException {
		
		// Sets up fields for the binary search
		int high = data.length;
		int low = 0;
		int mid = ((high - low) / 2) + low;
		
		while(low < high) {
			
			// Calculate the middle of the new set of data and compare the middle of the data set with the param
			//System.out.println("mid calculated: " + mid); // Test case for out of bounds error / infinite loop case
			int midToParam = ((Comparable<? super E>)data[mid]).compareTo(item);
			//System.out.println("midToParam result: " + midToParam); // Typewriting the code
			
			// If the midpoint is below the parameter:
			if (midToParam < 0) {
				low = mid + 1; // Add one to the low since it starts at 0
			}
			
			// If the midpoint is greater than the parameter:
			if (midToParam > 0) {	
				high = mid;
			}
			
			// If the low midToParam is equal, return the low's index plus one
			if (midToParam == 0) {
				return mid + 1;
			}
			
			mid = ((high - low) / 2) + low; // Recalculate the midpoint.
		}
		
		//System.out.println("while loop exited");
		// Return 0 if the high is never above the low (if the list is 0)
		return mid;
	}
	

	
	/**
	 * Inserts the specified elements into this priority queue.
	 * 
	 * @param coll - the collection of elements to insert
	 */
	public void insertAll(Collection<? extends E> coll) {
		
		// Loops through each item in the collection and adds it to the existing data.
		for (E item : coll) {
			this.insert(item);
		}
	}
	
	

	/**
	 * Indicates whether this priority queue contains the specified element.
	 * 
	 * @param item - the element to be checked for containment in this priority queue
	 */
	public boolean contains(E item) {
		//Loop through each item in the data array and if the item equals 
		//the item given return true
		for(E dataItem: data) {
			
			if(dataItem.equals(item)) {
				
				return true;
			}
		}
		
		//Else return false if no matching item is found
		return false;
	}

	/**
	 * @return the number of elements in this priority queue
	 */
	public int size() {
		// return the length of the data array
		return data.length;
	}

	/**
	 * @return true if this priority queue contains no elements, false otherwise
	 */
	public boolean isEmpty() {
		
		//If the data list has no items return true, else return false
		if(data.length <= 0)
		{
			clear();
			return true;
		}
		return false;
	}

	/**
	 * Removes all of the elements from this priority queue. The queue will be
	 * empty when this call returns.
	 */
	public void clear() {
		//Create new empty list of generic type and set the data list 
		//equal to this new list
		E[] dataCleared = (E[]) new Object[0];
		data = dataCleared;		
	}
	
}
