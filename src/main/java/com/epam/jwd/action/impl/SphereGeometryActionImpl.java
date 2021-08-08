package com.epam.jwd.action.impl;

import com.epam.jwd.action.ActionMessages;
import com.epam.jwd.action.SphereGeometryAction;
import com.epam.jwd.entity.Point3D;
import com.epam.jwd.entity.Sphere;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.pow;

public class SphereGeometryActionImpl implements SphereGeometryAction {
    private final static Logger LOG = LogManager.getLogger(SphereGeometryActionImpl.class);

    public double PI = Math.PI;

    public SphereGeometryActionImpl() {

    }

    public boolean isSphere(Object object)
    {
        return object instanceof Sphere;
    }

    @Override
    public double calculateSphereArea(Sphere sphere)
    {
        LOG.trace(ActionMessages.CALCULATING_SPHERE_AREA_MESSAGE);
        return PI * Math.pow(sphere.getSphereRadius() * 2, 2);
    }

    @Override
    public double calculateSphereVolume(Sphere sphere)
    {
        LOG.trace(ActionMessages.CALCULATING_SPHERE_VOLUME_MESSAGE);
        return 4 * PI * Math.pow(sphere.getSphereRadius(), 3)/3;
    }

    @Override
    public boolean isSphereTouchingFlat(Sphere sphere, Point3D point)
    {
        return Math.abs(point.getX() - sphere.getSphereCenterPoint().getX()) >= sphere.getSphereRadius()
                || Math.abs(point.getY() - sphere.getSphereCenterPoint().getY()) >= sphere.getSphereRadius()
                || Math.abs(point.getZ() - sphere.getSphereCenterPoint().getZ()) >= sphere.getSphereRadius();
    }

    @Override
    public double calculateSphereSegmentHeight(Sphere sphere, Point3D point)
    {
        LOG.trace(ActionMessages.CALCULATING_SPHERE_SEGMENT_HEIGHT_MESSAGE);
        for (double coordinate : point.getCoordinates())
        {
            for (double sphereCoordinate : sphere.getSphereCenterPoint().getCoordinates())
            {
                if (coordinate != 0 && sphereCoordinate != 0)
                {
                    return sphere.getSphereRadius()-Math.abs(coordinate - sphereCoordinate);
                }
            }
        }
        return 0;
    }

    @Override
    public double calculateSphereSegmentVolume(Sphere sphere, Point3D point)
    {
        LOG.trace(ActionMessages.CALCULATING_SPHERE_SEGMENT_VOLUME_MESSAGE);
        double sphereSegmentHeight = calculateSphereSegmentHeight(sphere, point);
        return PI * pow(sphereSegmentHeight, 2) * (sphere.getSphereRadius() - sphereSegmentHeight / 3);
    }

    @Override
    public double calculateSphereVolumeRatio(Sphere sphere, Point3D point)
    {
        LOG.trace(ActionMessages.CALCULATING_SPHERE_SEGMENT_RATIO_MESSAGE);
        double sphereSegmentVolume = calculateSphereSegmentVolume(sphere, point);
        double sphereRemainder = calculateSphereVolume(sphere) - sphereSegmentVolume;
        return sphereSegmentVolume / sphereRemainder;
    }
}
