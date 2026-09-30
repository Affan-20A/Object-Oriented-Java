public class Main {
    public static void main(String[] args) {

        RationalNumber r1 = new RationalNumber(2, 3);
        RationalNumber r2 = new RationalNumber(4, 5);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println();

        RationalNumber sum = r1.add(r2);
        System.out.println("Addition: " + sum);

        RationalNumber diff = r1.subtract(r2);
        System.out.println("Subtraction: " + diff);

        RationalNumber product = r1.multiply(r2);
        System.out.println("Multiplication: " + product);

        RationalNumber quotient = r1.divide(r2);
        System.out.println("Division: " + quotient);

        System.out.println();

        RationalNumber r3 = new RationalNumber(8, 12);
        System.out.println("Before simplify: " + r3);
        r3.simplify();
        System.out.println("After simplify: " + r3);

        System.out.println();
        r2.reciprocal();
        System.out.println("Reciprocal of r2: " + r2);

        RationalNumber copy = new RationalNumber(r1);
        System.out.println("Copy of r1: " + copy);

        r1.set(10, -20);
        System.out.println("After set: " + r1);

        System.out.println("Numerator: " + r1.getNumerator());
        System.out.println("Denominator: " + r1.getDenominator());

        System.out.println();
        System.out.println("Objects created: " + RationalNumber.getObjectCount());
    }
}
