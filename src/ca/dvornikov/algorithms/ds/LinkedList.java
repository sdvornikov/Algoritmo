package ca.dvornikov.algorithms.ds;

/**
 * A very basic implementation of a liked list
 * This class exposes its internals to allow external algorithms to operate on low level
 * @author Sergey Dvornikov
 *
 * @param <E>
 */
public class LinkedList<E> {
	public static class Entry<E> {
		public Entry<E> next;
		public E value;
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

	/**
	 * returns value of element at index
	 * @param index
	 * @return value in list at specified index
	 * @throws ArrayIndexOutOfBoundsException is list length is less or equal than index
	 */
	public E get(int index) {
		Entry<E> element = getElement(index);
		if(element == null) {
			throw new ArrayIndexOutOfBoundsException("No element at index " + index);
		}
		return element.value;
	}
	
	/**
	 * Inserts value at a specified position in a linked list
	 * 
	 * @param index position in the list
	 * @param value value to insert
	 * @throws ArrayIndexOutOfBoundsException if size of a list is less than index
	 */
	public void put(int index, E value) {
		Entry<E> next;
		if(index == 0) {
			next = head;
			Entry<E> newEntry = new Entry<E>(value);
			newEntry.next = next;
			head = newEntry;
			return;
		}
		Entry<E> element = getElement(index-1);
		if(element == null) {
			throw new ArrayIndexOutOfBoundsException("Cannot insert at " + index);
		}
		next = element.next;
		Entry<E> newEntry = new Entry<E>(value);
		element.next = newEntry;
		newEntry.next = next;
	}
	
	public int size() {
		return countEntries();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("LinkedList: ");
		Entry<E> element = head;
		
		while(element != null) {
			builder.append(element.toString());
			element = element.next;
			if (element != null) {
				builder.append(" -> ");
			}
		}
		return builder.toString();
	}
	
	private Entry<E> getElement(int index) {
		int i=0;
		Entry<E> element = head;
		while(i < index && element != null) {
			element = element.next;
			i++;
		}
		return element;
	}
	
	private int countEntries() {
		Entry<E> entry = head;
		int count = 0;
		while(entry != null) {
			count++;
			entry = entry.next;
		}
		return count;
	}
	
	///////// export implementation details ////
	public Entry<E> getHead() {
		return head;
	}
	public void setHead(Entry<E> head) {
		this.head = head;
	}
}
