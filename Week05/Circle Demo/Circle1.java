import java.util.Objects;

// Without Composition
public class Circle1 implements Cloneable {
    private double x;
    private double y;
    private double r;

    private static int objectCount;

    public Circle1(double x, double y, double r) {
        set(x, y, r);
        objectCount++;
    }

    public Circle1() {
        this(0, 0, 1);
    }

    public Circle1(Circle1 copy) {
        this(copy.x, copy.y, copy.r);
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public void set(double x, double y, double r) {
        if(r <= 0)
            throw new IllegalArgumentException("Radius must be greater than zero.");
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public double getRadius() {
        return this.r;
    }

    public double getDiameter() {
        return 2 * this.r;
    }

    public double getCircumference() {
        return 2 * Math.PI * this.r;
    }

    public double getArea() {
        return Math.PI * this.r * this.r;
    }

    public boolean contains(double x, double y) {
        double dx = x - this.x;
        double dy = y - this.y;
        return dx * dx + dy * dy <= this.r * this.r;
    }

    public double distanceFrom(Circle1 other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean intersect(Circle1 other) {
        // d <= r1 + r2
        return this.distanceFrom(other) <= this.r + other.r;
    }

    public String getEquation() {
        double h = this.x;
        double k = this.y;
        double rSquared = this.r * this.r;

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
        Circle1 other = (Circle1) obj;
        return Double.compare(this.x, other.x) == 0 &&
               Double.compare(this.y, other.y) == 0 &&
               Double.compare(this.r, other.r) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, r);
    }

    @Override
    public Circle1 clone() {
        try {
            return (Circle1) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "The Circle has radius = " + this.r + " and center (" + this.x + ", " + this.y + ")";
    }

    public void display() {
        System.out.println("Radius = " + this.r);
        System.out.println("Center: (" + this.x + ", " + this.y + ")");
    }
}
