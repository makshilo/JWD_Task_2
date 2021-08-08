package com.epam.jwd.reader.impl;

import com.epam.jwd.entity.Sphere;
import com.epam.jwd.exception.IncorrectInputException;
import com.epam.jwd.reader.SphereReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SphereReaderImpl implements SphereReader {
    public static final Logger LOG = LogManager.getLogger(SphereReaderImpl.class);
    @Override
    public List<Sphere> readFile(File file) throws IOException
    {
        List<Sphere> sphereObjects = new ArrayList<>();

        try (FileReader fileReader = new FileReader(file))
        {
            Scanner scanner = new Scanner(fileReader);
            int lineNum = 0;
            while (scanner.hasNextLine())
            {
                String sphereContext = scanner.nextLine();
                ++lineNum;
                try {
                    Sphere sphere = new Sphere(sphereContext);
                    sphereObjects.add(sphere);
                } catch (IncorrectInputException | NumberFormatException e) {
                    LOG.error(e.getMessage() + String.format(" : line %s", lineNum));
                }
            }
        }
        catch (FileNotFoundException e)
        {
            LOG.error(e.getMessage());
        }
        return sphereObjects;
    }
}
