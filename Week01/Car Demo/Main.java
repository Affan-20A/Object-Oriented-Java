public class Main {
    public static void main(String[] args) {

        // Create a car using default constructor
        Car car1 = new Car();

        // Set its details
        car1.set("Toyota", "Corolla", 2022, "White");

        System.out.println(car1);
        car1.display();

        System.out.println("\nStarting car");
        car1.startStop();

        // Test acceleration
        System.out.println("\nAccelerating");
        for (int i = 0; i < 5; i++) {
            car1.accelerate();
        }

        car1.display();

        // Test turning
        System.out.println("\nTurning left");
        car1.turnLeft();
        System.out.println("Direction: " + car1.getDirection());

        System.out.println("\nTurning right");
        car1.turnRight();
        System.out.println("Direction: " + car1.getDirection());

        // Test braking
        car1.brake();
        System.out.println("\nSpeed: " + car1.getSpeed() + " km/h");

        // Test refuel
        car1.refuel(10);
        System.out.println("\nFuel: " + car1.getFuel() + " litres");


        // Create another car using parameterized constructor
        Car car2 = new Car("Honda", "Civic", 2023, "Black");

        // Create a copy of car2
        Car car3 = new Car(car2);

        System.out.println("\nCar 2:");
        car2.display();

        System.out.println("\nCar 3 (copy of Car 2):");
        car3.display();


        // Test object counter
        System.out.println("\nTotal cars created: " + Car.getObjectCounter());
    }
}