public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    private double perimeter;
    private double area;

    private static int objectCount = 0;

    public Triangle() {
        this.sideA = 1.0;
        this.sideB = 1.0;
        this.sideC = 1.0;
        objectCount++;
    }

    public Triangle(double side) {
        if(side > 0) {
            this.sideA = side;
            this.sideB = side;
            this.sideC = side;
            objectCount++;
        }
        else {
            throw new IllegalArgumentException("Triangle is not Valid");
        }
    }

    public Triangle(double x, double y) {
        if((x + x > y) && (x + y > x) && x > 0 && y > 0) {
            this.sideA = x;
            this.sideB = x;
            this.sideC = y;
            objectCount++;
        }
        else {
            throw new IllegalArgumentException("Triangle is not Valid");
        }
    }

    public Triangle(double sideA, double sideB, double sideC) {
        if((sideA + sideB > sideC) && (sideB + sideC > sideA) && (sideC + sideA > sideB) && sideA > 0 && sideB > 0 && sideC > 0) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            objectCount++;
        }
        else {
            throw new IllegalArgumentException("Triangle is not Valid");
        }
    }

    public Triangle(Triangle copy) {
        this(copy.sideA, copy.sideB, copy.sideC);
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public String toString() {
        return "Side A = " + this.sideA + " Side B = " + this.sideB + " Side C = " + this.sideC;
    }

    public void display() {
        System.out.println("Side A = " + this.sideA);
        System.out.println("Side B = " + this.sideB);
        System.out.println("Side C = " + this.sideC);
        System.out.println("Perimeter = " + this.perimeter);
        System.out.println("Area = " + this.area);
    }

    public double perimeter() {
        this.perimeter = this.sideA + this.sideB + this.sideC;
        return this.perimeter;
    }

    public boolean isRightAngled() {
        double a = this.sideA;
        double b = this.sideB;
        double c = this.sideC;

        if(a > c) {
            double temp = a;
            a = c;
            c = temp;
        }
        if(b > c) {
            double temp = b;
            b = c;
            c = temp;
        }
        return (a*a + b*b) == (c*c);
    }

    public boolean isValid() {
        return (this.sideA + this.sideB > this.sideC) && (this.sideB + this.sideC > this.sideA) && (this.sideC + this.sideA > this.sideB);
    }

    public boolean isEquilateral() {
        return this.sideA == this.sideB && this.sideB == this.sideC;
    }

    public boolean isIsosceles() {
        return !isEquilateral() && (this.sideA == this.sideB || this.sideB == this.sideC || this.sideC == this.sideA);
    }

    public boolean isScalene() {
        return (this.sideA != this.sideB) && (this.sideB != this.sideC) && (this.sideC != this.sideA);
    }

    public double largestSide() {
        return Math.max(this.sideA, Math.max(this.sideB, this.sideC));
    }

    public double smallestSide() {
        return Math.min(this.sideA, Math.min(this.sideB, this.sideC));
    }

    public double area() {
        double s = this.perimeter()/2.0;
        this.area = Math.sqrt(s*(s - this.sideA)*(s - this.sideB)*(s - this.sideC));
        return this.area;
    }

    public void set(double sideA, double sideB, double sideC) {
        if((sideA + sideB > sideC) && (sideB + sideC > sideA) && (sideC + sideA > sideB)) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
        else {
            throw new IllegalArgumentException("Triangle is not Valid");
        }
    }

    public double getSideA() {
        return this.sideA;
    }

    public double getSideB() {
        return this.sideB;
    }

    public double getSideC() {
        return this.sideC;
    }
}
    
