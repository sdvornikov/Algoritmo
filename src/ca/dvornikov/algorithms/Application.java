package ca.dvornikov.algorithms;

import ca.dvornikov.algorithms.sorting.RandomizedQuickSorter;
import ca.dvornikov.algorithms.sorting.Sorter;

public class Application {

	public static void main(String[] args) {
		System.out.println(2.00 - 1.10);
		for (int i=500_000; i<= 10_000_000; i=i+500_000) {
			Sorter sorter = new RandomizedQuickSorter(getArray(i));
			sorter.sort();
			System.out.println("n="+sorter.getN()+" comparisions="+sorter.getComps()+" swaps="+sorter.getSwaps());
		}
	}
	
	public static int[] getArray(int n) {
		int[] array = new int[n];
		for(int i=0; i < n; i++) {
			array[i] = i;//(int)(Math.random()*n*2);
		}
		return array;
	}

}
