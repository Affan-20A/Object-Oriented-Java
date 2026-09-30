public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Ali");

        student1.inputGrades();

        // Display student information
        System.out.println(student1);

        // Display name and average
        System.out.print("Student Name: ");
        student1.printName();
        System.out.println("\nAverage Score: " + student1.getAverage());

        Student student2 = new Student("Sara");

        student2.inputGrades();

        // Display student information
        System.out.println(student2);

        // Display name and average
        System.out.print("Student Name: ");
        student2.printName();
        System.out.println("\nAverage Score: " + student2.getAverage());
    }
}