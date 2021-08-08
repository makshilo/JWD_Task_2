package com.epam.jwd.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Point3D
{
    public static final Logger LOG = LogManager.getLogger(Point3D.class);
    public static final String CREATING_POINT_MESSAGE = "Creating point3DEntity";

    private final double x,y,z;

    public Point3D()
    {
        LOG.trace(CREATING_POINT_MESSAGE);
        x = 0.0;
        y = 0.0;
        z = 0.0;
    }

    public Point3D(double initialX, double initialY, double initialZ)
    {
        LOG.trace(CREATING_POINT_MESSAGE);
        x = initialX;
        y = initialY;
        z = initialZ;
    }

    public double[] getCoordinates()
    {
        return new double[]{x,y,z};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point3D that = (Point3D) o;

        if (Double.compare(that.x, x) != 0) return false;
        if (Double.compare(that.y, y) != 0) return false;
        return Double.compare(that.z, z) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Point3DEntity{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public double getX() { return x; }

    public double getY()
    {
        return y;
    }

    public double getZ()
    {
        return z;
    }

}