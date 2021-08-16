package com.epam.jwd.repository.Impl;

import com.epam.jwd.entity.Sphere;
import com.epam.jwd.repository.SphereRepository;
import com.epam.jwd.repository.SphereSpecification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SphereRepositoryImpl implements SphereRepository
{
    private final List<Sphere> sphereList;

    public SphereRepositoryImpl(ArrayList<Sphere> sphereList)
    {
        this.sphereList = sphereList;
    }

    @Override
    public void addSphere(Sphere sphere)
    {
        sphereList.add(sphere);
    }

    @Override
    public void removeSphere(int id)
    {
        sphereList.remove(id);
    }

    @Override
    public void updateSphere(int id, Sphere sphere)
    {
        sphereList.set(id,sphere);
    }

    @Override
    public int size()
    {
        return sphereList.size();
    }

    @Override
    public Sphere find(int id)
    {
        return sphereList.get(id);
    }

    @Override
    public void sort()
    {
        Collections.sort(sphereList);
    }

    @Override
    public void sort(Comparator<Sphere> comparator)
    {
        sphereList.sort(comparator);
    }

    @Override
    public List<Sphere> query(SphereSpecification specification)
    {
        List<Sphere> suitableSpheres = new ArrayList<>();

        for (Sphere sphere : sphereList)
        {
            if (specification.specified(sphere))
            {
                suitableSpheres.add(sphere);
            }
        }
        return suitableSpheres;
    }
}
