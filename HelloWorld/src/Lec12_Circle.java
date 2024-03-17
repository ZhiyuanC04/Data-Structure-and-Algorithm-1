
public class Lec12_Circle extends Lec12_Shape {
	
	public Lec12_Circle(double height) {
		super(height);
	}
	
	// area of a circle is (height /2 ) ^ 2 * pi
	// hint - Java makes pi available as a constant, Math.PI
	// complete this method:
	public double calculateArea() {
		
		// be sure to change the return value
		return Math.pow(getHeight()/2, 2) * Math.PI;
	}
	@Override
	public String toString() {
		/* change this value to return the String
		 * Circle with a height of ___ has an area of ___
		 * but fill in the blanks with the actual values
		 */
		return "Circle with a height of " + getHeight() + " has an area of " + calculateArea();
	}

}
