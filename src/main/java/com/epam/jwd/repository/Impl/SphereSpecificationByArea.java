package com.epam.jwd.repository.Impl;

import com.epam.jwd.action.SphereGeometryAction;
import com.epam.jwd.action.impl.SphereGeometryActionImpl;
import com.epam.jwd.entity.Sphere;
import com.epam.jwd.repository.SphereSpecification;

public class SphereSpecificationByArea implements SphereSpecification
{
    private final double from;
    private final double to;
    private final SphereGeometryAction action = new SphereGeometryActionImpl();

    public SphereSpecificationByArea(double from, double to)
    {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specified(Sphere sphere)
    {
        double result = action.calculateSphereArea(sphere);
        return from <= result && result <= to;
    }
}
