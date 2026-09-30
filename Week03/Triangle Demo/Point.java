public class Point {
    private double x;
    private double y;

    private static int objectCount = 0;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        objectCount++;
    }

    public Point() {
        this(0.0, 0.0);
    }

    public Point(Point copy) {
        this(copy.x, copy.y);
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double distanceFromOrigin() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double distanceFromPoint(Point point) {
        double dx = this.x - point.x;
        double dy = this.y - point.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    // Translates the Point
    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }
    
    public Point add(Point point) {
        return new Point(this.x + point.x, this.y + point.y);
    }

    public Point add(Point p1, Point p2) {
        return new Point(this.x + p1.x + p2.x, this.y + p1.y + p2.y);
    }

    // Translates the Point
    public void subtract(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    public Point subtract(Point point) {
        return new Point(this.x - point.x, this.y - point.y);
    }

    public Point subtract(Point p1, Point p2) {
        return new Point(this.x - p1.x - p2.x, this.y - p1.y - p2.y);
    }

    public String toString() {
        return "(x, y) = (" + this.x + ", " + this.y + ")";
    }

    public void display() {
        System.out.println("The value of x is: " + this.x);
        System.out.println("The value of y is: " + this.y);
    }
}

