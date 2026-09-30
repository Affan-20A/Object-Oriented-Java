import java.util.Objects;

public class Point3D implements Cloneable {
    private double x;
    private double y;
    private double z;

    private static int objectCount = 0;

    public Point3D(double x, double y, double z) {
        set(x, y, z);
        objectCount++;
    }

    public Point3D() {
        this(0.0, 0.0, 0.0);
    }

    public Point3D(Point3D copy) {
        this(copy.x, copy.y, copy.z);
    }

    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
    public double getZ() {
        return this.z;
    }

    public double distanceFromOrigin() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public double distanceFromPoint(Point3D point) {
        double dx = this.x - point.x;
        double dy = this.y - point.y;
        double dz = this.z - point.z;
        return Math.sqrt(dx*dx + dy*dy + dz*dz);
    }

    public Point3D add(double x, double y, double z) {
        return new Point3D(this.x + x, this.y + y, this.z + z);
    }
    
    public Point3D add(Point3D point) {
        return new Point3D(this.x + point.x, this.y + point.y, this.z + point.z);
    }

    public Point3D add(Point3D p1, Point3D p2) {
        return new Point3D(this.x + p1.x + p2.x, this.y + p1.y + p2.y, this.z + p1.z + p2.z);
    }

    // subtract() returns Vector
    public Vector subtract(double x, double y, double z) {
        return new Vector(this.x - x, this.y - y, this.z - z);
    }

    public Vector subtract(Point3D point) {
        return new Vector(this.x - point.x, this.y - point.y, this.z - point.z);
    }

    public Vector subtract(Point3D p1, Point3D p2) {
        return new Vector(this.x - p1.x - p2.x, this.y - p1.y - p2.y, this.z - p1.z - p2.z);
    }

    @Override
    public boolean equals(Object obj) {
        // Checks if both are same objects
        if(this == obj)
            return true;
        // Checks for null and if we are comparing two Point3D objects
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        // Typecasts Object into Point3D
        Point3D other = (Point3D) obj;
        // Compares attributes
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public Point3D clone() {
        try {
            return (Point3D) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "(x, y, z) = (" + this.x + ", " + this.y + ", " + this.z + ")";
    }

    public void display() {
        System.out.println("The value of x is: " + this.x);
        System.out.println("The value of y is: " + this.y);
        System.out.println("The value of z is: " + this.z);
    }
}

