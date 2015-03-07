package ca.dvornikov.algorithms.sorting;

/**
 * Implementation of a QuickSort algorithm
 * Time complexity:
 * 	average: 	n*log(n)
 * 	worst:		n^2
 * @author sergey
 *
 */
public class QuickSorter extends BaseSorter {
	
	public QuickSorter(int[] A) {
		super(A);
	}
	
	@Override
	public void sort() {
		n=A.length;
		comps=0;
		swaps=0;
		qSort(0, A.length);
	}
	/**
	 * Recursive quick sort.
	 * 
	 * @param p start of sub-array in the input array
	 * @param q end of sub-array in the input array (q-1 is the last element in sub-array)
	 */
	protected void qSort(int p, int q) {
		if (p==q) {
			return;
		}
		final int k = partition(p, q);
		qSort(p, k);
		qSort(k+1, q);
	}
	
	protected int partition(int p, int q) {
		if(q<=p) {
			throw new RuntimeException("To partition q must be > p: p="+p+" q="+q);
		}
		int j=p;
		for(int i=p; i<q-1; i++) {
			comps++;
			if(A[i] <= A[q-1]) {
				if(i > j) {
					swap(i, j);
				}
				j++;
			}
		}
		swap(j, q-1);
		return j;
	}
}
