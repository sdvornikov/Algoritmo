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
	
	public E pop() {
		if(head == null) {
			throw new ArrayIndexOutOfBoundsException("Stack underflow");
		}
		E value = head.value;
		head = head.next;
		return value;
	}
}
