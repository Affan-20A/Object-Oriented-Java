public class Main {
    public static void main(String[] args) {

        ComplexNumber c1 = new ComplexNumber(2, 3);
        ComplexNumber c2 = new ComplexNumber(1, 4);

        System.out.println("C1: " + c1);
        System.out.println("C2: " + c2);

        System.out.println();
        System.out.println("Addition: " + c1.add(c2));
        System.out.println("Subtraction: " + c1.subtract(c2));
        System.out.println("Multiplication: " + c1.multiply(c2));
        System.out.println("Division: " + c1.divide(c2));

        System.out.println();
        System.out.println("Conjugate of C1: " + c1.conjugate());
        System.out.println("Modulus of C1: " + c1.modulus());
        System.out.println("Additive Inverse of C1: " + c1.additiveInverse());
        System.out.println("Multiplicative Inverse of C1: " + c1.multiplicativeInverse());

        System.out.println();
        System.out.println("Objects Created: " + ComplexNumber.getObjectCount());
    }
}