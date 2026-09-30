public class Main {
    public static void main(String[] args) {
        // Test constructors and object count
        Point p1 = new Point();
        Point p2 = new Point(3.0, 4.0);
        Point p3 = new Point(p2);

        System.out.println("p1 (Default): " + p1);
        System.out.println("p2 (Parameterized): " + p2);
        System.out.println("p3 (Copy): " + p3);
        System.out.println("Total objects created: " + Point.getObjectCount());

        // Test distances
        System.out.println("Distance of p2 from origin: " + p2.distanceFromOrigin());
        System.out.println("Distance between p1 and p2: " + p1.distanceFromPoint(p2));

        // Test addition and subtraction
        p1.add(5.0, 5.0);
        System.out.println("p1 after adding (5,5): " + p1);

        Point p4 = p2.add(new Point(1.0, 1.0));
        System.out.println("p2 + (1,1) = " + p4);
    }
}