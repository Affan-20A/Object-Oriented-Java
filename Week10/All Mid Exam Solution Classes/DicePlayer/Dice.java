import java.util.Random;
public class Dice {
    private int sides;
    private int value;

    public Dice(int sides) {
        if(sides < 1) {
            throw new IllegalArgumentException("Dice must have at least one side");
        }
        this.sides = sides;
    }

    public int roll() {
        Random random = new Random();
        this.value = random.nextInt(1, this.sides+1);
        return this.value;
    }

    // public int roll() {    
    //     return (int) (Math.random() * this.sides +1);
    // }

    public int getSides() {
        return this.sides;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return "Sides: " + this.sides + " Value: " + this.value;
    }
}