public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Car c1 = new Car("Civic", "Sara", 101);
        c1.drive();
        c1.drive(80); 

        Car c2 = c1.clone(); // shallow copy
        Car c3 = c1.deepCopy(); // deep copy
        
        c2.setSpeed(0, 90);
        System.out.println("After shallow copy: " + c1.getSpeed(0));
        c3.setSpeed(1, 100);
        System.out.println("After deep copy : " + c1.getSpeed(1));
    }
}
