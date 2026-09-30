import java.util.Objects;

public class Line implements Cloneable {
    private Point start;
    private Point end;

    private static int objectCount;

    public Line(Point start, Point end) {
        // set() will call the set() method so that it validates and than initialize the objects
        // reduces code redundancy
        set(start, end);
        objectCount++;
    }

    public Line() {
        // Using new keyword to protect Encapsulation
        this.start = new Point(0, 0);
        this.end = new Point(5, 0);
        objectCount++;
    }

    // Deep Copy
    public Line(Line copy) {
        this(new Point(copy.start), new Point(copy.end));
    }

    public static int getObjectCount() {
        return objectCount;
    }

    private void validate(Point start, Point end) {
        if(start == null || end == null) {
            throw new IllegalArgumentException("Start and End points can not be null");
        }
        if(start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException("Start and End points can not be same");
        }
    }
    
    public void set(Point start, Point end) {
        validate(start, end);
        this.start = new Point(start);
        this.end = new Point(end);
    }

    public Point getStartPoint() {
        return new Point(this.start);
    }
    public Point getEndPoint() {
        return new Point(this.end);
    }

    public double getLength() {
        return this.start.distanceFromPoint(this.end);
    }

    public double getSlope() {
        double dx = this.end.getX() - this.start.getX();
        double dy = this.end.getY() - this.start.getY();
        if(dx == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return dy / dx;
    }

    public Point getMidPoint() {
        double midX = (this.start.getX() + this.end.getX()) / 2.0;
        double midY = (this.start.getY() + this.end.getY()) / 2.0;
        return new Point(midX, midY);
    }

    public boolean isVertical() {
        return Double.isInfinite(this.getSlope());
    }

    public boolean isHorizontal() {
        return Math.abs(this.getSlope()) < 1e-9;
    }

    // We compare the equations to get x, then we find y by putting x in any equation.
    // y = m1x + c1 and y = m2x + c2
    // Comparing:
    // m1x + c1 = m2x + c2
    // m1x - m2x = c2 - c1
    // x = (c2 - c1) / (m1 - m2)
    public Point getIntersection(Line other) {

        // x = ... and y = m2x + c2
        if(this.isVertical()) {
            double m2 = other.getSlope();
            double c2 = other.start.getY() - (m2 * other.start.getX());
            double x = this.start.getX();
            double y = (m2 * x) + c2;
            return new Point(x, y);
        }

        // y = m1x + c1 and x = ...
        if(other.isVertical()) {
            double m1 = this.getSlope();
            double c1 = this.start.getY() - (m1 * this.start.getX());
            double x = other.start.getX();
            double y = (m1 * x) + c1;
            return new Point(x, y);
        }

        // If two lines are parrallel they do not intersect or they overlap.
        if(this.isParallel(other)) {
            throw new IllegalArgumentException("Lines are Parallel");
        }

        double m1 = this.getSlope();
        double c1 = this.start.getY() - (m1 * this.start.getX());
        double m2 = other.getSlope();
        double c2 = other.start.getY() - (m2 * other.start.getX());

        double x = (c2 - c1) / (m1 - m2);
        double y = (m1 * x) + c1;
        return new Point(x, y);
    }

    public String getEquation() {
        if(this.isVertical()) {
            return "x = " + this.start.getX();
        }
        if(this.isHorizontal()) {
            return "y = " + this.start.getY();
        }
        //If the equation has Y-Intercept (c)
        double m = this.getSlope();
        double c = this.start.getY() - (m * this.start.getX());
        if(c == 0) {
            return "y = " + m + "x";
        }
        if(c > 0) {
            return "y = " + m + "x + " + c;
        }
        else {
            return "y = " + m + "x - " + Math.abs(c);
        }
    }

    public boolean isParallel(Line other) {
        if(this.isVertical() && other.isVertical()) {
            return true;
        }
        if(this.isVertical() || other.isVertical()) {
            return false;
        }
        return Math.abs(this.getSlope() - other.getSlope()) < 1e-9;
    }

    public boolean isPerpendicular(Line other) {
        if(this.isVertical() && other.isHorizontal()) {
            return true;
        }
        if(this.isHorizontal() && other.isVertical()) {
            return true;
        }
        if(this.isVertical() || other.isVertical()) {
            return false;
        }
        return Math.abs(this.getSlope() * other.getSlope() + 1) < 1e-9;
    }

    @Override
    public boolean equals(Object obj) {
        // Checks if both are same objects
        if(this == obj)
            return true;
        // Checks for null and if we are comparing two Line objects
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        // Typecasts Object into Line
        Line other = (Line) obj;
        // Compares attributes
        return Objects.equals(this.start, other.start) && Objects.equals(this.end, other.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public Line clone() {
        try {
            Line copy = (Line) super.clone();
            copy.start = this.start.clone();
            copy.end = this.end.clone();
            return copy;
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "The Line has Starting Point " + this.start + " and Ending Point " + this.end;
    }

    public void display() {
        System.out.println("Starting Point: " + this.start);
        System.out.println("Ending Point: " + this.end);
        System.out.println("The Line has Length: " + this.getLength());
        System.out.println("The Line has Slope: " + this.getSlope());
        System.out.println("Mid Point of Line: " + this.getMidPoint());
        System.out.println("Equation of Line: " + this.getEquation());
    }
}