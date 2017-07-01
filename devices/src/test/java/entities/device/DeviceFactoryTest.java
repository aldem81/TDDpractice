package test.java.entities.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.entities.device.Device;
import main.java.entities.device.DeviceFactory;

public class DeviceFactoryTest {

    private DeviceFactory factory;

    @Before
    public void setUp() {
        factory = new DeviceFactory();
    }

    @Test
    public void shouldGenerateDevicesWithSequentialDeviceIds() {
        Device deviceIdOne = factory.generateDevice();
        Device deviceIdTwo = factory.generateDevice();
        Device deviceIdThree = factory.generateDevice();
        assertEquals((Integer)(deviceIdOne.getId() + 1), deviceIdTwo.getId());
        assertEquals((Integer)(deviceIdOne.getId() + 2), deviceIdThree.getId());
    }

    @Test
    public void shouldGenerateDeviceWithAllFieldsWhenRequested() {
        Device device = factory.generateDevice();
        assertNotNull(device.getId());
        assertNotNull(device.getModel());
        assertNotNull(device.getPower());
    }

    @Test
    public void shouldGenerateZeroDevicesWhenRequestedZero() {
        List<Device> devices = factory.generateDevicesInQuantityOf(0);
        assertEquals(0, devices.size());
    }

    @Test
    public void shouldGenerateZeroDevicesWhenNegativeNumberRequested() {
        List<Device> devices = factory.generateDevicesInQuantityOf(-2);
        assertEquals(0, devices.size());
    }

    @Test
    public void shouldGenerateRequestedNumberOfDevices() {
        List<Device> devices = factory.generateDevicesInQuantityOf(3);
        assertEquals(3, devices.size());
        devices = factory.generateDevicesInQuantityOf(5);
        assertEquals(5, devices.size());
    }

    @Test
    public void shouldGenerateUnpluggedDevice() {
        Device device = factory.generateDevice();
        assertFalse(device.isPlugged());
    }
}

