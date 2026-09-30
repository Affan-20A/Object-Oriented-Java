import java.util.Scanner;

public class Student {
    private String name;
    private double scoreTest1;
    private double scoreTest2;

    public Student(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.print(name);
    }

    // public void inputGrades() {
    //     Scanner sc = new Scanner(System.in);
    //     System.out.print("Enter score of test 1 for " + name + ": ");
    //     this.scoreTest1 = sc.nextDouble();
    //     System.out.print("Enter score of test 2 for " + name + ": ");
    //     this.scoreTest2 = sc.nextDouble();
    // }

    public void inputGrades() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("Enter score of test 1 for " + name + ": ");
            this.scoreTest1 = sc.nextDouble();
            if(this.scoreTest1 >= 0 && this.scoreTest1 <= 100) {
                break;
            }
            System.out.println("Invalid Score! Enter a value between 0 and 100");
        }

        while(true) {
            System.out.print("Enter score of test 2 for " + name + ": ");
            this.scoreTest2 = sc.nextDouble();
            if(this.scoreTest2 >= 0 && this.scoreTest2 <= 100) {
                break;
            }
            System.out.println("Invalid Score! Enter a value between 0 and 100");
        }
    }

    public double getAverage() {
        return (scoreTest1 + scoreTest2) / 2.0;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + " Test# 1 Score: " + scoreTest1 + " Test# 2 Score: " + scoreTest2;
    }
}
