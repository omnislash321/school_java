
/*
 * CS141 
 * (C) 2012 T.Nguyen
 */

public class Square extends Rectangle {

    public Square (double side) {
        super(ShapeTag.SQUARE, side, side);
    }
    
    public Square (double side, Point upperLefCorner) {
        super(ShapeTag.SQUARE, side, side, upperLefCorner);
    }
   
    public double getSide () {
        return getWidth();
    }
    
    public String toString () {
        return getTag() + "[" + getWidth() + "]";
    }
    
}