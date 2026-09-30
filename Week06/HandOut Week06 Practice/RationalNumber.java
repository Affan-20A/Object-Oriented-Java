final class RationalNumber {

    private final int numerator;
    private final int denominator;

    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator must not be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        RationalNumber other = (RationalNumber) obj;
        return this.numerator == other.numerator &&
               this.denominator == other.denominator;
    }

    // Overloaded method return type is same but parameters are different
    public boolean equals(RationalNumber other) {
        return other != null && this.numerator == other.numerator &&
                                this.denominator == other.denominator;
    }

    public static void main(String[] args) {

        RationalNumber r1 = new RationalNumber(10, 5);
        RationalNumber r2 = new RationalNumber(10, 5);

        Object o1 = r1;
        Object o2 = r2;

        System.out.println("r1.equals(r2) = " + r1.equals(r2));
        // calls overloaded method, compares objects, returns true

        System.out.println("o1.equals(o2) = " + o1.equals(o2));
        // calls equals() from super class since called by an Object not RationalNumber
        // compares references and returns false

        System.out.println("r1.equals(o2) = " + r1.equals(o2));
        // calls equals() from super class since parameter of overloaded method is different
        // compares references and returns false

        System.out.println("o1.equals(r2) = " + o1.equals(r2));
        // calls equals() from super class since called by an Object not RationalNumber
        // compares references and returns false

        System.out.println("r1.equals(o1) = " + r1.equals(o1));
        // calls equals() from super class since parameter of overloaded method is different
        // compares references and returns true
    }
}