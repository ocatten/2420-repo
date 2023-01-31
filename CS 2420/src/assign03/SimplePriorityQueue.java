package assign03;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

import assign02.CS2420StudentGeneric;

public class SimplePriorityQueue<E> implements PriorityQueue<E> 
{
	E[] data = (E[]) new Object[0];
	
	/**
	 * Simple Priority Queue constructor
	 */
	public SimplePriorityQueue() {

	}
	
	/**
	 * Simple Priority Queue constructor that will sort
	 * the array via comparator
	 */
	public SimplePriorityQueue(Comparator<? super E> cmp) {
		
	}

	/**
	 * Retrieves, but does not remove, the maximum element in this priority
	 * queue.
	 * 
	 * @return the maximum element
	 * @throws NoSuchElementException if the priority queue is empty
	 */
	public E findMax() throws NoSuchElementException {
		return data[data.length-1];
	}

	/**
	 * Retrieves and removes the maximum element in this priority queue.
	 * 
	 * @return the maximum element
	 * @throws NoSuchElementException if the priority queue is empty
	 */
	public E deleteMax() throws NoSuchElementException {
		
		E max = data[data.length-1];
		
		//Create new array without the max variable
		E[] dataDeleted =  (E[]) new Object[data.length-2];
		for(int i = 0; i < data.length - 1; i++) {
			dataDeleted[i] = data[i];
		}
		
		//Data equals new list of data minus the largest variable
		data = dataDeleted;
		//Return max variable
		return max;
	}

	/**
	 * Inserts the specified elements into this priority queue.
	 * 
	 * @param coll - the collection of elements to insert
	 */
	public void insert(E item) {
		//Find location in array to place item
		int addedIndex = binarySearch(item);
		
		//Create new list thats one larger than the current list to 
		//place the new item in.
		E[] dataAdded =  (E[]) new Object[data.length];
		boolean ifAdded = false;
		
		//If array is empty, create new array with just the item
		if( data.length == 0 )
		{
			//System.out.println("empty array"); // Test statement
			E[] tempData = (E[]) new Object[] {item};
			data = tempData;
		}
	
		for(int i = 0; i < data.length - 1; i++) {
			if(i == addedIndex)
			{
				dataAdded[i] = item;
				//boolean flag to show that the new item has been added
				ifAdded = true;
				continue;
			}
			// If the item has not been added transfer the list over to the new
			//list according to the corresponding index
			else if(!ifAdded) {
				dataAdded[i] = data[i];
				continue;
			}
			// If the item has been added transfer the list over to the new
			//list according to the previous index
			else{
				dataAdded[i] = data[i-1];
			}
		}
		
		//Make the new list equal to the current list
		data = dataAdded;
	}

	@Override
	public void insertAll(Collection<? extends E> coll) {
		
		
	}

	@Override
	public boolean contains(E item) {
		
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/**
	 * Helper method that does a binary search for the data array
	 * 
	 * @param item
	 * @throws NoSuchElementException if the array doesn't have that index
	 */
	public int binarySearch(E item) throws NoSuchElementException {
		
		// Catch case for an empty array
		if( data.length == 0 )
		{
			return 0;
		}
		
		// Variables to keep track of search parameter indexes
		int low = 0;
		int high = data.length - 1;
		int mid = high/2;
		
		// Loop while the search window exists
		while( low != high ) {
			
			// Casts the midpoint object to a comparable and compares it to the param
			int compResult = ( (Comparable<? super E>)data[mid] ).compareTo(item);
			
			// If the midpoint is greater,
			if(compResult > 0) {	
				high = mid;
			} else if (compResult < 0) { // If the midpoint is lower than the param
				low = mid;
			} else if (compResult == 0) { // If there's a match:
				return mid;
			}
		}
		
		// If nothing is found
		System.out.println("Search failed.");
		return 0;
	}
	
}
