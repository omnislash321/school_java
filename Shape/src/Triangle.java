/*
 *		Name: Xu, Roberto
 *		Homework: #5
 *		Due: 11/21/12
 *		Course: CS-141-01-f12
 *		Description: The Triangle class that extends Shape. Used in ShapeDemo.java. 
 *				You can make a Triangle Shape with a height, width, and tag.
 *				It can return it's height, width, area, and everything from Shape,
 *				such as point tag and other stuff.
 */

public class Triangle extends Shape{
	
	private double width, height;
	
	public Triangle(double width, double height){
		super(ShapeTag.TRIANGLE);
		setPointTag("top");
		this.width = width;
		this.height = height;
	}
	
	public Triangle(double width, double height, Point top){
		super(ShapeTag.TRIANGLE, top);
		setPointTag("top");
		this.width = width;
		this.height = height;
	}
	
	public Triangle(ShapeTag tag, double width, double height){
		super(tag);
		setPointTag("top");
		this.width = width;
		this.height = height;
	}
	
	public Triangle(ShapeTag tag, double width, double height, Point top){
		super(tag, top);
		setPointTag("top");
		this.width = width;
		this.height = height;
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return height;
	}
	
	public double getArea(){
		return (.5)*(width)*(height);
	}
	
	public String toString(){
		return getTag() + "[" + width + ", " + height + "]:" + getPoint();
	}

}
