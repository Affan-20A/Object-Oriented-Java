public class Calculator {
    private double result;
    private double num1;
    private double num2;

    private static int objectCount = 0;

    public Calculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        objectCount++;
    }

    public Calculator() {
        this(0, 0);
    }

    public Calculator(Calculator copy) {
        this(copy.num1, copy.num2);
    }

    public void set(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public static int getObjectCount() {
        return objectCount;
    }
    
    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double getResult() {
        return result;
    }

    public void display() {
        System.out.println("Number 1 = " + num1);
        System.out.println("Number 2 = " + num2);
        System.out.println("Result = " + result);
    }

    public String toString() {
        return "Number 1 = " + num1 + " Number 2 = " + num2 + " Result = " + result;
    }

    public void add(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = this.num1 + this.num2;
    }

    public void subtract(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = this.num1 - this.num2;
    }

    public void multiply(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = this.num1 * this.num2;
    }

    public void divide(double num1, double num2) {
        if(num2 != 0) {
            this.num1 = num1;
            this.num2 = num2;
            this.result = this.num1 / this.num2;
        }
    }
}