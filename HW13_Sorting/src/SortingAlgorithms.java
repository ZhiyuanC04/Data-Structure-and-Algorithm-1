// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HW13 - Sorting

import java.util.Arrays;
@SuppressWarnings("unchecked")
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
	public static <T extends Comparable<T>> void insertionSort(T[] list) {
		for (int i = 1; i < list.length; i++) {
			T val = list[i];
			int j = i - 1;
			while (j >= 0 && val.compareTo(list[j]) < 0) { // Fix the condition. Change from > to >=
				list[j + 1] = list[j];
				j--;
			}
			list[j + 1] = val;
		}
	}
	public static <T extends Comparable<T>> void insertionSort(T[] list, int start, int end) {
		// Another insertion sort with two more index for hybrid sort
		for (int i = start + 1; i <= end; i++) { // Use the new indexes instead of array.length
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
	// ################
	// ## MERGE SORT ## ----------------------------------------------------------------------
	// ################	
	/**
	 * Fully recursive Merge sort and associated helper method.
	 * The second method below provides the portion of the array
	 * (i.e., index i to j inclusive) that we want to sort.
	 * @param list - An array of items
	 */
	public static<T extends Comparable<T>> void mergeSort(T[] list) {
		mergeSort(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void mergeSort(T[] list, int i, int j) {
		// TODO: write the body of this method
		if (i < j) {
			int mid = (i + j) / 2; // Calculate the mid index
			mergeSort(list, i, mid); // Recursively called and get the merged part of the left part
			mergeSort(list, mid + 1, j); // Vice versa, right part
			merge(list, i, mid, j); // Merge the left and right part
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
	public static<T extends Comparable<T>> void merge(T[] list, int i, int mid, int j) {
		// TODO: write the body of this method
		// Reminder: when using a generic type, to create a new array to hold items of type T,
		// you do something like the following:
		T[] merged = (T[]) new Comparable[j - i + 1]; // space for new merged list to hold (sorted) sublist
		int left_Index = 0;
		int right_Index = 0;
		int position = i;
		T[] left = Arrays.copyOfRange(list, i, mid + 1); // Left part
		T[] right = Arrays.copyOfRange(list, mid + 1, j + 1); // Right part

		while (left_Index < left.length && right_Index < right.length) {
			if (left[left_Index].compareTo(right[right_Index]) <= 0) { // Compare the value
				merged[position - i] = left[left_Index]; // Index 0 of the merged list, put left in if left is smaller
				left_Index++;
			}
			else {
				merged[position - i] = right[right_Index]; // Vice versa
				right_Index++;
			}
			position++; // Go to next index, 1
		}
		while (left_Index < left.length) { // If the while function above not called, meaning right length = 0
			merged[position - i] = left[left_Index]; // Put left array into Merged array
			left_Index++;
			position++;
		}
		while (right_Index < right.length) { // If the while function above not called, meaning left length = 0
			merged[position - i] = right[right_Index]; // Put right array into Merged array
			right_Index++;
			position++;
		}
		System.arraycopy(merged, 0, list, i, merged.length); // Update the list array to the newly merged array
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
	 * @param list - An array of items
	 */
	public static<T extends Comparable<T>> void mergeSortHybrid(T[] list) {
		mergeSortHybrid(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void mergeSortHybrid(T[] list, int i, int j) {
		// TODO: write the body of this method
		// When the size of array to be sorted is < 100, call insertionSort rather than recurse
		if (j - i < 100) { // InsertSort
			insertionSort(list, i, j);
		}
		else { // MergeSort
			int mid = (i + j) / 2;
			mergeSortHybrid(list, i, mid);
			mergeSortHybrid(list, mid + 1, j);
			merge(list, i, mid, j);
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
	 * @param list - An array of items
	 */
	public static<T extends Comparable<T>> void quickSort(T[] list) {
		quickSort(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void quickSort(T[] list, int i, int j) {
		//TODO: write the body of this method
		if (i < j) {
			int pivotIndex = partition(list, i, j); // Get the pivot
			// Recursively get all the pivot and sort the list in the smaller part
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
	public static<T extends Comparable<T>> int partition(T[] list, int i, int j) {
		// TODO: write the body of this method
		// Placing smaller elements to the left and larger elements to the right of the pivot
		T pivot = list[j]; // Put the last element (in the range) as the pivot
		int leftIndex = i - 1;
		for (int k = i; k < j; k++) {
			if (list[k].compareTo(pivot) <= 0) {
				leftIndex++;
				swap(list, leftIndex, k); // Change the position when the value is smaller than pivot
			}
		}
		swap(list, leftIndex + 1, j); // Put the pivot into the right position
		return leftIndex + 1; // Position of the pivot
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
	 * @param list - An array of items
	 */
	public static<T extends Comparable<T>> void quickSortHybrid(T[] list) {
		quickSortHybrid(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void quickSortHybrid(T[] list, int i, int j) {
		// TODO: write the body of this method
		// When the size of array to be sorted is < 100, call insertionSort rather than recurse
		if (j - i < 100) { // InsertionSort
			insertionSort(list, i, j);
		}
		else { // QuickSort
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
	public static<T extends Comparable<T>> int partitionHybrid(T[] list, int i, int j) {
		// TODO: write the body of this method
		// Same method as partition above
		T pivot = list[j]; // Put the last element (in the range) as the pivot
		int leftIndex = i - 1;
		for (int k = i; k < j; k++) {
			if (list[k].compareTo(pivot) <= 0) {
				leftIndex++;
				swap(list, leftIndex, k); // Change the position when the value is smaller than pivot
			}
		}
		swap(list, leftIndex + 1, j); // Put the pivot into the right position
		return leftIndex + 1; // Position of the pivot
	}

}