
public class Lec12_AreaTester {

	public static void main(String[] args) {
		
		double heightToCompare = 9.0;
		Lec12_Shape[] arr = new Lec12_Shape[3];
		arr[0] = new Lec12_Circle(heightToCompare);
		arr[1] = new Lec12_Triangle(heightToCompare);
		arr[2] = new Lec12_Square(heightToCompare);
		//arr[3] = new Shape(heightToCompare);
		
		for (Lec12_Shape s : arr) {
			s.calculateArea();
			System.out.println(s);
		}

		//Shape x = new Shape();
	}
}
