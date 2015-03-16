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
public class BST<K extends Comparable<K>,T> implements DynamicSet<K, T> {
	private Node<K,T> root;
	private int size;
	
	private static class Node<K extends Comparable<K>, V> extends BaseNode<K, V>{
		Node<K,V> left;
		Node<K,V> right;
		Node<K,V> p;
		Node(K key, V value, Node<K,V> p) {
			this.key = key;
			this.value = value;
			this.p = p;
		}
	}

	@Override
	public T get(K key) {
		Node<K,T> node = findNode(key);
		if (node == null)
			return null;
		return node.value;
	}

	/**
	 * Non recursive implementation of BST insert
	 */
	@Override
	public void insert(K key, T value) {
		bst_insert(new Node<K,T>(key, value, null));
	}

	@Override
	public T remove(K key) {
		Node<K,T> x = findNode(key);
		T deletedValue = x == null ? null : x.value;
		deleteNode(x);
		return deletedValue;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		return "BST [size=" + size + "]";
	}
	
	boolean isValidBST() {
		try {
			inOrderWalkWithOperation(root, n -> {if (n.p != null && 
													 ((n == n.p.left && n.key.compareTo(n.p.key)>=0) 
													||(n == n.p.right &&  n.key.compareTo(n.p.key)<0))) 
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
	
	List<K> listKeysInOrder() {
		final List<K> result = new ArrayList<K>();
		inOrderWalkWithOperation(root, n -> result.add(n.key));
		return result;
	}
	
	void bst_insert(Node<K,T> node) {
		Node<K,T> y = null;
		Node<K,T> head = root;
		while (head != null) {
			y = head;
			if(node.key.compareTo(head.key) >= 0)
				head = head.right;
			else if(node.key.compareTo(head.key) < 0)
				head = head.left;
		}
		node.p = y;
		if(y == null)
			this.root = node;
		else if(node.key.compareTo(y.key) >= 0)
			y.right = node;
		else
			y.left = node;
		size++;
	}
	
	private void inOrderWalkWithOperation(Node<K,T> head, Consumer<Node<K,T>> operation) {
		if(head == null) {
			return;
		}
		inOrderWalkWithOperation(head.left, operation);
		operation.accept(head);
		inOrderWalkWithOperation(head.right, operation);
	}
	
	private Node<K,T> findNode(K key) {
		Node<K,T> head = root;
		if(head == null)
			return null;
		while (key != head.key) {
			if(key.compareTo(head.key) > 0)
				head = head.right;
			else if (key.compareTo(head.key) < 0)
				head = head.left;
		}
		return head;
	}

	private void transplant(Node<K,T> to, Node<K,T> from) {
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
	
	private void deleteNode(Node<K,T> node) {
		if(node.right == null) {
			transplant(node, node.left);
		} else if (node.left == null) {
			transplant(node, node.right);
		} else {
			Node<K,T> y = findMaxKey(node.right);
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

	private Node<K,T> findMaxKey(Node<K,T> node) {
		Node<K,T> result = node;
		while (result.left != null) {
			result = result.left;
		}
		return result;
	}
}
