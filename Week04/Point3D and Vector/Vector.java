import java.util.Objects;

public class Vector implements Cloneable {
    private Point3D components;

    private static int objectCount;

    public Vector(Point3D components) {
        this.components = new Point3D(components);
        objectCount++;
    }

    public Vector() {
        this(new Point3D());
    }

    public Vector(double x, double y, double z) {
        this(new Point3D(x, y, z));
    }

    public Vector(Vector copy) {
        this(new Point3D(copy.components));
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public void set(double x, double y, double z) {
        this.components = new Point3D(x, y, z);
    }

    public double getX() {
        return this.components.getX();
    }
    public double getY() {
        return this.components.getY();
    }
    public double getZ() {
        return this.components.getZ();
    }

    public Point3D getComponents() {
        return new Point3D(this.components);
    }

    public Vector add(Vector other) {
        return new Vector(
            this.getX() + other.getX(),
            this.getY() + other.getY(),
            this.getZ() + other.getZ()
        );
    }

    public Vector subtract(Vector other) {
        return new Vector(
            this.getX() - other.getX(),
            this.getY() - other.getY(),
            this.getZ() - other.getZ()
        );
    }

    public Vector multiply(double scalar) {
        return new Vector(
            this.getX() * scalar,
            this.getY() * scalar,
            this.getZ() * scalar
        );
    }

    // |A| = sqrt(a^2 + b^2 + c^2)
    public double getMagnitude() {
        return Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY() + this.getZ() * this.getZ());
    }

    // a = A / |A|
    public Vector getUnitVector() {
        double m = this.getMagnitude();
        if(m == 0) {
            throw new ArithmeticException("Unit Vector does not exist");
        }
        return new Vector(this.getX() / m, this.getY() / m, this.getZ() / m);
    }

    // (a, b, c).(x, y, z) = (ax + by + cz)
    public double dotProduct(Vector other) {
        return this.getX() * other.getX() + this.getY() * other.getY() + this.getZ() * other.getZ();
    }

    // Using Matrix method
    public Vector crossProduct(Vector other) {
        double x = this.getY() * other.getZ() - this.getZ() * other.getY();
        double y = -(this.getX() * other.getZ() - this.getZ() * other.getX());
        double z = this.getX() * other.getY() - this.getY() * other.getX();
        return new Vector(x, y, z);
    }

    // Formula A >> B ... (A.B / |B|)
    public double projectionOn(Vector other) {
        double m = other.getMagnitude();
        if(m == 0) {
            throw new ArithmeticException("Magnitude is Zero");
        }
        return this.dotProduct(other) / m;
    }

    // theta = acos(A.B / |A||B|)
    public double angleBetween(Vector other) {
        double dot = this.dotProduct(other);
        double magnitudes = this.getMagnitude() * other.getMagnitude();
        if(magnitudes == 0) {
            throw new ArithmeticException("Magnitude is Zero");
        }
        return Math.acos(dot / magnitudes);
    }

    // If A x B = 0 --> Parallel
    public boolean isParallel(Vector other) {
        return this.crossProduct(other).getMagnitude() < 1e-9;
    }

    // If A . B = 0 --> Perpendicular
    public boolean isPerpendicular(Vector other) {
        return Math.abs(this.dotProduct(other)) < 1e-9;
    }

    @Override
    public boolean equals(Object obj) {
        // Checks if both are same objects
        if(this == obj)
            return true;
        // Checks for null and if we are comparing two Vector objects
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        // Typecasts Object into Vector
        Vector other = (Vector) obj;
        // Compares attributes
        return Objects.equals(this.components, other.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public Vector clone() {
        try {
            Vector copy = (Vector) super.clone();
            copy.components = this.components.clone();
            return copy;
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "Vector is (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")";
    }

    public void display() {
        System.out.println("Vector is (" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }
}