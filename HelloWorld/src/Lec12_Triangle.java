
public class Lec12_Triangle  extends Lec12_Shape {
	
	public Lec12_Triangle (double height) {
		super(height);
	}
	
	// Assume the base of this triangle is equal to its height,
	// area of a triangle is (height * height) / 2

	// create the calculateArea method:
	public double calculateArea() {
		return (getHeight()*getHeight() / 2);
	}
		
	// also create a toString() method!
	@Override
	public String toString() {
		return "Triangle with a height of " + getHeight() + " has an area of " + calculateArea();
	}
}
