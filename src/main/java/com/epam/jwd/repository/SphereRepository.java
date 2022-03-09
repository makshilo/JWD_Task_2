package com.epam.jwd.repository;

import com.epam.jwd.entity.Sphere;

import java.util.Comparator;
import java.util.List;

public interface SphereRepository
{
    void addSphere(Sphere sphere);
    void removeSphere(int id);
    void updateSphere(int id, Sphere sphere);
    int size();
    Sphere find(int id);
    void sort();
    void sort(Comparator<Sphere> comparator);

    List<Sphere> query(SphereSpecification specification);
}
