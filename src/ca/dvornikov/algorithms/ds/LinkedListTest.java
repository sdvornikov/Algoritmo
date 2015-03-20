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

	@Test
	public void testPut() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.put(0,5);
		list.push(10);
		list.push(1);
		list.put(0, 15);
		list.put(2, 13);
		list.put(5, 99);
		
		assertEquals(15, list.get(0).intValue());
		assertEquals(13, list.get(2).intValue());
		assertEquals(99, list.get(5).intValue());
		try {
			list.put(10, 3);
			fail("put(10, value) on an a list of 4 elements should throw an exception");
		} catch (ArrayIndexOutOfBoundsException e) {}
	}
	
	@Test
	public void testSize() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		assertEquals(0, list.size());
		list.push(5);
		list.put(1,5);
		assertEquals(2, list.size());
		list.pop();
		list.pop();
		assertEquals(0, list.size());
	}
	
}
