package com.epam.jwd.action;

import com.epam.jwd.entity.Point3D;
import com.epam.jwd.entity.Sphere;

public interface SphereGeometryAction
{
    boolean isSphere(Object object);

    double calculateSphereArea(Sphere sphere);

    double calculateSphereVolume(Sphere sphere);

    boolean isSphereTouchingFlat(Sphere sphere, Point3D point);

    double calculateSphereSegmentHeight(Sphere sphere, Point3D point);

    double calculateSphereSegmentVolume(Sphere sphere, Point3D point);

    double calculateSphereVolumeRatio(Sphere sphere, Point3D point);

}
