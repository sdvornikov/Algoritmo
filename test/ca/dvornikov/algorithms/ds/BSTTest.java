package ca.dvornikov.algorithms.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class BSTTest {

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		final BST<Object> bst = new BST<Object>();
		bst.insert(5, null);
		bst.insert(5, null);
		bst.insert(1, null);
		bst.insert(7, null);
		bst.insert(10, null);
		bst.insert(5, null);
		assertTrue(bst.isValidBST());
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		final BST<Object> bst = new BST<Object>();
		assertEquals("Empty BST must have zero size", 0, bst.size());
		bst.insert(5, null);
		bst.insert(5, null);
		bst.insert(1, null);
		assertEquals("BST size must be 3", 3, bst.size());
		bst.remove(5);
		bst.remove(5);
		bst.remove(1);
		assertEquals("Empty BST must have zero size", 0, bst.size());
	}

}
