import java.util.Objects;

public class BinaryNumber implements Cloneable {
    private String binary;
    private static int objectCount;

    public BinaryNumber(String binary) {
        validate(binary);
        this.binary = new String(binary);
        objectCount++;
    }

    public BinaryNumber() {
        this.binary = "0";
        objectCount++;
    }

    public BinaryNumber(BinaryNumber copy) {
        if(copy == null)
            throw new IllegalArgumentException("Cannot copy null");
        this.binary = new String(copy.binary);
        objectCount++;
    }

    private void validate(String binary) {
        if (binary == null || binary.isEmpty())
            throw new IllegalArgumentException("Binary number is not valid.");

        // check if the String contains a character other than 0 and 1
        for(int i=0 ; i< binary.length() ; i++) {
            if(binary.charAt(i) != '0' && binary.charAt(i) != '1')
                throw new IllegalArgumentException("Binary number is not valid.");
        }
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public void set(String binary) {
        validate(binary);
        this.binary = new String(binary);
    }

    public String getBinary() {
        return this.binary;
    }

    public int binaryToDecimal() {
        int decimal = 0;
        int power = this.binary.length() -1;  // power of 2

        // iteration from right to left
        for(int i=0 ; i<this.binary.length() ; i++) {
            int digit = this.binary.charAt(i) - '0';
            decimal += digit * (int) Math.pow(2, power-i);
        }
        return decimal;
    }

    public static String decimalToBinary(int decimal) {
        if(decimal == 0)
            return "0";

        // using LCM and remainder method
        String binary = "";
        while(decimal > 0) {
            int remainder = decimal % 2;
            binary = remainder + binary;
            decimal = decimal / 2;
        }
        return binary;
    }

    public String add(BinaryNumber other) {
        int num1 = this.binaryToDecimal();
        int num2 = other.binaryToDecimal();

        int result = num1 + num2;
        return BinaryNumber.decimalToBinary(result);
    }

    public String subtract(BinaryNumber other) {
        int num1 = this.binaryToDecimal();
        int num2 = other.binaryToDecimal();

        if(num1 < num2)
            throw new ArithmeticException("Result cannot be negative.");

        int result = num1 - num2;
        return BinaryNumber.decimalToBinary(result);
    }

    public String multiply(BinaryNumber other) {
        int num1 = this.binaryToDecimal();
        int num2 = other.binaryToDecimal();

        int result = num1 * num2;
        return BinaryNumber.decimalToBinary(result);
    }

    public String divide(BinaryNumber other) {
        int num1 = this.binaryToDecimal();
        int num2 = other.binaryToDecimal();

        if(num2 == 0)
            throw new ArithmeticException("Cannot divide by zero.");

        int result = num1 / num2;
        return decimalToBinary(result);
    }

    public String binaryToOctal() {
        int decimal = this.binaryToDecimal();

        if(decimal == 0)
            return "0";

        // using LCM and remainder method
        String octal = "";
        while(decimal > 0) {
            int remainder = decimal % 8;
            octal = remainder + octal;
            decimal = decimal / 8;
        }
        return octal;
    }

    public String binaryToHexa() {
        int decimal = this.binaryToDecimal();

        if(decimal == 0)
            return "0";

        // using LCM and remainder method
        String hexa = "";
        while(decimal > 0) {
            int remainder = decimal % 16;

            switch (remainder) {
                case 10:
                    hexa = 'A' + hexa;
                    break;
                case 11:
                    hexa = 'B' + hexa;
                    break;
                case 12:
                    hexa = 'C' + hexa;
                    break;
                case 13:
                    hexa = 'D' + hexa;
                    break;
                case 14:
                    hexa = 'E' + hexa;
                    break;
                case 15:
                    hexa = 'F' + hexa;
                    break;
                default:
                    hexa = remainder + hexa;
                    break;
            }
            
            decimal = decimal / 16;
        }
        return hexa;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        BinaryNumber other = (BinaryNumber) obj;
        return Objects.equals(this.binary, other.binary);
    }

    @Override
    public BinaryNumber clone() {
        try {
            return (BinaryNumber) super.clone();
        }
        catch(CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "Binary Number is " + this.binary;
    }

    public void display() {
        System.out.println("Binary Number is " + this.binary);
        System.out.println("In Decimal Number System it is " + this.binaryToDecimal());
    }
}