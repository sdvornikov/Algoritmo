package ca.dvornikov.algorithms.sorting;

/**
 * Randomized version of Quick Sort algorithm
 * @author sergey
 *
 */
public class RandomizedQuickSorter extends QuickSorter {
	
	public RandomizedQuickSorter(int[] A) {
		super(A);
	}
	/**
	 * Picks pivot at random from the array to partition.
	 * Puts it in the end of an array so Quick sort subroutine could partition using it
	 */
	@Override
	protected int partition(int p, int q) { 
		final int pivot = (int)(Math.random()*(q-p))+p;
		swap(q-1, pivot);
		return super.partition(p, q);
	}
}
