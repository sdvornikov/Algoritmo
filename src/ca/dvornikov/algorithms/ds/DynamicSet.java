package ca.dvornikov.algorithms.ds;

public interface DynamicSet <K extends Comparable<K>, T> {
	T get(K key);
	void insert(K key, T value);
	T remove(K key);
	int size();
}
