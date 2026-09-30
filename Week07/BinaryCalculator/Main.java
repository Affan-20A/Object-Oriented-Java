public class Main {
    public static void main(String[] args) {
        BinaryNumber b1 = new BinaryNumber("110010101000");  // 3240
        BinaryNumber b2 = new BinaryNumber("1");  // 1

        b1.display();
        b2.display();

        System.out.println();
        System.out.println("After Addition ---");

        BinaryNumber b3 = new BinaryNumber(b1.add(b2));  // 3241
        b3.display();

        System.out.println("In Octal: " + b3.binaryToOctal());  // 6251
        System.out.println("In Hexadecimal: " + b3.binaryToHexa());  // CA9

        BinaryNumber b4 = new BinaryNumber("1011");  // 11
        BinaryNumber b5 = new BinaryNumber("0011");  // 3

        System.out.println("\nOperations on Binary Numbers ---");
        System.out.println("1011 + 0011 = " + b4.add(b5));
        System.out.println("1011 - 0011 = " + b4.subtract(b5));
        System.out.println("1011 * 0011 = " + b4.multiply(b5));
        System.out.println("1011 / 0011 = " + b4.divide(b5));
    }
}