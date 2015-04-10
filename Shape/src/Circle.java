
/*
 * CS141
 * (C) 2012 T.Nguyen
 */

public class Circle extends Shape {

    private double radius;
    
    public Circle (double radius) {
        super(ShapeTag.CIRCLE);
        setPointTag("center");
        this.radius = radius;
    }
    
    public Circle (double radius, Point center) {
        super(ShapeTag.CIRCLE, center);
        setPointTag("center");
        this.radius = radius;
    }    
    
    public double getRadius () {
        return radius;
    }
    
    public double getArea () {
        return Math.PI * radius * radius;
    }
    
    public double getPerimeter () {
        return 2 * Math.PI * radius;
    }
    
    public double getCircumference () {
        return 2 * Math.PI * radius;
    }
    
    public double getDiameter () {
        return 2 * radius;
    }
    
    public String toString () {
        return getTag() + "("+ radius + "):" + getPoint();
    }
}