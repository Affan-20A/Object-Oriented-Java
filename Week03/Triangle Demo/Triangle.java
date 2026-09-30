public class Triangle {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    private static int objectCount;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        if(pointA == null || pointB == null || pointC == null) {
            throw new IllegalArgumentException("Triangle without vertices does not exist");
        }
        if(!isValid(pointA, pointB, pointC)) {
            throw new IllegalArgumentException("Invalid Vertices");
        }
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        objectCount++;
    }

    public Triangle(Triangle copy) {
        this(new Point(copy.pointA), new Point(copy.pointB), new Point(copy.pointC));
    }

    // Area = 1/2 [x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2)]
    private static boolean isValid(Point pointA, Point pointB, Point pointC) {
        double area = 0.5 * Math.abs(pointA.getX()*(pointB.getY() - pointC.getY()) + pointB.getX()*(pointC.getY() - pointA.getY()) + pointC.getX()*(pointA.getY() - pointB.getY()));
        return area > 1e-10;
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public void set(Point pointA, Point pointB, Point pointC) {
        if(pointA == null || pointB == null || pointC == null) {
            throw new IllegalArgumentException("Triangle without vertices does not exist");
        }
        if(!isValid(pointA, pointB, pointC)) {
            throw new IllegalArgumentException("Invalid Vertices");
        }
        this.pointA = new Point(pointA);
        this.pointB = new Point(pointB);
        this.pointC = new Point(pointC);
    }

    public Point getPointA() {
        return new Point(this.pointA);
    }
    public Point getPointB() {
        return new Point(this.pointB);
    }
    public Point getPointC() {
        return new Point(this.pointC);
    }

    public double getSideA() {
        return this.pointB.distanceFromPoint(this.pointC);
    }
    public double getSideB() {
        return this.pointC.distanceFromPoint(this.pointA);
    }
    public double getSideC() {
        return this.pointA.distanceFromPoint(this.pointB);
    }

    public double getPerimeter() {
        return getSideA() + getSideB() + getSideC();
    }

    public double getArea() {
        double a = getSideA();
        double b = getSideB();
        double c = getSideC();
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    public Point getCentroid() {
        double x = (this.pointA.getX() + this.pointB.getX() + this.pointC.getX()) / 3.0;
        double y = (this.pointA.getY() + this.pointB.getY() + this.pointC.getY()) / 3.0;
        return new Point(x, y);
    }

    public double getAngleA() {
        double a = getSideA();
        double b = getSideB();
        double c = getSideC();
        return Math.acos((b*b + c*c - a*a) / (2*b*c));
    }

    public double getAngleB() {
        double a = getSideA();
        double b = getSideB();
        double c = getSideC();
        return Math.acos((a*a + c*c - b*b) / (2*a*c));
    }

    public double getAngleC() {
        double a = getSideA();
        double b = getSideB();
        double c = getSideC();
        return Math.acos((a*a + b*b - c*c) / (2*a*b));
    }

    public String toString() {
        return "The vertices are " + this.pointA + " " + this.pointB + " " + this.pointC;
    }

    public void display() {
        System.out.println("Point A is " + this.pointA);
        System.out.println("Point B is " + this.pointB);
        System.out.println("Point C is " + this.pointC);
    }
}