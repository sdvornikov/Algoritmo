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
	
	@Test
	public void testGet() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.push(5);
		list.push(10);
		list.push(1);
		
		assertEquals(5, list.get(2).intValue());
		assertEquals(1, list.get(0).intValue());
		try {
			list.get(3);
			fail("get(3) on an a list of 3 elements should throw an exception");
		} catch (ArrayIndexOutOfBoundsException e) {}
	}

}
