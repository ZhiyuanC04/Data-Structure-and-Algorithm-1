import java.util.*;

public class Lec16_StringSorter implements Comparator<String>{
	public int compare(String s1, String s2) {
	/*	Integer a = s1.length();
		Integer b = s2.length();
		int retval = a.compareTo(b);
		return retval;*/
		return s1.length() - s2.length();
	}

}
