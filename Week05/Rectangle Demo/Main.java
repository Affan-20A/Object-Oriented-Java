public class Main {
    public static void main(String[] args) {

        Rectangle1 r1 = new Rectangle1(5, 10);

        Point a = new Point(0, 0);
        Point b = new Point(10, 0);
        Point c = new Point(10, 5);
        Point d = new Point(0, 5);

        Rectangle2 r2 = new Rectangle2(a, b, c, d);

        // Basic Info
        System.out.println(r1);
        System.out.println(r2);

        System.out.println("\nArea of R1: " + r1.getArea());
        System.out.println("Area of R2: " + r2.getArea());

        System.out.println("\nDiagonal of R1: " + r1.getDiagonal());
        System.out.println("Diagonal of R2: " + r2.getDiagonal());

        System.out.println("\nCenter of R2: " + r2.getCenter());
        
        // equals()
        Rectangle1 copy1 = new Rectangle1(r1);
        System.out.println("\nCopy equals original (R1): " + copy1.equals(r1));
        Rectangle2 copy2 = new Rectangle2(r2);
        System.out.println("Copy equals original (R2): " + copy2.equals(r2));


        // Clone
        Rectangle1 clone1 = r1.clone();
        System.out.println("\nClone equals original (R1): " + clone1.equals(r1));
        Rectangle2 clone2 = r2.clone();
        System.out.println("Clone equals original (R2): " + clone2.equals(r2));
    }
}