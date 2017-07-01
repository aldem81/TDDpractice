package main.java.entities.enclosedarea;

import java.util.List;

import main.java.entities.device.Device;
import main.java.entities.device.DeviceFactory;

/**
 * Factory.
 *
 * @author leshak
 *
 */
public class EnclosedAreaFactory {

    private DeviceFactory factory = new DeviceFactory(); // TODO = may be use DI

    public EnclosedArea generateAreatWithoutDevices() {
        List<Device> devices = factory.generateDevicesInQuantityOf(0);
        return new Apartment(devices);
    }

    public EnclosedArea generateAreaWithRandomDevicesInNumberOf(final int number) {
        List<Device> devices = factory.generateDevicesInQuantityOf(number);
        return new Apartment(devices);
    }
}
