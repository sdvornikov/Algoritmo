package ca.dvornikov.algorithms.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BST<T> implements DynamicSet<T> {
	private Node<T> root;
	private int size;
	
	private class Node<V> {
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

	@Override
	public void insert(int key, T value) {
		if(root == null) {
			root = new Node<T>(key, value, null);
			size = 1;
			return;
		}
		Node<T> head = root;
		while (true) {
			if(key >= head.key && head.right != null)
				head = head.right;
			else if(key < head.key && head.left != null)
				head = head.left;
			else
				break;
		}
		if(key >= head.key)
			head.right = new Node<T>(key, value, head);
		else
			head.left = new Node<T>(key, value, head);
		size++;
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
		throw new UnsupportedOperationException("Deletion not implemented");
		//TODO
		// transplant left if right free
		// transplant right if left is free
		// find max in right sub-tree
		// transplant its right child to it,
		// transplant it to the node
		// fix pointers
	}
}
