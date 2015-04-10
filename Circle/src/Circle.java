import java.lang.Math;

public class Circle {
	
	private double radius;
	private final double PI = 3.14159;
	
	public Circle() {
		radius = 10;
	}
	
	public Circle(double r) {
		radius = r;
	}
	
	public void setRadius(double r) {
		radius = r;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return (PI * Math.pow(radius, 2));
	}
	
	public double getDiameter() {
		return (radius * 2);
	}
	
	public double getCircumference() {
		return (2 * PI * radius);
	}
}
