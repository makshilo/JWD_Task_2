package com.epam.jwd.entity;

import com.epam.jwd.exception.IncorrectInputException;
import com.epam.jwd.validator.SphereInputValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sphere {
    private final Point3D sphereCenterPoint;
    private final double sphereRadius;

    public Sphere()
    {
        sphereCenterPoint = new Point3D();
        sphereRadius = 0.0;
    }

    public Sphere(Point3D initialSphereCenterPoint, double initialSphereRadius)
    {
        sphereCenterPoint = initialSphereCenterPoint;
        sphereRadius = initialSphereRadius;
    }

    public Sphere(String context) throws IncorrectInputException {
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
    public String toString() {
        return "Sphere3D{" +
                "sphereCenterPoint=" + sphereCenterPoint +
                ", sphereRadius=" + sphereRadius +
                '}';
    }

    public Point3D getSphereCenterPoint() {
        return sphereCenterPoint;
    }

    public double getSphereRadius() {
        return sphereRadius;
    }
}
