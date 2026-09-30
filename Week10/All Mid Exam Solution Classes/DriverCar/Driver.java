public class Driver {
    private String name;
    private int id;

    public Driver(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Driver(Driver other) {
        this(other.name, other.id);
    }

    @Override 
    public String toString() {
        return "Name: " + this.name + " ID: " + this.id;
    }
}
