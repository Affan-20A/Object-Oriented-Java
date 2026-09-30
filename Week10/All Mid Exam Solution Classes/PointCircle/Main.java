public class Main {
    private static Circle currentCircle;
    public static void main(String[] args) throws CloneNotSupportedException {
        Point[] source = {
            new Point(1, 2),
            new Point(3, 4),
            new Point(5, 6)
        };

        currentCircle = new Circle("C1", source);

        Circle shallow = currentCircle.clone();
        Circle deep = currentCircle.deepCopy();

        shallow.getPoint(0).setX(99);
        System.out.println("Original after shallow: " + currentCircle);

        deep.getPoint(1).setY(88);
        System.out.println("Original after deep: " + currentCircle);

        System.out.println("Deep Copy: " + deep);
    }
}
