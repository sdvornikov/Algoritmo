package ca.dvornikov.algorithms.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Implementation of Binary Search Tree
 * Most of the operation implementations are from CLRS
 * @author Sergey Dvornikov
 *
 * @param <T> type of a satellite data to be stored at a tree node
 */
public class BST<T> implements DynamicSet<T> {
	private Node<T> root;
	private int size;
	
	private static class Node<V> {
		int key;
		V value;
		Node<V> left;
		Node<V> right;
		Node<V> p;
		Node(int key, V value, Node<V> p) {
			this.key = key;
			this.value = value;
			this.p = p;
		}
	}

	@Override
	public T get(int key) {
		Node<T> node = findNode(key);
		if (node == null)
			return null;
		return node.value;
	}

	/**
	 * Non recursive implementation of BST insert
	 */
	@Override
	public void insert(int key, T value) {
		bst_insert(new Node<T>(key, value, null));
	}

	@Override
	public T remove(int key) {
		Node<T> x = findNode(key);
		T deletedValue = x == null ? null : x.value;
		deleteNode(x);
		return deletedValue;
	}

	@Override
	public int size() {
		return size;
	}
	
	boolean isValidBST() {
		try {
			inOrderWalkWithOperation(root, n -> {if (n.p != null && 
													 ((n == n.p.left && n.key >= n.p.key) 
													||(n == n.p.right &&  n.key < n.p.key))) 
													throw new IllegalStateException("BST property violated: current node key=" + n.key
															+ " which is " + (n == n.p.left?"left":"right")
															+ " child of node with key="
															+ n.p.key);});
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	List<Integer> listKeysInOrder() {
		final List<Integer> result = new ArrayList<Integer>();
		inOrderWalkWithOperation(root, n -> result.add(n.key));
		return result;
	}
	
	void bst_insert(Node<T> node) {
		Node<T> y = null;
		Node<T> head = root;
		while (head != null) {
			y = head;
			if(node.key >= head.key)
				head = head.right;
			else if(node.key < head.key)
				head = head.left;
		}
		node.p = y;
		if(y == null)
			this.root = node;
		else if(node.key >= y.key)
			y.right = node;
		else
			y.left = node;
		size++;
	}
	
	private void inOrderWalkWithOperation(Node<T> head, Consumer<Node<T>> operation) {
		if(head == null) {
			return;
		}
		inOrderWalkWithOperation(head.left, operation);
		operation.accept(head);
		inOrderWalkWithOperation(head.right, operation);
	}
	
	private Node<T> findNode(int key) {
		Node<T> head = root;
		if(head == null)
			return null;
		while (key != head.key) {
			if(key > head.key)
				head = head.right;
			else if (key < head.key)
				head = head.left;
		}
		return head;
	}

	private void transplant(Node<T> to, Node<T> from) {
		if (to == root) {
			root = from;
		} else if (to == to.p.left) {
			to.p.left = from;
		} else {
			to.p.right = from;
		}
		if (from != null) {
			from.p = to.p;
		}
	}
	
	private void deleteNode(Node<T> node) {
		if(node.right == null) {
			transplant(node, node.left);
		} else if (node.left == null) {
			transplant(node, node.right);
		} else {
			Node<T> y = findMaxKey(node.right);
			if(y.p != node) {
				transplant(y, y.right);
				y.right = node.right;
				y.right.p = y;
			}
			transplant(node, y);
			y.left = node.left;
			y.left.p = y;	
		}
		if(node != null) {
			size--;
		}
	}

	private Node<T> findMaxKey(Node<T> node) {
		Node<T> result = node;
		while (result.left != null) {
			result = result.left;
		}
		return result;
	}
}
