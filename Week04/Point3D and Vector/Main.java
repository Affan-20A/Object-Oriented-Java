public class Main {
    public static void main(String[] args) {
        Point3D p1 = new Point3D(4, 5, 9);
        Point3D p2 = new Point3D();
        Point3D p3 = new Point3D(2, 5, 10);

        // Distance
        System.out.println("Distance of p1 from origin: " + p1.distanceFromOrigin());
        System.out.println("Distance b/w p1 and p2: " + p1.distanceFromPoint(p2));
        System.out.println("Distance b/w p1 and p3: " + p1.distanceFromPoint(p3));

        // Subtraction
        System.out.println();
        Vector vec1 = p1.subtract(p3);
        System.out.println("Subtracting p3 from p1: " + vec1);
        Vector vec2 = p3.subtract(0, 0, 0);
        System.out.println("Subtracting (0, 0, 0) from p3: " + vec2);

        // Testing clone() and equals()
        Point3D p4 = new Point3D(1, 2, 3);
        Point3D p5 = p4.clone();

        System.out.println(p4 == p5);       // false
        System.out.println(p4.equals(p5));  // true

        // Define vectors
        Vector v1 = new Vector(1.0, 2.0, 3.0);
        Vector v2 = new Vector(4.0, 5.0, 6.0);
        Vector v3 = new Vector(2.0, 4.0, 6.0); // Parallel to v1
        Vector v4 = new Vector(-2.0, 1.0, 0.0); // Perpendicular to v1

        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);

        // Basic Vector Arithmetic
        System.out.println("Addition (v1 + v2): " + v1.add(v2));
        System.out.println("Subtraction (v1 - v2): " + v1.subtract(v2));
        System.out.println("Scalar Multiplication (v1 * 2.5): " + v1.multiply(2));

        // Magnitude and Unit Vector
        System.out.println("Magnitude of v1: " + v1.getMagnitude());
        System.out.println("Unit Vector of v1: " + v1.getUnitVector());

        // Products and Projections
        System.out.println("Dot Product (v1 . v2): " + v1.dotProduct(v2));
        System.out.println("Cross Product (v1 x v2): " + v1.crossProduct(v2));
        System.out.println("Projection of v1 onto v2: " + v1.projectionOn(v2));

        // Geometric Relationships
        System.out.println("Is v1 parallel to v3? " + v1.isParallel(v3));
        System.out.println("Is v1 perpendicular to v4? " + v1.isPerpendicular(v4));

        // Testing clone() and equals()
        Vector v5 = new Vector(1, 2, 3);
        Vector v6 = v1.clone();

        System.out.println(v5 == v6);       // false
        System.out.println(v5.equals(v6));  // true
    }
}
