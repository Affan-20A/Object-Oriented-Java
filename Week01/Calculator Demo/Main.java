public class Main {
    public static void main(String[] args) {

        Calculator calc1 = new Calculator(10, 5);

        // Test addition
        calc1.add(10, 5);
        System.out.println("Addition:");
        calc1.display();

        // Test subtraction
        calc1.subtract(10, 5);
        System.out.println("\nSubtraction:");
        calc1.display();

        // Test multiplication
        calc1.multiply(10, 5);
        System.out.println("\nMultiplication:");
        calc1.display();

        // Test division
        calc1.divide(10, 5);
        System.out.println("\nDivision:");
        calc1.display();

        // Test default constructor
        Calculator calc2 = new Calculator();
        System.out.println("\nDefault Calculator:");
        calc2.display();

        // Test copy constructor
        Calculator calc3 = new Calculator(calc1);
        System.out.println("\nCopied Calculator:");
        calc3.display();

        // Test object counter
        System.out.println("\nTotal Calculator objects: " + Calculator.getObjectCount());
    }
}
