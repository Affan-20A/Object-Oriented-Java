public class Car implements Cloneable {
    private String model;
    private Driver driver;
    private int[] speedHistory;

    public Car(String model, String driverName, int driverID) {
        this.model = model;
        this.driver = new Driver(driverName, driverID);
        this.speedHistory = new int[2];
    }

    public void drive() {
        this.speedHistory[0] = 0;
        this.speedHistory[1] = 0;
    }

    public void drive(int speed) {
        this.speedHistory[0] = speed;
        this.speedHistory[1] = speed;
    }

    public void setSpeed(int index, int speed) {
        if(index >= 0 && index < 2)
            speedHistory[index] = speed;
        else
            throw new IllegalArgumentException("Invalid Index");
    }

    public int getSpeed(int index) {
        if(index >= 0 && index < 2)
            return speedHistory[index];
        else
            throw new IllegalArgumentException("Invalid Index");
    }

    @Override 
    public Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }

    public Car deepCopy() {
        Car car = new Car(model, null, 0);
        car.driver = new Driver(this.driver);
        return car;
    }

    @Override 
    public String toString() {
        return "Model: " + this.model +
               " Driver: " + this.driver +
               "Speed History: [" + this.speedHistory[0] + ", " + this.speedHistory[1] + "]"; 
    }
}
