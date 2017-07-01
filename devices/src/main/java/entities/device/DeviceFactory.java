package main.java.entities.device;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Factory.
 *
 * @author leshak
 *
 */
public class DeviceFactory {

    private static Integer idCounter = 0;
    private static Map<Integer, String> devices = new HashMap<>();

    static {
        devices.put(1, "Computer");
        devices.put(2, "Fridge");
        devices.put(3, "Microwave");
        devices.put(4, "Lamp");
    }

    public List<Device> generateDevicesInQuantityOf(int quantity) {
        List<Device> devices = new ArrayList<>(quantity < 0 ? 0 : quantity);
        for (int i = 0; i < quantity; i++) {
            devices.add(generateDevice());
        }
        return devices;
    }

    public Device generateDevice() {

        Device device = (Device)generateRandomSubClass();

        setProperties(device);

        return device;
    }

    private Object generateRandomSubClass() { //refactor

        Random random = new Random();
        int i = random.nextInt(devices.size());

        //Constructor<?> cons = null;
        Object object = null;

        try {
            Class<?> c = Class.forName("main.java.entities.device." + devices.get(i + 1)); // TODO
            //cons = c.getConstructor(String.class);
            //object = cons.newInstance();
            object = c.newInstance();
        } catch (Exception e) { // TODO
            // TODO
            e.printStackTrace();
        }

        return object;
    }

    private void setProperties(Device device) {
        device.setId(++idCounter);
        device.setModel(generateModel());
        device.setPower(generatePower());
    }

    private String generateModel() {
        //TODO
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 7;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)(random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString.toUpperCase();
    }

    private Integer generatePower() {
        Random random = new Random();
        return 100 + random.nextInt(900);
    }
}
