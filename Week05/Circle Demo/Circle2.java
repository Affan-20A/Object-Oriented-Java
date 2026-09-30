import java.util.Objects;

// With Composition (has a Point)
public class Circle2 implements Cloneable {
    private Point center;
    private double radius;

    private static int objectCount;

    public Circle2(Point center, double radius) {
        set(center, radius);
        objectCount++;
    }

    public Circle2(Circle2 copy) {
        this(copy.center, copy.radius);
    }

    public static int getObjectCount() {
        return objectCount;
    }

    // private input validation
    private void validate(Point center, double radius) {
        if (center == null) {
            throw new IllegalArgumentException("Center cannot be null");
        }
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
    }

    public void set(Point center, double radius) {
        validate(center, radius);
        this.center = new Point(center);
        this.radius = radius;
    }

    public Point getCenter() {
        return new Point(this.center);
    }

    public double getRadius() {
        return this.radius;
    }

    public double getDiameter() {
        return 2.0 * this.radius;
    }

    public double getCircumference() {
        return 2.0 * Math.PI * this.radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public boolean contains(Point point) {
        if(point == null) {
            throw new IllegalArgumentException("Point cannot be null!");
        }
        double dist = this.center.distanceFromPoint(point);
        // distance between the center and the point <= radius
        return dist <= this.radius;
    }

    public double distanceFrom(Circle2 other) {
        return this.center.distanceFromPoint(other.center);
    }

    public boolean intersect(Circle2 other) {
        // d <= r1 + r2
        return this.distanceFrom(other) <= this.radius + other.radius;
    }

    public String getEquation() {
        double h = this.center.getX();
        double k = this.center.getY();
        double rSquared = this.radius * this.radius;

        String xPart = h >= 0 ? "(x - " + h + ")" : "(x + " + (-h) + ")";
        String yPart = k >= 0 ? "(y - " + k + ")" : "(y + " + (-k) + ")";

        return xPart + "^2 + " + yPart + "^2 = " + rSquared;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Circle2 other = (Circle2) obj;
        return Objects.equals(this.center, other.center) &&
               Double.compare(this.radius, other.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }

    @Override
    public Circle2 clone() {
        try {
            Circle2 copy = (Circle2) super.clone();
            copy.center = this.center.clone();
            return copy;
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "The center of the circle is " + this.center + " and its radius is " + this.radius;
    }

    public void display() {
        System.out.println("The Circle has the following properties:");
        System.out.println("Center: " + this.center);
        System.out.println("Radius: " + this.radius);
        System.out.println("Diameter: " + this.getDiameter());
        System.out.println("Circumference: " + this.getCircumference());
        System.out.println("Area: " + this.getArea());
    }
}
