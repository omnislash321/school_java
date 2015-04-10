
/*
 * CS141 
 * (C) 2012 T.Nguyen
 */

public class Rectangle extends Shape {

    private double width, height;
    
    public Rectangle (double width, double height) {
        super(ShapeTag.RECTANGLE);
        setPointTag("ulc");
        this.width = width;
        this.height = height;
    }

    public Rectangle (double width, double height, Point upperLeftCorner) {
        super(ShapeTag.RECTANGLE, upperLeftCorner);
        setPointTag("ulc");
        this.width = width;
        this.height = height;
    }
    
    public Rectangle (ShapeTag tag, double width, double height) {
        super(tag);
        setPointTag("ulc");
        this.width = width;
        this.height = height;
    }
    
    public Rectangle (ShapeTag tag, double width, double height, Point upperLefCorner) {
        super(tag, upperLefCorner);
        setPointTag("ulc");
        this.width = width;
        this.height = height;
    }
       
    public double getWidth () {
        return width;
    }

    public double getHeight() {
        return height;
    }    
    
    public double getArea () {
        return width * height;
    }
    
    public double getPerimeter () {
        return 2 * (width + height);
    }
    
    public double getDiagonal () {
        return Math.sqrt(width * width + height * height);
    }
    
    public String toString () {
        return getTag() + "[" + width + ", " + height + "]:" + getPoint();
    }
}