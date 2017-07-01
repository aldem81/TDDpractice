package main.java.entities.enclosedarea;

import java.util.List;

import main.java.entities.device.Device;

class Apartment implements EnclosedArea {

    private List<Device> devices;

    public Apartment(List<Device> devices) {
        this.devices = devices;
    }

    // container logic
    @Override
    public boolean contains(Device device) {
        return devices.contains(device);
    }

    @Override
    public int getNumberOfDevices() {
        return devices.size();
    }

    @Override
    public Device getDeviceById(Integer id){
        Device result = null;
        for (Device device : devices) {
            if (device.getId() == id) {
                result = device;
            }
        }
        return result;
    }

    @Override
    public List<Device> getAllDevices() { // ???? deep copy needed????
        return this.devices; // when makng deep copy, a problem with id increment should be solved, otherwise we lose ids due to devices copies generation
    }

    @Override
    public void addDevice(final Device device) {
        devices.add(device);
    }

    @Override
    public void addDevices(final List<Device> devices) {
        this.devices.addAll(devices);
    }

    @Override
    public void clear() {
        devices.clear();
    }

    @Override
    public void removeDevice(final Device device) {
        devices.remove(device);
    }

    @Override
    public void removeDeviceById(final Integer id) {
        for (Device device : devices) {
            if (device.getId() == id) {
                removeDevice(device);
            }
        }
    }

    @Override
    public void removeDevices(final List<Device> devices) {
        this.devices.removeAll(devices);
    }
}
