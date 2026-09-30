import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override 
    public boolean equals(Object other) {
        if(this == other) 
            return true;
        if(other == null || this.getClass() != other.getClass())
            return false;
        Point point = (Point) other;
        return this.x == point.x && this.y == point.y;
    }

    @Override 
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    @Override 
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}