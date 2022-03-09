package com.epam.jwd.registrar.Impl;

import com.epam.jwd.action.SphereGeometryAction;
import com.epam.jwd.action.impl.SphereGeometryActionImpl;
import com.epam.jwd.entity.Point3D;
import com.epam.jwd.entity.Sphere;
import com.epam.jwd.registrar.SphereObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereObserverImpl implements SphereObserver
{
    private static SphereObserverImpl sphereObserverImplInstance;

    private final static Logger LOG = LogManager.getLogger(SphereObserver.class);

    private double sphereArea;
    private double sphereVolume;

    private SphereObserverImpl()
    {

    }

    public static SphereObserverImpl getInstance()
    {
        if(sphereObserverImplInstance == null){
            sphereObserverImplInstance = new SphereObserverImpl();
        }
        return sphereObserverImplInstance;
    }

    @Override
    public void update(Point3D sphereCenterPoint, double sphereRadius) {
        SphereGeometryAction sphereGeometryAction = new SphereGeometryActionImpl();
        LOG.trace("Recalculating SphereArea");
        this.sphereArea = sphereGeometryAction.calculateSphereArea(new Sphere(sphereCenterPoint,sphereRadius));
        LOG.trace("Recalculating SphereVolume");
        this.sphereVolume = sphereGeometryAction.calculateSphereVolume(new Sphere(sphereCenterPoint,sphereRadius));
        display();
    }

    public void display() {
        LOG.trace("Current sphere measurements\n sphereArea {},\n sphereVolume {}", sphereArea,sphereVolume);
    }
}
