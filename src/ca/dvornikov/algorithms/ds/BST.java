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
	}

	@Override
	public T get(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(int key, T value) {
		//Node
		
	}

	@Override
	public T remove(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}
	
	boolean isValidBST() {
		try {
			inOrderWalkWithOperation(root, n -> {if (n.key<n.left.key || n.key>n.right.key) 
													throw new IllegalStateException("BST property violated: current node key=" + n.key
															+ " left node=" + n.left.key
															+ " right node=" + n.right.key);});
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

}
