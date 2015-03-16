package ca.dvornikov.algorithms.ds;

class BaseNode<K, V> {
	K key;
	V value;
	
	public BaseNode() {
	}

	@Override
	public String toString() {
		return "" + key + ": " + value;
	}
}
