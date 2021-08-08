package com.epam.jwd.action;

import com.epam.jwd.action.impl.SphereGeometryActionImpl;
import com.epam.jwd.entity.Point3D;
import com.epam.jwd.entity.Sphere;
import com.epam.jwd.reader.impl.SphereReaderImpl;
import com.epam.jwd.reader.SphereReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SphereGeometryImplTest
{
    private static final String INPUT_FILE_PATH = "src/test/resources/test1.txt";
    private static final double DELTA = 0.001;

    private Point3D testPoint;
    private List<Sphere> sphereEntityList;
    private SphereGeometryAction sphereGeometryAction;

    @BeforeTest
    public void initialization() throws IOException
    {
        testPoint = new Point3D(0,0,1);
        File inputFile = new File(INPUT_FILE_PATH);
        SphereReader sphereReader = new SphereReaderImpl();
        sphereEntityList = sphereReader.readFile(inputFile);
        sphereGeometryAction = new SphereGeometryActionImpl();
    }

    @Test
    public void testCalculateSphereArea()
    {
        double expected = 12.5663;
        double calculated = sphereGeometryAction.calculateSphereArea(sphereEntityList.get(0));
        Assert.assertEquals(expected, calculated, DELTA);
    }
    @Test
    public void testCalculateSphereVolume()
    {
        double expected = 33.5103;
        double calculated = sphereGeometryAction.calculateSphereVolume(sphereEntityList.get(1));
        Assert.assertEquals(expected,calculated, DELTA);
    }
    @Test
    public void testCalculateSphereVolumeRatio()
    {
        double expected = 0.08;
        double calculated = sphereGeometryAction.calculateSphereVolumeRatio(sphereEntityList.get(2), testPoint);
        Assert.assertEquals(expected, calculated, DELTA);
    }
    @Test
    public void testIsSphereTouchingFlat()
    {
        Assert.assertTrue(sphereGeometryAction.isSphereTouchingFlat(sphereEntityList.get(3),testPoint));
    }
    @Test
    public void testIsSphere()
    {
        Assert.assertTrue(sphereGeometryAction.isSphere(sphereEntityList.get(4)));
    }
}
