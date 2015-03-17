package ca.dvornikov.algorithms;

import ca.dvornikov.algorithms.ds.LinkedList;
import ca.dvornikov.algorithms.ds.LinkedList.Entry;

/**
 * This is a linked list reversal 
 * @author Sergey Dvornikov
 *
 */
public class LLReversal {
	public static void main(String arg[]) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		
		System.out.println("Original " + list);
		list.setHead(reverse(list.getHead()));
		System.out.println("Reversed " + list);
		
	}

	private static Entry<Integer> reverse(Entry<Integer> head) {
		Entry<Integer> curr = head;
		Entry<Integer> prev = null;
		Entry<Integer> next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}
