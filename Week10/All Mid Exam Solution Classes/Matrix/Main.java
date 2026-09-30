public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] source = {1, 2, 3, 4, 5, 6};
        Matrix original = new Matrix(2, 3, source);

        Matrix shallow = original.clone();
        Matrix deep = original.deepCopy();

        shallow.set(0, 1, 99);
        System.out.println("Original after shallow: " + original);
        deep.set(1, 2, 88);
        System.out.println("Original after deep : " + original);
        
        System.out.println("Deep copy : " + deep);

        int[] data1 = {1,2,3,4,5,6,7,8,9};
        Matrix m1 = new Matrix(3, 3, data1);

        int[] data2 = {9,8,7,6,5,4,3,2,1};
        Matrix m2 = new Matrix(3, 3, data2);

        System.out.println(m1.add(m2));
        System.out.println(m1.subtract(m2));

        System.out.println(m1.transpose());
    }
}
