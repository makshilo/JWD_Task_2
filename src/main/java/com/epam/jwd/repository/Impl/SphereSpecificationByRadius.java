package com.epam.jwd.repository.Impl;

import com.epam.jwd.entity.Sphere;
import com.epam.jwd.repository.SphereSpecification;

public class SphereSpecificationByRadius implements SphereSpecification
{
    private final double from;
    private final double to;

    public SphereSpecificationByRadius(double from, double to)
    {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specified(Sphere sphere)
    {
        return from <= sphere.getSphereRadius() && sphere.getSphereRadius() <= to;
    }
}
