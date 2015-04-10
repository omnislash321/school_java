
/*
 * CS141
 * (C) 2012 T.Nguyen
 */

public class Point {
    
    private int x, y;
    private String tag;
    private static int objectCounter = 0;
    
    public Point () {
       this(null, 0, 0);
    }
    
    public Point (int x, int y) {
        this(null, x, y);
    }
    
    public Point (String tag, int x, int y) {
        this.tag = tag;
        this.x = x;
        this.y = y;
        objectCounter++;
    }
    
    public Point (Point obj) {
        this(obj.tag, obj.x, obj.y);
    }
    
    public void setPoint (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setTag (String tag) {
        this.tag = tag;
    }
    
    public void setPoint(String tag, int x, int y) {
        this.tag = tag;
        this.x = x;
        this.y = y;
    }
    
    public int getX () {
        return x;
    }
    
    public int getY () {
        return y;
    }
    
    public String getTag () {
        return tag;
    }
    
    public boolean equals (Point rhs) {
        return x == rhs.x && y == rhs.y;
    }

    public boolean same (Point rhs) {
        return x == rhs.x && y == rhs.y && tag.equals(rhs.tag);
    }
    
    public String toString () {
        return ((tag == null) ? "" : tag) + "(" + x + ", " + y + ")";
    }
    
    public Point copy () {
        return new Point(this);
    }
    
    public void translate (int dx, int dy) {
        x += dx;
        y += dy;
    }
    
    public static int getCounter () {
        return objectCounter;
    }

	public static void main (String[] args) {

        Point p1 = new Point();
        Point p2 = new Point("p2", 10, 20);
        Point p3 = new Point(p2);
        Point p4;
        
        Point[] arrayPoints = new Point[10];
        
        p4 = p3.copy();
             
        for (int i = 0; i < arrayPoints.length; i++)
            arrayPoints[i] = new Point("ap" + i, 1, 1);
        
        p3.setPoint(10, 20);
        p3.setPoint("point3", 1, 2);        
        p1.translate(10, 20);
                
        System.out.println(p1 + " " + p2);
        System.out.println("p1 [" + p1.getX() + ", " + p1.getY() + "]");
        System.out.println(p1.equals(p2));
        System.out.println("count = " + Point.getCounter());
        
        for (Point point : arrayPoints)
            System.out.println(point);  
	}
}

