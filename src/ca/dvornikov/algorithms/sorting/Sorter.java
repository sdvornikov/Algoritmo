package ca.dvornikov.algorithms.sorting;

/**
 * Able to sort integer array and gather statistics
 * @author sergey
 *
 */
public interface Sorter {
	/**
	 * Sorts an input array
	 */
	public void sort();
	/**
	 * Sets input an array
	 * @param A array
	 */
	public void setArray(int[] A);
	/**
	 * Returns size of sorting problem
	 * @return N - size of input array
	 */
	public int getN();
	/**
	 * Returns number of comparisons made while sorting
	 * @return number of comparisons
	 */
	public int getComps();
	/**
	 * Returns number of swapped elements in array while sorting
	 * @return number of swapped elements
	 */
	public int getSwaps();
}
