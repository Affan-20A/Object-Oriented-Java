public class PointArray implements Cloneable {
    private Point[] points;

    public PointArray(Point[] points) {
        this.points = new Point[points.length];
        for(int i=0 ; i< points.length ; i++) {
            this.points[i] = new Point(points[i]);
        }
    }

    public Point getPoint(int index) {
        return this.points[index];
    }

    @Override 
    public PointArray clone() throws CloneNotSupportedException {
        return (PointArray) super.clone();
    }

    public PointArray deepCopy() {
        PointArray p = new PointArray(this.points);
        return p;
    }

    @Override 
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i=0 ; i< this.points.length ; i++) {
            result.append(this.points[i]);
            result.append(", ");
        }
        return "[" + result.toString() + "]";
    }
}
