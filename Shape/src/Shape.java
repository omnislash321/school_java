
/*
 * CS141
 * (C) 2012 T.Nguyen
 */

public class Shape {
    
    public enum ShapeTag {
        UNKNOWN, CIRCLE, RECTANGLE, SQUARE, TRIANGLE
    }

    private ShapeTag tag;
    private Point point;
    
    public Shape () {
        tag = ShapeTag.UNKNOWN;
        point = new Point();
    }
    
    public Shape (ShapeTag tag) {
        this.tag = tag;
        point = new Point();
    }
    
    public Shape (ShapeTag tag, Point point) {
        this.point = point;
        this.tag = tag;
    }

    public void setPointTag (String tag) {
        point.setTag(tag);
    }
    
    public Point getPoint () {
        return point;
    }

    public ShapeTag getTag () {
        return tag;
    }
}