package com.epam.jwd.repository.Impl;

import com.epam.jwd.action.SphereGeometryAction;
import com.epam.jwd.action.impl.SphereGeometryActionImpl;
import com.epam.jwd.entity.Sphere;
import com.epam.jwd.repository.SphereSpecification;

public class SphereSpecificationByVolume implements SphereSpecification
{
    private final double from;
    private final double to;
    private final SphereGeometryAction action = new SphereGeometryActionImpl();

    public SphereSpecificationByVolume(double from, double to)
    {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specified(Sphere sphere)
    {
        double result = action.calculateSphereVolume(sphere);
        return from <= result && result <= to;
    }
}
