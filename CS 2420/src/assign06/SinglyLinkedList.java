package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class will represent the stack of URL's the program will navigate through with a singly linked list to make
 * comparisons against a simple ArrayList. It implements the List interface, as it is a list.
 * 
 * @author Parker Catten @u0580588 & Everett Oglesby
 * @version 02:28:23 CS-2420_001 SP-2023
 */


public class SinglyLinkedList<E> implements List<E> {
	
	
	/**
	 * Constructor with no parameters.
	 */
	public SinglyLinkedList () {
		
		
	}
	
	
	
	@Override
	/**
	 * Inserts an element at the beginning of the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @param element - the element to add
	 */
	public void insertFirst(E element) {
		
	}



	@Override
	/**
	 * Inserts an element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @param element - the element to add
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index > size())
	 */
	public void insertFirst(Object element) {
		// TODO Auto-generated method stub
		
	}



	@Override
	/**
	 * Gets the first element in the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	public void insert(int index, Object element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}



	@Override
	/**
	 * Gets the first element in the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	public Object getFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	/**
	 * Gets the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 */
	public Object get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	/**
	 * Deletes and returns the first element from the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	public Object deleteFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	/**
	 * Deletes and returns the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 */
	public Object delete(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	/**
	 * Determines the index of the first occurrence of the specified element in the list, 
	 * or -1 if this list does not contain the element.
	 * O(N) for a singly-linked list.
	 * 
	 * @param element - the element to search for
	 * @return the index of the first occurrence; -1 if the element is not found
	 */
	public int indexOf(Object element) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return the number of elements in this list
	 */
	public int size() {

		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return true if this collection contains no elements; false, otherwise
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	/**
	 * Removes all of the elements from this list.
	 * O(1) for a singly-linked list.
	 */
	public void clear() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	/**
	 * @return an iterator over the elements in this list in proper sequence (from first 
	 * element to last element)
	 */
	public Iterator iterator() {
		
		
		return null;
	}
}
