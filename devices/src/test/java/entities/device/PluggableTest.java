package test.java.entities.device;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.java.entities.device.Device;
import main.java.entities.device.DeviceFactory;

public class PluggableTest {

    private DeviceFactory factory;

    @Before
    public void setUp() {
        factory = new DeviceFactory();
    }

    @Test
    public void shouldBePluggedWhenPluggedIn() {
        Device device = factory.generateDevice();
        device.plugIn();
        assertTrue(device.isPlugged());
    }

    @Test
    public void shouldBeUnpluggedWhenUnplugged() {
        Device device = factory.generateDevice();
        device.unplug();
        assertFalse(device.isPlugged());
    }
}
