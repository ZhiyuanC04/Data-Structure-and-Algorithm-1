
public abstract class Lec12_Shape {

	private double height;
	//public abstract double calculateArea();

	public abstract double calculateArea();

	public Lec12_Shape () {
		height = 0.0;
	}
	public Lec12_Shape (double height){
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height=height;
	}
	@Override
	public String toString() {
		return "This shape has a height of " + this.height + " and an unknown form. Area cannot be calculated.";
	}

}
