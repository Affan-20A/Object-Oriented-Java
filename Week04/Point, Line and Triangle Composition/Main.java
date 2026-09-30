public class Main {
    public static void main(String[] args) {

        // Create Points
        Point p1 = new Point(0, 0);
        Point p2 = new Point(5, 5);
        Point p3 = new Point(0, 5);
        Point p4 = new Point(5, 0);

        // Create Lines
        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p3, p4);
        Line line3 = new Line(p1, p2);

        // Operational methods
        System.out.println("Length: " + line1.getLength());
        System.out.println("Slope: " + line1.getSlope());
        System.out.println("Midpoint: " + line1.getMidPoint());
        System.out.println("Equation: " + line1.getEquation());

        System.out.println("Is Vertical: " + line1.isVertical());
        System.out.println("Is Horizontal: " + line1.isHorizontal());

        // Parallel
        System.out.println("Parallel: " + line1.isParallel(line2));

        // Perpendicular
        System.out.println("Perpendicular: " + line1.isPerpendicular(line2));

        // Intersection
        System.out.println("Intersection: " + line1.getIntersection(line2));

        // equals()
        System.out.println("line1 equals line2: " + line1.equals(line2));
        System.out.println("line1 equals line3: " + line1.equals(line3));

        System.out.println();

         // Points
        Point p5 = new Point(0, 0);
        Point p6 = new Point(4, 0);
        Point p7 = new Point(2, 3);

        // Lines
        Line a = new Line(p5, p6);
        Line b = new Line(p6, p7);
        Line c = new Line(p7, p5);

        // Triangles
        Triangle t1 = new Triangle(a, b, c);
        Triangle t2 = t1.clone(); // clone()
        Triangle t3 = t2;

        // Operational methods
        System.out.println("Perimeter: " + t1.getPerimeter());
        System.out.println("Area: " + t1.getArea());

        // equals()
        System.out.println("Equals: " + t1.equals(t2));
        System.out.println("Equals: " + t1.equals(t3));

        // toString()
        System.out.println(t1);
    }
}