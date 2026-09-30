import java.util.Random;
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Random random = new Random();
        Point[] data = new Point[100];

        // Main creates the 100 Point objects; PointArray contains their references. 
        for (int i = 0; i < data.length; i++) {
            int x = random.nextInt(1, 101); // generate an x range from 1 till 100
            int y = random.nextInt(1, 101); // generate an x range from 1 till 100
            data[i] = new Point(x, y);
        }

        PointArray original = new PointArray(data);

        PointArray shallow = original.clone();
        PointArray deep = original.deepCopy();
        
        shallow.getPoint(0).setX(999);
        System.out.println("Shallow shares data: " + (original.getPoint(0).getX() == 999));

        deep.getPoint(1).setY(888);
        System.out.println("Deep is independent: " + (original.getPoint(1).getY() != 888));
   
        Point p = new Point(10, 20); 
        Point q = new Point(10, 20);
        System.out.println("Logical equality: " + p.equals(q));
    }
}
