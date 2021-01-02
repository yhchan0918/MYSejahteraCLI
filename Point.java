/**
 * A point representing a coordinate (x, y) where x and y are integers.
 */
public class Point {
    private int x = 0;
    private int y = 0;

    /**
     * Constructs a point with both x and y are set to zero (0).
     */
    public Point() {
    }

    /**
     * Constructs a point with the specified x and y.
     *
     * @param x the x value of point
     * @param y the y value of point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the distance from the specified point.
     *
     * @param p the other point from which the distance is caluclated
     * @return the distance from p
     */
    public double distance(Point p) {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Returns the point in (x,y).
     * 
     * @return (x,y)
     */
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}