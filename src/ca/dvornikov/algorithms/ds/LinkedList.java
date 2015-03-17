package ca.dvornikov.algorithms.ds;

public class LinkedList<E> {
	private static class Entry<E> {
		Entry<E> next;
		E value;
		@Override
		public String toString() {
			return ""+value;
		}
		public Entry(E value) {
			this.value = value;
		}
	}
	
	Entry<E> head;
	
	/**
	 * adds to the beginning of the list
	 * @param value
	 */
	public void push(E value) {
		Entry<E> entry = new Entry<E>(value);
		entry.next = head;
		head = entry;
	}
	
	/**
	 * removes head element from the list.
	 * @return removed element's value
	 * @throws ArrayIndexOutOfBoundsException is list is empty
	 */
	public E pop() {
		if(head == null) {
			throw new ArrayIndexOutOfBoundsException("Stack underflow");
		}
		E value = head.value;
		head = head.next;
		return value;
	}
	
	public E get(int index) {
		int i=0;
		Entry<E> element = head;
		while(i < index) {
			element = element.next;
			if(element == null) {
				throw new ArrayIndexOutOfBoundsException("No element at index " + index);
			}
			i++;
		}
		return element.value;
	}
}
