package com.epam.jwd.reader;

import com.epam.jwd.entity.Sphere;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface SphereReader {
    List<Sphere> readFile(File file) throws IOException;
}
