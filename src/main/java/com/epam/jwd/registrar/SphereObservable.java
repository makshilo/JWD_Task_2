package com.epam.jwd.registrar;

public interface SphereObservable
{
    void registerObserver(SphereObserver o);
    void removeObserver(SphereObserver o);
    void notifyObservers();
}
