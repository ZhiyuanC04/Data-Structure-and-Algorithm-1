
public class Lec12_Square extends Lec12_Shape {
	public Lec12_Square(double height) {
		super(height);
	}
	// area of a square is height * height
	// ( a square has the same height and width! )
	// complete this method:
	public double calculateArea() {
		
		// be sure to change the return value
		//return height * height;
		return getHeight() * getHeight();
	}
	// also create a toString() method!
	/* change this value to return the String
	 * Square with a height of ___ has an area of ___
	 * but fill in the blanks with the actual values
	 */
	@Override
	public String toString() {
		return "Square with a height of " + getHeight() + " has an area of " + calculateArea();
	}
}
