import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("Xu, Roberto - CS141 Homework #1");
		System.out.println("");
		
		Circle c;
		if (args.length == 0)
		{
			System.out.println("Radius of the circe = ");
			double r = kb.nextDouble();
			c = new Circle(r);
			
		}
		else
			c = new Circle(Double.parseDouble(args[0]));
		
		System.out.println("Circle = " + c.getRadius());
		System.out.println("Area = " + c.getArea());
		System.out.println("Diameter = " + c.getDiameter());
		System.out.println("Circumference = " + c.getCircumference());
	}
}
