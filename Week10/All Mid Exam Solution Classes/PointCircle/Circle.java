public class Circle implements Cloneable {
    private String label;
    private Point[] points;

    public Circle(String label, Point[] source) {
        this.label = label;
        this.points = new Point[source.length];
        for(int i=0 ; i< this.points.length ; i++) {
            this.points[i] = new Point(source[i]);
        }
    }

    public Point getPoint(int index) {
        if(index >= 0 && index < this.points.length) {
            return this.points[index];
        }
        throw new IllegalArgumentException("Index is not Valid");
    }

    @Override 
    public Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

    public Circle deepCopy() {
        Circle circle = new Circle(this.label, this.points);
        return circle;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i=0 ; i< this.points.length ; i++) {
            result.append(this.points[i]);
            if(i != this.points.length -1) {
                result.append(", ");
            }
        }
        return "Circle " + this.label + " has points [" + result.toString() + "]";
    }
}
