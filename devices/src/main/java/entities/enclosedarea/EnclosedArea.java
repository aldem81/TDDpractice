package main.java.entities.enclosedarea;

import java.util.List;

import main.java.entities.device.Device;

public interface EnclosedArea {

    boolean contains(Device device);
    int getNumberOfDevices();
    Device getDeviceById(Integer id);
    List<Device> getAllDevices();
    void addDevice(Device device);
    void addDevices(List<Device> devices);
    void clear();
    void removeDevice(Device device);
    void removeDeviceById(Integer id);
    void removeDevices(List<Device> devices);
}
