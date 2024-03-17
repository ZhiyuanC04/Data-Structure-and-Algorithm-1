// Name: Chris Li
// Computing ID: hl5ux
// Homework Name: HW13

import java.util.Arrays;

public class SortingAlgorithms {

	/*
	 * Swaps the elements and indices i and j in list
	 * */
	private static <T> void swap(T[] list, int i, int j) {
		if (i < 0 || i >= list.length)
			return;
		if (j < 0 || j >= list.length)
			return;
		T temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	// ####################
	// ## INSERTION SORT ## ----------------------------------------------------------------------
	// ####################
	// ## IMPORTANT: the code we've given you below has a small bug!
	// ##   You will need to look at this code and/or test, and fix the bug.
	// ####################
	/**
	 * Usually a slow sorting algorithm. Insertion sort. 
	 * @param list - An array of items
	 */
	// Insertion Sort: builds the final sorted array one item at a time
	public static <T extends Comparable<T>> void insertionSort(T[] list) {
		for (int i = 1; i < list.length; i++) {
			T val = list[i];
			int j = i - 1;
			while (j >= 0 && val.compareTo(list[j]) < 0) { // Fix the loop condition
				list[j + 1] = list[j];
				j--;
			}
			list[j + 1] = val;
		}
	}

	//=================================================================================


	// ################
	// ## MERGE SORT ## ----------------------------------------------------------------------
	// ################	
	/**
	 * Fully recursive Merge sort and associated helper method.
	 * The second method below provides the portion of the array
	 * (i.e., index i to j inclusive) that we want to sort.
	 * 
	 * @param list - An array of items
	 */
	//merge sort : recursively divides the array into halves and merges them back together
	public static<T extends Comparable<T>> void mergeSort(T[] list) {
		mergeSort(list, 0, list.length - 1);
	}

	// Merge Sort helper method: Recursively divides the array into halves based on the given indices
	public static<T extends Comparable<T>> void mergeSort(T[] list, int i, int j) {
		if (i < j) {
			int mid = (i + j) / 2;
			mergeSort(list, i, mid);
			mergeSort(list, mid + 1, j);
			merge(list, i, mid, j);
		}
	}
	
	/**
	 * Merge method for Merge Sort algorithm.
	 * Your mergeSort algorithm will call this method as appropriate to do the merging.
	 * @param list - An array of items
	 * @param i - lower bound index
	 * @param mid - middle index
	 * @param j - upper bound index 
	 */
	//Merges two sorted subarrays back together during Merge Sort
	public static<T extends Comparable<T>> void merge(T[] list, int i, int mid, int j) {
		//TODO: write the body of this method
		
		//Reminder: when using a generic type, to create a new array to hold items of type T,
		//  you do something like the following:
		@SuppressWarnings("unchecked")
		T[] merged = (T[]) new Comparable[j-i+1]; // space for new merged list to hold (sorted) sublist
		int leftIndex = 0;
		int rightIndex = 0;
		int k = i;

		T[] left = Arrays.copyOfRange(list, i, mid + 1);
		T[] right = Arrays.copyOfRange(list, mid + 1, j + 1);

		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex].compareTo(right[rightIndex]) <= 0) {
				merged[k - i] = left[leftIndex++];
			} else {
				merged[k - i] = right[rightIndex++];
			}
			k++;
		}

		while (leftIndex < left.length) {
			merged[k - i] = left[leftIndex++];
			k++;
		}

		while (rightIndex < right.length) {
			merged[k - i] = right[rightIndex++];
			k++;
		}

		System.arraycopy(merged, 0, list, i, merged.length);

	}

	//=================================================================================

	// #######################
	// ## HYBRID MERGE SORT ## ----------------------------------------------------------------------
	// #######################
	/**
	 * Hybrid recursive Merge sort and associated helper method.
	 * The second method below provides the portion of the array
	 * (i.e., index i to j inclusive) that we want to sort.
	 * For this implementation, when the size of the portion of the array
	 * to be sorted is less than 100 items, call insertionSort method to
	 * sort that chunk of the array.
	 *
	 *
	 * @param list - An array of items
	 */
	// Hybrid Merge Sort: Combines Merge Sort and Insertion
	// Sort to optimize performance for small subarrays
	// Uses Merge Sort for larger subarrays and Insertion
	// Sort for smaller ones (less than 100 items)
	public static<T extends Comparable<T>> void mergeSortHybrid(T[] list) {
		mergeSortHybrid(list, 0, list.length - 1);
	}
	// Hybrid Merge Sort helper method: Recursively divides
	// the array and calls the appropriate sorting method based on the subarray size
	public static<T extends Comparable<T>> void mergeSortHybrid(T[] list, int i, int j) {
		if (j - i < 100) {
			insertionSort(list, i, j);
		} else {
			int mid = (i + j) / 2;
			mergeSortHybrid(list, i, mid);
			mergeSortHybrid(list, mid + 1, j);
			merge(list, i, mid, j);
		}
	}
	// Insertion Sort with custom start and end indices:
	// A simple and slow sorting algorithm that builds
	// the final sorted array one item at a time
	// for sorting a specific portion of an array
	public static <T extends Comparable<T>> void insertionSort(T[] list, int start, int end) {
		for (int i = start + 1; i <= end; i++) {
			T val = list[i];
			int j = i - 1;
			while (j >= start && val.compareTo(list[j]) < 0) {
				list[j + 1] = list[j];
				j--;
			}
			list[j + 1] = val;
		}
	}

	//=================================================================================
	
	// ###############
	// ## QUICKSORT ## ----------------------------------------------------------------------
	// ###############	
	/**
	 * Fully recursive Quicksort and associated helper method.
	 * The second method below provides the portion of the array
	 * (i.e., index i to j inclusive) that we want to sort.
	 * >>> Use any partition scheme that you like. 
	 * 
	 * @param list - An array of items
	 */
	// Quicksort: A fast, in-place sorting algorithm that selects a pivot and partitions the array around the pivot
	public static<T extends Comparable<T>> void quickSort(T[] list) {
		quickSort(list, 0, list.length - 1);
	}
	// Helper method
	public static<T extends Comparable<T>> void quickSort(T[] list, int i, int j) {
		if (i < j) {
			int pivotIndex = partition(list, i, j);
			quickSort(list, i, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, j);
		}
	}
	
	/**
	 * Partition method for Quicksort - Use any valid partition algorithm that you like.
	 * Your quickSort algorithm will call this method as appropriate to do the partitioning.
	 * @param list - An array of items
	 * @param i - lower bound
	 * @param j - upper bound
	 */
	// Partition: Partitions the subarray during Quicksort using a pivot,
	// placing smaller elements to the left and larger elements to the right of the pivot
	public static<T extends Comparable<T>> int partition(T[] list, int i, int j) {
		T pivot = list[j];
		int leftIndex = i - 1;

		for (int k = i; k < j; k++) {
			if (list[k].compareTo(pivot) <= 0) {
				leftIndex++;
				swap(list, leftIndex, k);
			}
		}

		swap(list, leftIndex + 1, j);
		return leftIndex + 1;
	}
	
	//=================================================================================

    // ######################
	// ## HYBRID QUICKSORT ## ----------------------------------------------------------------------
	// ######################
	/**
	 * Hybrid Quicksort and associated helper method.
	 * The second method below provides the portion of the array
	 * (i.e., index i to j inclusive) that we want to sort.
	 * >>> Use any partition scheme that you like.
	 * For this implementation, when the size of the portion of the array
	 * to be sorted is less than 100 items, call insertionSort method to
	 * sort that chunk of the array.
	 *
	 * @param list - An array of items
	 */
	// Hybrid Quicksort: Combines Quicksort and Insertion Sort to optimize performance for small subarrays
	// Uses Quicksort for larger subarrays and Insertion Sort for smaller ones (less than 100 items)
	public static<T extends Comparable<T>> void quickSortHybrid(T[] list) {
		quickSortHybrid(list, 0, list.length - 1);
	}
	// Helper method
	public static<T extends Comparable<T>> void quickSortHybrid(T[] list, int i, int j) {
		if (j - i < 100) {
			insertionSort(list, i, j);
		} else if (i < j) {
			int pivotIndex = partitionHybrid(list, i, j);
			quickSortHybrid(list, i, pivotIndex - 1);
			quickSortHybrid(list, pivotIndex + 1, j);
		}
	}

	/**
	 * Partition method for Quicksort - Use any valid partition algorithm that you like.
	 * Your quickSort algorithm will call this method as appropriate to do the partitioning.
	 * @param list - An array of items
	 * @param i - lower bound
	 * @param j - upper bound
	 */
	// Partition method for Hybrid Quicksort: Partitions the subarray around a pivot, placing smaller elements to the left and larger elements to the right of the pivot
	public static<T extends Comparable<T>> int partitionHybrid(T[] list, int i, int j) {
		T pivot = list[j];
		int leftIndex = i - 1;

		for (int k = i; k < j; k++) {
			if (list[k].compareTo(pivot) <= 0) {
				leftIndex++;
				swap(list, leftIndex, k);
			}
		}

		swap(list, leftIndex + 1, j);
		return leftIndex + 1;
	}



}