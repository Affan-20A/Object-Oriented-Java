public class ComplexNumber {
    private double real;
    private double imaginary;

    private static int objectCount;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
        objectCount++;
    }

    public ComplexNumber() {
        this(0.0, 0.0);
    }

    public ComplexNumber(ComplexNumber copy) {
        this(copy.real, copy.imaginary);
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public void set(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    // Formula (a+c) + (b+d)i
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Formula (a-c) + (b-d)i
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    // Formula (ac - bd) + (ad + bc)i
    public ComplexNumber multiply(ComplexNumber other) {
        double r = (this.real * other.real) - (this.imaginary * other.imaginary);
        double i = (this.real * other.imaginary) + (this.imaginary * other.real);
        return new ComplexNumber(r, i);
    }

    // Formula [(ac + bd)/(c*c + d*d)] + [(bc - ad)/(c*c + d*d)]i
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = (other.real * other.real + other.imaginary * other.imaginary); // c*c + d*d
        if(denominator == 0) {
            throw new ArithmeticException("Division Not Possible");
        }
        double r = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double i = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(r, i);
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(this.real, -this.imaginary);
    }

    public double modulus() {
        return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
    }

    // -a, -b
    public ComplexNumber additiveInverse() {
        return new ComplexNumber(-this.real, -this.imaginary);
    }

    // a / (a*a + b*b), -b / (a*a + b*b)
    public ComplexNumber multiplicativeInverse() {
        double denominator = (this.real * this.real + this.imaginary * this.imaginary); // a*a + b*b
        if(denominator == 0) {
            throw new ArithmeticException("Multiplicative Inverse is Not Possible");
        }
        return new ComplexNumber(this.real / denominator, -this.imaginary / denominator);
    }

    public String toString() {
        if(this.imaginary < 0) {
            return "Complex Number is " + this.real + " - " + -this.imaginary + "i";
        }
        else {
            return "Complex Number is " + this.real + " + " + this.imaginary + "i";
        }
    }

    public void display() {
        System.out.println("Real Part = " + this.real);
        System.out.println("Imaginary Part = " + this.imaginary);
        System.out.println(this);
    }
}
