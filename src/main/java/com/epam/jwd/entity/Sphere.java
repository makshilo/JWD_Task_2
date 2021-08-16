package com.epam.jwd.entity;

import com.epam.jwd.action.SphereGeometryAction;
import com.epam.jwd.action.impl.SphereGeometryActionImpl;
import com.epam.jwd.exception.IncorrectInputException;
import com.epam.jwd.registrar.SphereObservable;
import com.epam.jwd.registrar.SphereObserver;
import com.epam.jwd.validator.SphereInputValidator;

import java.util.LinkedList;
import java.util.List;

public class Sphere implements SphereObservable, Comparable<Sphere> {
    private Point3D sphereCenterPoint;
    private double sphereRadius;

    private final List<SphereObserver> observers;

    public Sphere()
    {
        sphereCenterPoint = new Point3D();
        sphereRadius = 0.0;
        observers = new LinkedList<>();
    }

    public Sphere(Point3D initialSphereCenterPoint, double initialSphereRadius)
    {
        sphereCenterPoint = initialSphereCenterPoint;
        sphereRadius = initialSphereRadius;
        observers = new LinkedList<>();
    }

    public Sphere(String context) throws IncorrectInputException {
        observers = new LinkedList<>();
        SphereInputValidator validator = new SphereInputValidator();
        if (validator.checkInput(context))
        {
            final String PARAM_SEPARATOR = ";";
            final String VALUE_SEPARATOR = ",";

            String[] sphereParameters = context.split(PARAM_SEPARATOR);
            String[] centerBaseCoordinates = sphereParameters[0].split(VALUE_SEPARATOR);

            double x = Double.parseDouble(centerBaseCoordinates[0]);
            double y = Double.parseDouble(centerBaseCoordinates[1]);
            double z = Double.parseDouble(centerBaseCoordinates[2]);

            sphereCenterPoint = new Point3D(x,y,z);
            sphereRadius = Double.parseDouble(sphereParameters[1]);

        } else {
            throw new IncorrectInputException("INCORRECT_INPUT");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sphere sphere = (Sphere) o;

        if (Double.compare(sphere.sphereRadius, sphereRadius) != 0) return false;
        return sphereCenterPoint.equals(sphere.sphereCenterPoint);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = sphereCenterPoint.hashCode();
        temp = Double.doubleToLongBits(sphereRadius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Sphere3D{" +
                "sphereCenterPoint=" + sphereCenterPoint +
                ", sphereRadius=" + sphereRadius +
                '}';
    }

    @Override
    public void registerObserver(SphereObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(SphereObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (SphereObserver observer : observers)
            observer.update(sphereCenterPoint, sphereRadius);
    }

    public void setSphereCenterPoint(Point3D sphereCenterPoint) {
        this.sphereCenterPoint = sphereCenterPoint;
        notifyObservers();
    }

    public void setSphereRadius(double sphereRadius) {
        this.sphereRadius = sphereRadius;
        notifyObservers();
    }

    @Override
    public int compareTo(Sphere comparable) {
        SphereGeometryAction action = new SphereGeometryActionImpl();
        return (int) (action.calculateSphereVolume(this) - action.calculateSphereVolume(comparable));
    }

    public Point3D getSphereCenterPoint() {
        return sphereCenterPoint;
    }

    public double getSphereRadius() {
        return sphereRadius;
    }
}
