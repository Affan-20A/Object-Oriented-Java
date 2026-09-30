public class Main {
    public static void main(String[] args) {

        // Default constructor
        Triangle t1 = new Triangle();

        System.out.println("Triangle 1:");
        t1.display();

        System.out.println("Perimeter: " + t1.perimeter());
        System.out.println("Area: " + t1.area());
        System.out.println("Valid: " + t1.isValid());
        System.out.println("Equilateral: " + t1.isEquilateral());


        // Single side constructor (equilateral)
        Triangle t2 = new Triangle(5);

        System.out.println("\nTriangle 2:");
        System.out.println(t2);
        System.out.println("Perimeter: " + t2.perimeter());
        System.out.println("Area: " + t2.area());
        System.out.println("Equilateral: " + t2.isEquilateral());


        // Three side constructor
        Triangle t3 = new Triangle(3, 4, 5);

        System.out.println("\nTriangle 3:");
        t3.display();
        System.out.println("Right Angled: " + t3.isRightAngled());
        System.out.println("Scalene: " + t3.isScalene());
        System.out.println("Largest Side: " + t3.largestSide());
        System.out.println("Smallest Side: " + t3.smallestSide());

        // Object counter
        System.out.println("\nTotal Triangle objects created: " + Triangle.getObjectCount());
    }
}