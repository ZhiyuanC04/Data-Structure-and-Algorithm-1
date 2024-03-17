
public class Lec06_ShowingArrays {

	public static void main(String[] args) {
		int[] myArray = new int[11];
		
		for (int i = 0; i< myArray.length; i++) {
			myArray[i] = i;
		}
		 
		//ShowingArrays instanceOfShowingArrays = new ShowingArrays();
		
		printArray(myArray);
		
		int[] arrayTwo = { 34, 51 };
		
		System.out.println(" ");
		printArray(arrayTwo);
		
		arrayTwo = myArray;
		System.out.println(" ");
	//	instanceOfShowingArrays.printArray(arrayTwo);
		printArray(arrayTwo);
		
		arrayTwo[3]=99999;
		
		printArray(arrayTwo);
		printArray(myArray);
	}
	
	public static void printArray (int[] arrayToPrint) {
		for (int p = 0; p < arrayToPrint.length; p++) {
//			System.out.println(arrayToPrint[p]);
		}
	}

}
