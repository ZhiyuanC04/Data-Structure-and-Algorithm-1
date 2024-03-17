
public class Lec06_ArrayDemo {
public static void main(String[] args) {
	
	int[] values = { 1,2,3,4,5 };
	
//	String name = "Cynthia";
//	System.out.println(name);

	//zeroOut(values);

	System.out.println( arrayToString(values) );  // prints return from method
	System.out.println("");
	for (int c = 0; c<values.length;c++) {
		System.out.print(values[c]);            // prints what's in c in main
	}

}
public static String arrayToString(int[] valuesIsItACopy) {
	String returnString = "";
	valuesIsItACopy = new int[5];
	for(int i=0;i<valuesIsItACopy.length;i++) {
		valuesIsItACopy[i]=3;
		returnString+=valuesIsItACopy[i]+" ";
		
	}
	return returnString;
}
public static void zeroOut(int[] values) {
	for ( int i = 0; i<values.length; i++) {
		values[i]=0;
	}
}
}
