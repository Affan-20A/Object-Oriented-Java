import java.util.Objects;

// Without Composition
public class Rectangle1 implements Cloneable {
    private double length;
    private double width;

    private static int objectCount;

    public Rectangle1(double length, double width) {
        set(length, width);
        objectCount++;
    }

    public Rectangle1() {
        this(5, 10);
    }

    public Rectangle1(Rectangle1 copy) {
        this(copy.length, copy.width);
    }

    // Input Validation
    private void isValid(double length, double width) {
        if(length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Dimensions must be greater than zero.");
        }
    }

    public void set(double length, double width) {
        isValid(length, width);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }
    public double getWidth() {
        return this.width;
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public double getPerimeter() {
        return 2 * this.length + 2 * this.width;
    }
    
    public double getArea() {
        return this.length * this.width;
    }

    public double getDiagonal() {
        return Math.sqrt(this.length * this.length + this.width * this.width);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Rectangle1 other = (Rectangle1) obj;
        return this.length == other.length && this.width == other.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }

    @Override
    public Rectangle1 clone() {
        try {
            return (Rectangle1) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "The Rectangle has Length = " + this.length + " and Width = " + this.width;
    }

    public void display() {
        System.out.println("Length = " + this.length);
        System.out.println("Width = " + this.width);
    }
}