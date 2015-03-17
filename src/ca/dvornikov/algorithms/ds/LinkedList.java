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
	
	///////// export implementation details ////
	public Entry<E> getHead() {
		return head;
	}
	public void setHead(Entry<E> head) {
		this.head = head;
	}
}
