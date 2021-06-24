/** A class that represents a path via pursuit curves. */
public class Path {

    private Point curr, next;

    public Path(double x, double y) {
        curr = new Point(2, 4);
        next = new Point(x, y);
    }

    public double getCurrX() {
        return curr.getX();
    }

    public double getCurrY() {
        return curr.getY();
    }

    public double getNextX() {
        return next.getY();
    }

    public double getNextY() {
        return next.getY();
    }

    public Point getCurrentPoint() {
        return curr;
    }

    public void setCurrentPoint(Point point) {
        curr = point;
    }

    public void iterate(double dx, double dy) {
        curr = next;
        next = new Point(curr.getX() + dx, curr.getY() + dy);
    }
}
