// With Composition (Has a Point)

import java.util.Objects;

public class Rectangle2 implements Cloneable {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    private static int objectCount;

    // Calling set() in Constructor
    public Rectangle2(Point pointA, Point pointB, Point pointC, Point pointD) {
        set(pointA, pointB, pointC, pointD);
        objectCount++;
    }

    public Rectangle2(Rectangle2 copy) {
        this(new Point(copy.pointA), new Point(copy.pointB), new Point(copy.pointC), new Point(copy.pointD));
    }

    public static int getObjectCount() {
        return objectCount;
    }

    // Input Validation
    private boolean isRectangle(Point a, Point b, Point c, Point d) {
        // Midpoint of diagonal AC
        double midACx = (a.getX() + c.getX()) / 2.0;
        double midACy = (a.getY() + c.getY()) / 2.0;
        // Midpoint of diagonal BD
        double midBDx = (b.getX() + d.getX()) / 2.0;
        double midBDy = (b.getY() + d.getY()) / 2.0;
        // Check if diagonals are equal and have the same midpoint
        return Math.abs(a.distanceFromPoint(c) - b.distanceFromPoint(d)) < 1e-9 && midACx == midBDx && midACy == midBDy;
    }

    public void set(Point pointA, Point pointB, Point pointC, Point pointD) {
        if(pointA == null || pointB == null || pointC == null || pointD == null) {
            throw new IllegalArgumentException("Vertices can not be null");
        }
        if (!isRectangle(pointA, pointB, pointC, pointD)) {
            throw new IllegalArgumentException("Points do not form a rectangle");
        }
        this.pointA = new Point(pointA);
        this.pointB = new Point(pointB);
        this.pointC = new Point(pointC);
        this.pointD = new Point(pointD);
    }

    public Point getPointA() {
        return new Point(this.pointA);
    }
    public Point getPointB() {
        return new Point(this.pointB);
    }
    public Point getPointC() {
        return new Point(this.pointC);
    }
    public Point getPointD() {
        return new Point(this.pointD);
    }

    public double getSideAB() {
        return this.pointA.distanceFromPoint(this.pointB);
    }
    public double getSideBC() {
        return this.pointB.distanceFromPoint(this.pointC);
    }
    public double getSideCD() {
        return this.pointC.distanceFromPoint(this.pointD);
    }
    public double getSideDA() {
        return this.pointD.distanceFromPoint(this.pointA);
    }

    public double getPerimeter() {
        return getSideAB() + getSideBC() + getSideCD() + getSideDA();
    }

    public double getLength() {
        return Math.max(getSideAB(), getSideBC());
    }

    public double getWidth() {
        return Math.min(getSideAB(), getSideBC());
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getDiagonal() {
        return Math.sqrt(getSideAB() * getSideAB() + getSideBC() * getSideBC());
    }

    public Point getCenter() {
        double x = (pointA.getX() + pointC.getX()) / 2.0;
        double y = (pointA.getY() + pointC.getY()) / 2.0;
        return new Point(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Rectangle2 other = (Rectangle2) obj;
        return Objects.equals(this.pointA, other.pointA) &&
               Objects.equals(this.pointB, other.pointB) &&
               Objects.equals(this.pointC, other.pointC) &&
               Objects.equals(this.pointD, other.pointD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointB, pointC, pointD);
    }

    @Override
    public Rectangle2 clone() {
        try {
            Rectangle2 other = (Rectangle2) super.clone();
            other.pointA = this.pointA.clone();
            other.pointB = this.pointB.clone();
            other.pointC = this.pointC.clone();
            other.pointD = this.pointD.clone();
            return other;
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "The vertices are " + this.pointA + " " + this.pointB + " " + this.pointC + " " + this.pointD;
    }
    
    public void display() {
        System.out.println("Point A is " + this.pointA);
        System.out.println("Point B is " + this.pointB);
        System.out.println("Point C is " + this.pointC);
        System.out.println("Point D is " + this.pointD);
    }
}