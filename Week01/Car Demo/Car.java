public class Car {
    private String brand;
    private String model;
    private int year;
    private String colour;

    private double speed = 0;
    private boolean key = false;
    private double fuel = 20; //liters
    private int direction = 90; //angle

    private static int objectCounter = 0;

    public Car() {
        objectCounter++;
    }

    public Car(String brand, String model, int year, String colour) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.colour = colour;
        objectCounter++;
    }

    public Car(Car copy) {
        this.brand = copy.brand;
        this.model = copy.model;
        this.year = copy.year;
        this.colour = copy.colour;
        this.speed = copy.speed;
        this.key = copy.key;
        this.fuel = copy.fuel;
        this.direction = copy.direction;
        objectCounter++;
    }

    public static int getObjectCounter() {
        return objectCounter;
    }

    public void set(String brand, String model, int year, String colour) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.colour = colour;
    }

    public double getSpeed() {
        return this.speed;
    }

    public double getFuel() {
        return this.fuel;
    }

    public boolean getKey() {
        return this.key;
    }

    public int getDirection() {
        return this.direction;
    }

    public String toString() {
        return "You Are Driving a " + this.colour + " " + this.brand + " " + this.model + " " + this.year;
    }
    
    public void startStop() {
        key = !key;
    }

    public void display() {
        System.out.println("Brand: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("Year: " + this.year);
        System.out.println("Colour: " + this.colour);
        System.out.println("Speed: " + this.speed + "km/h");
        System.out.println("Fuel: " + this.fuel + "litres");
    }

    public void accelerate() {
        if(speed < 120 && fuel > 0 && key) {
            speed = Math.min(120, speed + 5);
            fuel = Math.max(0, fuel - 2);
        }
    }

    public void decelerate() {
        if(speed > 0 && fuel > 0) {
            speed = Math.max(0, speed - 5);
            fuel = Math.max(0, fuel - 1);
        }
    }

    public void brake() {
        speed = 0;
    }

    public void turnLeft() {
        direction = (direction + 5) % 360;
    }

    public void turnRight() {
        direction = (direction - 5 + 360) % 360;
    }

    public void refuel(int fuel) {
        this.fuel += fuel;
    }
}
