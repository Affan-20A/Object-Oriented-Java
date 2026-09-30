import java.util.Objects;

public class Triangle implements Cloneable {
    private Line a;
    private Line b;
    private Line c;

    private static int objectCount;

    public Triangle(Line a, Line b, Line c) {
        // set() will call the set() method so that it validates and than initialize the objects
        // reduces code redundancy
        set(a, b, c);
        objectCount++;
    }

    public Triangle() {
        // Using new Keyword for every abstract data type to protect Encapsulation
        this.a = new Line(new Point(5, 0), new Point(10, 0));
        this.b = new Line(new Point(5, 0), new Point(10, 0));
        this.c = new Line(new Point(5, 0), new Point(10, 0));
        objectCount++;
    }

    public Triangle(Triangle copy) {
        // this() will call the parameterized constructor
        this(new Line(copy.a), new Line(copy.b), new Line(copy.c));
    }

    // A private method for Validation
    private boolean isValid(Line a, Line b, Line c) {
        return a.getLength() + b.getLength() > c.getLength() &&
               b.getLength() + c.getLength() > a.getLength() &&
               c.getLength() + a.getLength() > b.getLength();
    }

    public void set(Line a, Line b, Line c) {
        if (isValid(a, b, c)) {
            this.a = new Line(a);
            this.b = new Line(b);
            this.c = new Line(c);
        }
        else {
            throw new IllegalArgumentException("Triangle is not Valid");
        }
    }

    public Line getA() {
        return new Line(this.a);
    }
    public Line getB() {
        return new Line(this.b);
    }
    public Line getC() {
        return new Line(this.c);
    }

    // Methods for convinience to get the length of each side
    public double getLengthOfA() {
        return this.a.getLength();
    }
    public double getLengthOfB() {
        return this.b.getLength();
    }
    public double getLengthOfC() {
        return this.c.getLength();
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public double getPerimeter() {
        return this.getLengthOfA() + this.getLengthOfB() + this.getLengthOfC();
    }

    public double getArea() {
        double s = this.getPerimeter() / 2.0;
        return Math.sqrt(s * (s - this.getLengthOfA()) * (s - this.getLengthOfB()) * (s - this.getLengthOfC()));
    }

    @Override
    public boolean equals(Object obj) {
        // Checks if both are same objects
        if(this == obj)
            return true;
        // Checks for null and if we are comparing two Triangle objects
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        // Typecasts Object into Triangle
        Triangle other = (Triangle) obj;
        // Compares attributes
        return Objects.equals(this.a, other.a) && Objects.equals(this.b, other.b) && Objects.equals(this.c, other.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public Triangle clone() {
        try {
            Triangle copy = (Triangle) super.clone();
            copy.a = this.a.clone();
            copy.b = this.b.clone();
            copy.c = this.c.clone();
            return copy;
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "The triangle has three lines:\n" +
            "A: " + this.a + "\nB: " + this.b + "\nC: " + this.c;
    }

    public void display() {
        System.out.println(this);
        System.out.println("Length of A is " + this.getLengthOfA());
        System.out.println("Length of B is " + this.getLengthOfB());
        System.out.println("Length of C is " + this.getLengthOfC());
    }
}