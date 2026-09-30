public class Main {
    public static void main(String[] args) {

        System.out.println("<----- Without Composition ----->\n");

        Circle1 c1 = new Circle1(0, 0, 5);
        Circle1 c2 = new Circle1(6, 0, 3);

        // toString() and getArea()
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());

        // Operational methods
        System.out.println("Contains (3, 4): " + c1.contains(3, 4));
        System.out.println("Distance between circles: " + c1.distanceFrom(c2));
        System.out.println("Circles intersect: " + c1.intersect(c2));

        // Equation
        System.out.println("Equation: " + c1.getEquation());

        // Copy constructor + equals()
        Circle1 copy1 = new Circle1(c1);
        System.out.println("Copy equals original: " + copy1.equals(c1));

        // clone()
        Circle1 clone1 = c1.clone();
        System.out.println("Clone equals original: " + clone1.equals(c1));

        System.out.println("\n<----- With Composition ----->\n");

        Point p1 = new Point(0, 0);
        Point p2 = new Point(6, 0);

        Circle2 c3 = new Circle2(p1, 5);
        Circle2 c4 = new Circle2(p2, 3);

        // toString() and getArea()
        System.out.println(c3);
        System.out.println("Area: " + c3.getArea());

        // Operational methods
        Point p3 = new Point(3, 4);
        System.out.println("Contains (3, 4): " + c3.contains(p3));
        System.out.println("Distance between circles: " + c3.distanceFrom(c4));
        System.out.println("Circles intersect: " + c3.intersect(c4));

        // Equation
        System.out.println("Equation: " + c3.getEquation());

        // Copy constructor + equals()
        Circle2 copy2 = new Circle2(c3);
        System.out.println("Copy equals original: " + copy2.equals(c3));

        // clone()
        Circle2 clone2 = c3.clone();
        System.out.println("Clone equals original: " + clone2.equals(c3));
    }
}