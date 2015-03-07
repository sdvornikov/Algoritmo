package ca.dvornikov.algorithms.sorting;

/**
 * Base sorter class contains common logic for all implementations of sorting algorithms
 * @author sergey
 *
 */
public abstract class BaseSorter implements Sorter {
	protected int[] A;
	protected int n;
	protected int comps;
	protected int swaps;
	
	public BaseSorter(int[] A) {
		if(A == null) {
			throw new NullPointerException("Cannot initialize without array");
		}
		setArray(A);
	}
	/**
	 * Swaps two elements in an input array
	 * @param i element to swap with j
	 * @param j element to swap with i
	 */
	void swap(int i, int j) {
		swaps++;
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	@Override
	public void setArray(int[] A) {
		this.A = A;
	}
	@Override
	public int getN() {
		return n;
	}
	@Override
	public int getComps() {
		return comps;
	}
	@Override
	public int getSwaps() {
		return swaps;
	}
}
