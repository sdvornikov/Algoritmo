package ca.dvornikov.algorithms.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class BSTTest {

	@Test
	public void testGet() {
		final int KEY = 20;
		final Object value = new Object();
		final BST<Integer, Object> bst = new BST<Integer, Object>();
		bst.insert(KEY, value);
		final Object bstValue = bst.get(KEY);
		assertEquals("Object returned from BST must be the same as inserted", value, bstValue);
	}

	@Test
	public void testInsert() {
		final BST<Integer, Object> bst = new BST<Integer, Object>();
		bst.insert(5, null);
		bst.insert(5, null);
		bst.insert(1, null);
		bst.insert(7, null);
		bst.insert(10, null);
		bst.insert(5, null);
		assertEquals("BST size must be 6", 6, bst.size());
		assertTrue(bst.isValidBST());
	}

	/**
	 * Tests case when left children is null
	 * 
	 * 		   10
	 * 		  /
	 * 		 2
	 * 		  \
	 * 		   5
	 * 
	 * removing 2
	 */
	@Test
	public void testRemoveCase1() {
		final BST<Integer, Object> bst = new BST<Integer, Object>();
		bst.insert(10, null);
		bst.insert(2, null);
		bst.insert(5, null);
		bst.remove(2);
		assertTrue(bst.isValidBST());
	}
	
	/**
	 * Tests case when right children is null
	 * 
	 * 		   10
	 * 		  / 
	 * 		 2
	 * 		/
	 * 	   1
	 * 
	 * removing 2
	 */
	@Test
	public void testRemoveCase2() {
		final BST<Integer, Object> bst = new BST<Integer, Object>();
		bst.insert(10, null);
		bst.insert(2, null);
		bst.insert(1, null);
		bst.remove(2);
		assertTrue(bst.isValidBST());
	}
	
	/**
	 * Removal with not null children and children are not leafs
	 * 
	 * 	10
	 *     \
	 *       20
	 *    /     \
	 *  15       30
	 *    \     /  \
	 *    17   25  40
	 *          \
	 *           27
	 *           
	 * removing 20
	 */
	@Test
	public void testRemoveCase3() {
		final BST<Integer, Object> bst = new BST<Integer, Object>();
		bst.insert(10, null);
		bst.insert(20, null);
		bst.insert(15, null);
		bst.insert(17, null);
		bst.insert(30, null);
		bst.insert(25, null);
		bst.insert(27, null);
		bst.insert(40, null);
		bst.remove(20);
		assertTrue(bst.isValidBST());
	}
	
	/**
	 * Case when we remove the root with both children. Children are leaf nodes
	 * 
	 * 		5
	 * 	   / \
	 *    2   6
	 *    
	 *  removing 5
	 */
	@Test
	public void testRemoveRoot() {
		final BST<Integer, Object> bst = new BST<Integer, Object>();
		bst.insert(5, null);
		bst.insert(2, null);
		bst.insert(6, null);
		bst.remove(5);
		assertTrue(bst.isValidBST());
	}

	@Test
	public void testSize() {
		final BST<Integer, Object> bst = new BST<Integer, Object>();
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
