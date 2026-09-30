public class RationalNumber {
    private int numerator;
    private int denominator;

    private static int objectCount = 0;

    public RationalNumber(int numerator, int denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        if(denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
        objectCount++;
    }

    public RationalNumber(RationalNumber copy) {
        this(copy.numerator, copy.denominator);
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public void set(int numerator, int denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        if(denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void simplify() {
        int a = Math.abs(this.numerator);
        int b = Math.abs(this.denominator);
        int gcd = 1;
        if(a == 0) {
            this.denominator = 1;
            return;
        }
        for (int i = Math.min(a, b) ; i>=1 ; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
    this.numerator /= gcd;
    this.denominator /= gcd;
    }

    public RationalNumber add(RationalNumber other) {
        int num = this.numerator * other.denominator + this.denominator * other.numerator;  // ad + bc
        int den = this.denominator * other.denominator;  // bd
        return new RationalNumber(num, den);
    }

    public RationalNumber subtract(RationalNumber other) {
        int num = this.numerator * other.denominator - this.denominator * other.numerator;  // ad - bc
        int den = this.denominator * other.denominator;  // bd
        return new RationalNumber(num, den);
    }

    public RationalNumber multiply(RationalNumber other) {
        int num = this.numerator * other.numerator;  // ac
        int den = this.denominator * other.denominator;  // bd
        return new RationalNumber(num, den);
    }

    public RationalNumber divide(RationalNumber other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        int num = this.numerator * other.denominator;  // ad
        int den = this.denominator * other.numerator;  // bc
        return new RationalNumber(num, den);
    }

    public void reciprocal() {
        if(this.numerator == 0) {
            return;
        }
        int temp = this.numerator;
        this.numerator = this.denominator;
        this.denominator = temp;
        if (this.denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
    }

    public String toString() {
        return "The Rational Number is " + numerator + "/" + denominator;
    }

    public void display() {
        System.out.println("Numerator is " + numerator);
        System.out.println("Denominator is " + denominator);
        System.out.println("The Rational Number is " + numerator + "/" + denominator);
    }
}
