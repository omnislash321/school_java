/*
 *		Name: Xu, Roberto
 *		Homework: #5
 *		Due: 11/21/12
 *		Course: CS-141-01-f12
 *		Description: The runner program. The only thing added to the original is everything
 *			regarding the triangles. It creates 2 triangles, with different heights and width
 *			and different points. Also has everything from the original found online.
 */

public class ShapeDemo {

	public static void main (String[] args) {
        
        Circle  circle = new Circle(10, new Point(5, 5));
        Rectangle  rectangle = new Rectangle(6, 2);
        Square square = new Square(4);
        
        Triangle triangle = new Triangle(2,4);
        Triangle tri2 = new Triangle(7,5,new Point(2,5));        
        
        System.out.println("Xu, Roberto - CS141 Homework #5\n");
        
        System.out.println("area of " + triangle + " = " + triangle.getArea());
        System.out.println("area of " + tri2 + " = " + tri2.getArea());
        
        triangle.setPointTag("Top Point");
        System.out.println("area of " + triangle + " = " + triangle.getArea());
        
        System.out.println("");
        
        System.out.println("area of " + circle + " = " + circle.getArea());
        System.out.println("perimeter of " + circle + " = " + circle.getPerimeter());

        System.out.println(rectangle);
        System.out.println(square + " area = " + square.getArea());

	}
}