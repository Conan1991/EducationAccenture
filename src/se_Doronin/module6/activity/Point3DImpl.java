package sef.module6.activity;

/**
 * @author John Doe
 * <p>
 * This class represents a point in 3D space.  The coordinates are represented by
 * a set of values x, y an z that represents the coordinates along each plane
 */
public class Point3DImpl extends Point2DImpl implements Point3D {

    @SuppressWarnings("unused")
    private double z;

    /**
     * Creates a Point3D object with the default coordinate of 0,0,0
     */
    public Point3DImpl() {
    }

    /**
     * Creates a Point3D object at the specified coordinates
     *
     * @param x coordinate along the x axis
     * @param y coordinate along the y axis
     * @param z coordinate along the z axis
     */
    public Point3DImpl(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public final void setZ(double z) {
        this.z = z;
    }

    public final double getZ() {
        return z;
    }

    public void move(double x2, double y2, double z2) {
        move(x2, y2);
        setZ(z2);
    }

    public void translate(double x2, double y2, double z2) {
        translate(x2, y2);
        z += z2;
    }

    public boolean equals(double x2, double y2, double z2) {
        return equals(x2, y2) && z == z2;
    }

    /**
     * Compares if the coordinates are equal to the coordinates specified by the parameter
     *
     * @param o the coordinates to compare
     * @return true if the parameter is an instance of Point3D and contain the same coordinates, false otherwise
     */
    public boolean equals(Object o) {
        Point3D p = (Point3D) o;
        return equals(p.getX(), p.getY(), p.getZ());
    }


    public double getDistance(Point3D p) {
        return getDistance(p.getX(), p.getY(), p.getZ());
    }

    public double getDistance(double x2, double y2, double z2) {
        double d1 = Math.pow(x - x2, 2);
        double d2 = Math.pow(y - y2, 2);
        double d3 = Math.pow(z - z2, 2);
        return Math.pow(d1 + d2 + d3, 0.5);
    }


}
