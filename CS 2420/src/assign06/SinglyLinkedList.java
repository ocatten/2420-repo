package assign06;

import java.util.ArrayList;
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
	
	//Creates a node for the linked list
	class Node<E>{
		E data;
		Node next;
		
		public Node(E data) {
			this.data = data;
			this.next = null;

		}
		
		public E getNodeData() {
			return this.data;
		}
	}
	
	//Creates a head and a tail for the node
	public Node head = null;
	public Node tail = null;
	
	
	
	public void addNode(E data) {
		Node newNode = new Node(data);
		
		//Check to see if list is empty
		if(head==null) {
			head = newNode;
			tail = newNode;
		}
		
		else {
			//If the list is not empty the tail of the next will be
			//equal to the new node
			tail.next = newNode;
			tail = newNode;
		}
	}

	public ArrayList<String> nodesToArrayList() {
		
		Node temp = head;
		ArrayList<String> nodes = new ArrayList<String>();
		
		if(head != null) {
			
			//System.out.print("Nodes: "); // Added to show what the list was doing.
			while(temp != null) {
				//System.out.print(temp.data.toString() + " "); // Used for test
				nodes.add(temp.toString());
				temp = temp.next;
			}
			//System.out.println();
		}
		else {
			System.out.println("List is empty");
			return null;
		}
		
		return nodes;
	}
	
	
	@Override
	/**
	 * Inserts an element at the beginning of the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @param element - the element to add
	 */
	public void insertFirst(E element) {
		
		Node newNode = new Node(element);
		
		//Check to see if list is empty
		if(head==null) {
			head = newNode;
			tail = newNode;
		}
		
		else {
			//If the list is not empty the head of the next will be
			//equal to the new node
			head.next = head;
			head = newNode;
			
		}
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
	public void insert(int index, Object element) {
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
	public void getFirst(int index, Object element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
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
	public E get(int index) throws NoSuchElementException {
		
		
		int count = 0;
		Node temp = head;
		if(index == 0) {
			return (E)temp.data;
		}
		
		while(temp.next != null) {
			
			temp = temp.next;
			count++;
			
			if (index == count) {
				return (E)temp.data;
			}
			
		}
		
		return (E)temp.data;
		
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
	public E deleteFirst(int index) throws IndexOutOfBoundsException {
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

		int count = 0;
		Node temp = head;
		if(temp != null) {
			count ++;
		}
		while(temp.next != null) {
			count++;
			temp = temp.next;
		}
		
		return count;
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
	/**
	 * Generates an array containing all of the elements in this list in proper sequence 
	 * (from first element to last element).
	 * O(N) for a singly-linked list.
	 * 
	 * @return an array containing all of the elements in this list, in order
	 */
	public Object[] toArray() {
		Node temp = head;
		Object[] nodes = new Object[size()];
		int index = 0;
		nodes[index] = temp;
		while(temp.next != null) {
			index++;
			nodes[index] = temp.next;
			temp = temp.next;
		}
		return nodes;
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
