package assign03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PriorityQueueTester {

	private SimplePriorityQueue emptySimplePriorityQueue;
	private SimplePriorityQueue smallSimplePriorityQueue;
	private ArrayList<String> jumbledLetters = new ArrayList<String>();
	
	@BeforeEach
	void setUp() throws Exception {
		
		emptySimplePriorityQueue = new SimplePriorityQueue();
		
		smallSimplePriorityQueue = new SimplePriorityQueue();
		smallSimplePriorityQueue.data = new String[] {"A", "B", "C", "F", "H"};
		
		String[] jumbledArray = new String[] {"O", "M", "J", "G", "K", "D", "I", "L", "N", "P"};
		for(int i = 0; i < jumbledArray.length; i++) {
			jumbledLetters.add(jumbledArray[i]);
		}
	}
	
	
	@Test
	public void testsmallListInsert() {
		
		smallSimplePriorityQueue.insert("I");
		for(int i = 0; i < smallSimplePriorityQueue.data.length; i++) {
			System.out.print(smallSimplePriorityQueue.data[i] + " ");
		}	
		
		System.out.println("");
		assertEquals( smallSimplePriorityQueue.data[5], "I" );
		
		
		smallSimplePriorityQueue.insert("D");
		for(int i = 0; i < smallSimplePriorityQueue.data.length; i++) {
			System.out.print(smallSimplePriorityQueue.data[i] + " ");
		}	
		
		System.out.println("");
		assertEquals( smallSimplePriorityQueue.data[3], "D" );
		
		
		smallSimplePriorityQueue.insert("C");
		for(int i = 0; i < smallSimplePriorityQueue.data.length; i++) {
			System.out.print(smallSimplePriorityQueue.data[i] + " ");
		}
		
		System.out.println("");
		assertEquals( smallSimplePriorityQueue.data[3], "C" );
		
		
		smallSimplePriorityQueue.insert("G");
		for(int i = 0; i < smallSimplePriorityQueue.data.length; i++) {
			System.out.print(smallSimplePriorityQueue.data[i] + " ");
		}	
		System.out.println("");
		assertEquals( smallSimplePriorityQueue.data[6], "G" );
	}
	
	
	
	@Test
	public void testEmptyInsert() {
		
		emptySimplePriorityQueue.insert("A");
		assertEquals( emptySimplePriorityQueue.data[0], "A" );
		
		emptySimplePriorityQueue.insert("B");
		assertEquals( emptySimplePriorityQueue.data[1], "B" );
	}
	
	
	
	@Test
	public void testInsertAll() {
		
		smallSimplePriorityQueue.insertAll(jumbledLetters);
		for(int i = 0; i < smallSimplePriorityQueue.data.length; i++) {
			System.out.print(smallSimplePriorityQueue.data[i] + " ");
		}	
		System.out.println("");
		
		assertEquals( smallSimplePriorityQueue.data[0], "A" );
		assertEquals( smallSimplePriorityQueue.data[1], "B" );
		assertEquals( smallSimplePriorityQueue.data[2], "C" );
		assertEquals( smallSimplePriorityQueue.data[3], "D" );
		assertEquals( smallSimplePriorityQueue.data[4], "F" );
		assertEquals( smallSimplePriorityQueue.data[5], "G" );
		assertEquals( smallSimplePriorityQueue.data[6], "H" );
		assertEquals( smallSimplePriorityQueue.data[7], "I" );
		assertEquals( smallSimplePriorityQueue.data[8], "J" );
		assertEquals( smallSimplePriorityQueue.data[9], "K" );
		assertEquals( smallSimplePriorityQueue.data[10], "L" );
		assertEquals( smallSimplePriorityQueue.data[11], "M" );
		assertEquals( smallSimplePriorityQueue.data[12], "N" );
		assertEquals( smallSimplePriorityQueue.data[13], "O" );
		assertEquals( smallSimplePriorityQueue.data[14], "P" );
	}
	
	
	
	@Test
	public void testDeleteMax() {
		
		smallSimplePriorityQueue.deleteMax();
		assertEquals(smallSimplePriorityQueue.data[ smallSimplePriorityQueue.data.length-1 ], "F");
		smallSimplePriorityQueue.deleteMax();
		assertEquals(smallSimplePriorityQueue.data[ smallSimplePriorityQueue.data.length-1 ], "C");
	}
	
	
	
	@Test
	public void testContains() {
		
		assertTrue(smallSimplePriorityQueue.contains("A"));
		assertTrue(smallSimplePriorityQueue.contains("B"));
		assertTrue(smallSimplePriorityQueue.contains("C"));
		assertFalse(smallSimplePriorityQueue.contains("D"));
		assertFalse(smallSimplePriorityQueue.contains("E"));
		assertTrue(smallSimplePriorityQueue.contains("F"));
	}
	
	
	
	
	@Test
	public void testClear() {
		
		smallSimplePriorityQueue.clear();
		assertTrue(smallSimplePriorityQueue.isEmpty());
	}
}