package assign03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PriorityQueueTester {

	private SimplePriorityQueue simpleEmptyPriorityQueue;
	private SimplePriorityQueue simpleSmallPriorityQueue;
	
	@BeforeEach
	void setUp() throws Exception {
		String[] simpleStringArray = new String[]{"A","B","C"};
		
		simpleEmptyPriorityQueue = new SimplePriorityQueue();
		
		simpleSmallPriorityQueue = new SimplePriorityQueue();
		simpleSmallPriorityQueue.data = simpleStringArray;
		
		
		
	}
	
	@Test
	public void testFindMax() {

	}
	
	@Test
	public void testInsertWithEmptyList() {
		
		simpleEmptyPriorityQueue.insert("D");
		//System.out.println(simplePriorityQueue.data[0]);
		assertEquals("D", simpleEmptyPriorityQueue.data[0]);
	}
	
	@Test
	public void testInsertWithSmallList() {
		
		simpleSmallPriorityQueue.insert("D");
		//System.out.println(simplePriorityQueue.data[0]);
		assertEquals("A", simpleEmptyPriorityQueue.data[0]);
	}
}
