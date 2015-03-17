package ca.dvornikov.algorithms.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testPushPop() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.push(5);
		list.push(10);
		assertEquals(10, list.pop().intValue());
		assertEquals(5, list.pop().intValue());
		try {
			list.pop();
			fail("pop on an ampty list should throw an exception");
		} catch (ArrayIndexOutOfBoundsException e) {}
	}

}
