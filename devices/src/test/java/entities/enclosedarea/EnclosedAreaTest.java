package test.java.entities.enclosedarea;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.entities.device.Device;
import main.java.entities.device.DeviceFactory;
import main.java.entities.enclosedarea.EnclosedArea;
import main.java.entities.enclosedarea.EnclosedAreaFactory;

public class EnclosedAreaTest {

    private EnclosedAreaFactory factory;
    private DeviceFactory deviceFactory;
    private EnclosedArea area;

    @Before
    public void setUp() {
        factory = new EnclosedAreaFactory();
        area = factory.generateAreatWithoutDevices();
        deviceFactory = new DeviceFactory();
    }

    @Test
    public void shouldContainDeviceAfterDeviceAdded() {
        Device d1 = deviceFactory.generateDevice();
        area.addDevice(d1);
        assertTrue(area.contains(d1));
    }

    @Test
    public void shouldContainDevicesAfterDevicesAdded() {
        Device d1 = deviceFactory.generateDevice();
        Device d2 = deviceFactory.generateDevice();
        Device d3 = deviceFactory.generateDevice();

        List<Device> devices = new ArrayList<>();
        devices.add(d1);
        devices.add(d2);
        devices.add(d3);
        area.addDevices(devices);

        assertTrue(area.contains(d1));
        assertTrue(area.contains(d2));
        assertTrue(area.contains(d3));
    }

    @Test
    public void shouldReturnCorrectNumberOfDevicesWhenDevicesAdded() {
        Device d1 = deviceFactory.generateDevice();
        Device d2 = deviceFactory.generateDevice();
        Device d3 = deviceFactory.generateDevice();
        area.addDevice(d1);
        area.addDevice(d2);
        area.addDevice(d3);
        assertEquals(3, area.getNumberOfDevices());
        Device d4 = deviceFactory.generateDevice();
        Device d5 = deviceFactory.generateDevice();
        area.addDevice(d4);
        area.addDevice(d5);
        assertEquals(5, area.getNumberOfDevices());
    }

    @Test
    public void shouldReturnCorrectNumberOfDevicesWhenDevicesRemoved() {
        Device d1 = deviceFactory.generateDevice();
        Device d2 = deviceFactory.generateDevice();
        Device d3 = deviceFactory.generateDevice();
        area.addDevice(d1);
        area.addDevice(d2);
        area.addDevice(d3);
        assertEquals(3, area.getNumberOfDevices());
        area.removeDevice(d2);
        assertEquals(2, area.getNumberOfDevices());
    }

    @Test
    public void shouldContaintNoDevicesWhenAreaCleared() {
        Device d1 = deviceFactory.generateDevice();
        Device d2 = deviceFactory.generateDevice();
        area.addDevice(d1);
        area.addDevice(d2);
        assertEquals(2, area.getNumberOfDevices());
        area.clear();
        assertEquals(0, area.getNumberOfDevices());
    }

    @Test
    public void shouldReturnRequiredDeviceWhenRequestedById() {
        Device device = deviceFactory.generateDevice();
        int id = device.getId();
        area.addDevice(device);
        Device requestedDevice = area.getDeviceById(id);
        assertEquals(device, requestedDevice);
    }

    @Test
    public void shoudlReturnNullWhenDeviceRequestedByIdNotFound() {
        Device requestedDevice = area.getDeviceById(-1);
        assertNull(requestedDevice);
    }

    @Test
    public void shouldReturnAllDevicesWhenRequested() {
        Device d1 = deviceFactory.generateDevice();
        Device d2 = deviceFactory.generateDevice();
        Device d3 = deviceFactory.generateDevice();
        area.addDevice(d1);
        area.addDevice(d2);
        area.addDevice(d3);
        List<Device> requested = area.getAllDevices();
        assertEquals(d1, requested.get(0));
        assertEquals(d2, requested.get(1));
        assertEquals(d3, requested.get(2));
    }

    @Test
    public void shouldRemoveRequestedDevice() {
        Device d1 = deviceFactory.generateDevice();
        Device d2 = deviceFactory.generateDevice();
        area.addDevice(d1);
        area.addDevice(d2);
        area.removeDevice(d1);
        assertFalse(area.contains(d1));
    }

    @Test
    public void shouldRemoveRequestedDeviceById() {
        Device d1 = deviceFactory.generateDevice();
        Device d2 = deviceFactory.generateDevice();
        area.addDevice(d1);
        area.addDevice(d2);
        area.removeDeviceById(d1.getId());
        assertFalse(area.contains(d1));
    }

    @Test
    public void shouldRemoveAllRequestedDevices() {
        Device d1 = deviceFactory.generateDevice();
        Device d2 = deviceFactory.generateDevice();
        Device d3 = deviceFactory.generateDevice();
        area.addDevice(d1);
        area.addDevice(d2);
        area.addDevice(d3);
        List<Device> requested = new ArrayList<>();
        requested.add(d1);
        requested.add(d3);
        area.removeDevices(requested);
        assertFalse(area.contains(d1));
        assertFalse(area.contains(d3));
    }
}

