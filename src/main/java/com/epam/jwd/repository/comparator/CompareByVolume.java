package com.epam.jwd.repository.comparator;

import com.epam.jwd.action.SphereGeometryAction;
import com.epam.jwd.action.impl.SphereGeometryActionImpl;
import com.epam.jwd.entity.Sphere;

import java.util.Comparator;

public class CompareByVolume implements Comparator<Sphere>
{
    private static final SphereGeometryAction action = new SphereGeometryActionImpl();

    @Override
    public int compare(Sphere o1, Sphere o2)
    {
        return (int) (action.calculateSphereVolume(o1) - action.calculateSphereVolume(o2));
    }
}