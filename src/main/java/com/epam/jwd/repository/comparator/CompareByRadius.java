package com.epam.jwd.repository.comparator;

import com.epam.jwd.entity.Sphere;

import java.util.Comparator;

public class CompareByRadius implements Comparator<Sphere>
{
    @Override
    public int compare(Sphere o1, Sphere o2)
    {
        return (int) (o1.getSphereRadius() - o2.getSphereRadius());
    }
}
