package assign06;

/**
 * Tester class for ArrayListSorter
 * 
 * @author: Parker Catten @u0580588 & Everett Oglesby
 * @version 02:23:23 CS-2420_SP-2023
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;

import assign06.SinglyLinkedList.Node;

public class SinglyLinkedListTester {

	public SinglyLinkedList createSmallList() {
		SinglyLinkedList smallList = new SinglyLinkedList();
		
		smallList.addNode(1);
		smallList.addNode(2);
		smallList.addNode(3);
		smallList.addNode(4);
		return smallList;
	}
	
	@Test
	public void createNodesTest() {
	
		SinglyLinkedList smallList = new SinglyLinkedList();
		
		smallList.addNode("1");
		smallList.addNode("2");
		smallList.addNode("3");
		smallList.addNode("4");
		
		ArrayList<String> testCase = smallList.nodesToArrayList();
		for(int i = 0; i < testCase.size() -1 ; i++) {
			
			System.out.println(testCase.get(i));
			
			//assertTrue(testCase.get(i).compare testCase.get(i + 1));
		}
	}
	
	@Test
	public void sizeTestSmall() {
		SinglyLinkedList smallList = createSmallList();
		
		assertEquals(4, smallList.size());
		
	}
	
	
	
	
	
	@Test
	public void toArrayTestSmall() {
		SinglyLinkedList smallList = createSmallList();
		
		Object[] testCase = (Object[]) smallList.toArray();
			
		for(int i = 0; i < testCase.length; i++) {
			
			assertEquals(((Node) (testCase[i])).data, smallList.get(i));
		}
	}
}
