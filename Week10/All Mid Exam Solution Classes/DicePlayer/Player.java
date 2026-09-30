public class Player {
    private String name;
    private Dice[] dice;
    private int total;

    public Player(String name, int count, int sides) {
        this.name = name;
        this.dice = new Dice[count];
        for(int i=0 ; i< this.dice.length ; i++) {
            this.dice[i] = new Dice(sides);
        }
    }

    public int getTotal() {
        return this.total;
    }

    public void roll() {
        this.total = 0;
        for(int i=0 ; i<this.dice.length ; i++) {
            this.total += this.dice[i].roll();
        }
    }

    public void rollAgain(int index) {
        if(index < 0 || index >= dice.length) {
            throw new IllegalArgumentException("Invalid dice index");
        }
        this.total -= this.dice[index].getValue();
        this.total += this.dice[index].roll();
    }

    public void bonusRoll() {
        this.total = 0;
        for(int i=0 ; i< this.dice.length ; i++) {
            this.dice[i].setValue(this.dice[i].getSides());
            this.total += this.dice[i].getValue();
        }
    }

    public void cheatRoll() {

        // validation to get safe from infinite loop
        boolean maxValues = true;
        for(int i=0 ; i< this.dice.length ; i++) {
            if(this.dice[i].getValue() != this.dice[i].getSides()) {
                maxValues = false;
            }
        }
        if(maxValues) {
            throw new IllegalArgumentException("All dice have maximum values!");
        }

        int lowestIndex = 0;
        // identifying index of lowest value die
        // linear search algorithm
        for(int i=0 ; i< this.dice.length ; i++) {
            if(this.dice[i].getValue() < this.dice[lowestIndex].getValue()) {
                lowestIndex = i;
            }
        }
        // preserving old value
        int lowestValue = this.dice[lowestIndex].getValue();
        int newValue = this.dice[lowestIndex].roll();
        while(newValue <= lowestValue) {
            newValue = this.dice[lowestIndex].roll();
        }
        this.total = total - lowestValue + newValue;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i=0 ; i< this.dice.length ; i++) {
            result.append(this.dice[i]);
            if(i != this.dice.length -1){
                result.append(" | ");
            }
        }
        return "Player: " + this.name +
               "\nTotal: " + this.total +
               "\nDice Info: " + result.toString();
    }
}
