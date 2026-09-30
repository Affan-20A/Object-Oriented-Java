public class Main {
    public static void main(String[] args) {
        double[][] mtrx1 = {{1,2,3},{1,2,3},{1,2,3}};
        Matrix m1 = new Matrix(mtrx1);
        System.out.println(m1);
        System.out.println();
        m1.display();

        double[][] mtrx2 = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
        Matrix m2 = new Matrix(mtrx2);
        System.out.println();
        System.out.println("Determinant of m2 " + m2.determinant());

        System.out.println();
        System.out.println("Transpose of m2\n" + m2.transpose());

        Matrix m3 = new Matrix(3, 3);
        System.out.println("\nm3 before set()\n" + m3);
        m3.set(mtrx1);
        System.out.println("\nm3 after set()\n" + m3);

        double[][] mtrx3 = {{1, 2, 0, 1},{0, 1, 2, 0},{2, 0, 1, 1},{1, 1, 0, 2}};
        Matrix m4 = new Matrix(mtrx3);
        Matrix adjoint = m4.adjoint();
        Matrix inverse = m4.inverse();

        System.out.println("m4:\n");
        m4.display();
        System.out.println("\nAdjoint of m4\n");
        adjoint.display();
        System.out.println("\nInverse of m4\n");
        inverse.display();
    }
}