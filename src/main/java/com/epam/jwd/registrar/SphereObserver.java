package com.epam.jwd.registrar;

import com.epam.jwd.entity.Point3D;

public interface SphereObserver
{
    void update(Point3D sphereCenterPoint, double sphereRadius);
}
