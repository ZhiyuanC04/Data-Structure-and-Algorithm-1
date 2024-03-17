import java.util.*;

public class Lec16_TestStringSort {
	
	public static void main(String[] args) {
		/*
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("elephant");
		myList.add("cat");
		myList.add("newspaper");
		myList.add("book");
		myList.add("water");
		Collections.sort(myList);
		System.out.println("Natural sort:");
		System.out.println(myList);
		
		System.out.println();
		System.out.println("Total sort");
		Collections.sort(myList,new StringSorter());
		System.out.println(myList);

		 */
		String[] arr = {"elephant", "cat", "newspaper", "book", "water"};
		System.out.println("original list: " + Arrays.toString(arr));
		Arrays.sort(arr);  // comparable - alphabetically
		System.out.println("Natural sort:");
		System.out.println(Arrays.toString(arr));

		System.out.println();
		System.out.println("Total sort");
		Arrays.sort(arr,new Lec16_StringSorter());  // comparator by length
		System.out.println(Arrays.toString(arr));

	}

}
