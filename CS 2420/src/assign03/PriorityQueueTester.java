package assign03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PriorityQueueTester {

	private SimplePriorityQueue simplePriorityQueue;
	
	@BeforeEach
	void setUp() throws Exception {
		simplePriorityQueue = new SimplePriorityQueue();
		
		
		String[] simpleStringArray = new String[]{"A","B","C"};
	}
	
	@Test
	public void testFindMax() {

	}
	
	@Test
	public void testInsert() {
		
		simplePriorityQueue.insert("D");
		System.out.println(simplePriorityQueue.data[0]);
		//assertEquals("D", simplePriorityQueue.data[0]);
	}
}
