package ca.dvornikov.algorithms.ds;

public interface DynamicSet <T> {
	T get(int key);
	void insert(int key, T value);
	T remove(int key);
	int size();
}
