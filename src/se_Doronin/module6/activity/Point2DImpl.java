package se_Doronin.module6.activity;


public class Point2DImpl implements Point2D {

    double x;
    double y;

    /**
     * Creates a Point2D object at a default location (0,0)
     */
    public Point2DImpl() {
        setX(0.0);
        setY(0.0);
    }

    /**
     * Create a Point2D object that represents a 2D coordinate specified
     * by the constructor parameters
     *
     * @param x coordinate of the point along the x-axis
     * @param y coordinate of the point along the y-axis
     */
    public Point2DImpl(double x, double y) {
        setX(x);
        setY(y);
    }

    public final void move(double x, double y) {
        setX(x);
        setY(y);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public final void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }


    public boolean equals(Object o) {
        Point2D p = (Point2D) o;
        return equals(p.getX(), p.getY());
    }


    public boolean equals(double x2, double y2) {
        return x == x2 && y == y2;
    }


    public final double getDistance(Point2D p) {
        return getDistance(p.getX(), p.getY());
    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point2D#getDistance(double, double)
     */
    public final double getDistance(double x2, double y2) {

        double d1 = Math.pow(x - x2, 2);
        double d2 = Math.pow(y - y2, 2);
        return Math.pow(d1 + d2, 0.5);
    }


}
