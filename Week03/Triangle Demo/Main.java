public class Main {
    public static void main(String[] args) {

        // Create three points
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(2, 3);

        // Create a triangle
        Triangle t1 = new Triangle(p1, p2, p3);

        System.out.println("Triangle t1");
        System.out.println(t1);
        t1.display();

        System.out.println("\nVertices:");
        System.out.println("A = " + t1.getPointA());
        System.out.println("B = " + t1.getPointB());
        System.out.println("C = " + t1.getPointC());

        System.out.println("\nSides:");
        System.out.println("Side A = " + t1.getSideA());
        System.out.println("Side B = " + t1.getSideB());
        System.out.println("Side C = " + t1.getSideC());

        System.out.println("\nPerimeter:");
        System.out.println(t1.getPerimeter());

        System.out.println("\nArea:");
        System.out.println(t1.getArea());

        System.out.println("\nCentroid:");
        System.out.println(t1.getCentroid());

        System.out.println("\nAngles:");
        System.out.printf("Angle A = %.2f\n", t1.getAngleA());
        System.out.printf("Angle B = %.2f\n", t1.getAngleB());
        System.out.printf("Angle C = %.2f\n", t1.getAngleC());

        // Test copy constructor
        Triangle t2 = new Triangle(t1);

        System.out.println("\nCopied Triangle t2");
        System.out.println(t2);

        // Test object count
        System.out.println("\nTotal Triangle objects: " + Triangle.getObjectCount());

        // Test set()
        Point p4 = new Point(1, 1);
        Point p5 = new Point(6, 1);
        Point p6 = new Point(3, 5);

        t2.set(p4, p5, p6);

        System.out.println("\nTriangle t2 after set()");
        t2.display();
        System.out.println("Area = " + t2.getArea());

        // Test invalid triangle
        try {
            Triangle invalid = new Triangle(
                    new Point(0, 0),
                    new Point(1, 1),
                    new Point(2, 2) // Collinear points
            );
        }
        catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(e.getMessage());
        }

        // Test null vertex
        try {
            Triangle nullTriangle = new Triangle(
                    null,
                    new Point(1, 2),
                    new Point(3, 4)
            );
        }
        catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }
}