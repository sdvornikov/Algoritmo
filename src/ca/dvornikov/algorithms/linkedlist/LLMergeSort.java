package ca.dvornikov.algorithms.linkedlist;

import ca.dvornikov.algorithms.ds.LinkedList;
import ca.dvornikov.algorithms.ds.LinkedList.Entry;

public class LLMergeSort {
	public static void main(String arg[]) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.push(5);
		list.push(4);
		list.push(60);
		list.push(1);
		list.push(9);
		list.push(5);
		list.push(4);
		list.push(99);
		list.push(1);
		list.push(9);
		
		System.out.println("Original " + list);
		list.setHead(mergeSort(list.getHead(), list.size()));
		System.out.println("Sorted " + list);
		
	}
	/**
	 * Merge sort of a linked list of given length.
	 * If linked list contains more than <b>size</b> elements,
	 * those elements would be discarded from a list
	 * 
	 * @param head First element of a linked list
	 * @param size number of elements to sort
	 * @return sorted linked list containing <b>size</b> elements
	 */
	private static Entry<Integer> mergeSort(Entry<Integer> head, int size) {
		if(size == 1)
			return head;
		int mid = size/2;
		Entry<Integer> midEl = getElement(head, mid-1);
		Entry<Integer> sortedLeft = mergeSort(head, mid);
		Entry<Integer> sortedRight = mergeSort(midEl, size-mid);
		Entry<Integer> sortedList = mergeSortedLists(sortedLeft, sortedRight, mid, size-mid);
		return sortedList;
	}
	
	private static Entry<Integer> mergeSortedLists(Entry<Integer> leftHead, Entry<Integer> rightHead, int leftSize, int rightSize) {
		int rightCnt=0;
		int leftCnt=0;
		// dummy head to avoid special handling for the 1st node
		Entry<Integer> preHead = new Entry<Integer>(null);
		Entry<Integer> current = preHead;
		while(leftCnt < leftSize || rightCnt < rightSize) {
			if(leftCnt >= leftSize) {
				current.next = rightHead;
				rightHead = rightHead.next;
				rightCnt++;
			} else if (rightCnt >= rightSize || leftHead.value.compareTo(rightHead.value) < 0) {
				current.next = leftHead;
				leftHead = leftHead.next;
				leftCnt++;
			} else {
				current.next = rightHead;
				rightHead = rightHead.next;
				rightCnt++;
			}
			current = current.next;
		}
		// cut tail to avoid loops
		current.next = null;
		return preHead.next;
	}
	
	/**
	 * Utility function to get n-th node in a linked list
	 * first element has index 0
	 * @param head
	 * @param index
	 * @return
	 */
	private static Entry<Integer> getElement(Entry<Integer> head, int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Entry<Integer> current = head;
		for(int i = 0; i<= index;i++) {
			current = current.next;
		}
		return current;
	}
}
