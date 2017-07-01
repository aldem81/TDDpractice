package test.java.entities.enclosedarea;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.entities.enclosedarea.EnclosedArea;
import main.java.entities.enclosedarea.EnclosedAreaFactory;

public class EnclosedAreaFactoryTest {

    private EnclosedAreaFactory factory;

    @Before
    public void setUp() {
        factory = new EnclosedAreaFactory();
    }

    @Test
    public void shouldReturnZeroDevicesWhenAreaCreatedWithNoDevices() {
        EnclosedArea area = factory.generateAreatWithoutDevices();
        assertEquals(0, area.getNumberOfDevices());
    }

    @Test
    public void shouldReturnCorrectNumberOfDevicesWhenAreaCreatedWithDevices() {
        EnclosedArea area = factory.generateAreaWithRandomDevicesInNumberOf(3);
        assertEquals(3, area.getNumberOfDevices());
        area = factory.generateAreaWithRandomDevicesInNumberOf(5);
        assertEquals(5, area.getNumberOfDevices());
    }
}
