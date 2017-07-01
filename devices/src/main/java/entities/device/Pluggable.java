package main.java.entities.device;

/**
 * Plug-in devices.
 *
 * @author leshak
 *
 */
public interface Pluggable {

    /**
     * Plugging device in.
     */
    void plugIn();

    /**
     * Unplugging device.
     */
    void unplug();

    /**
     * Checking whether a device is plugged.
     *
     * @return  isPlugged
     */
    boolean isPlugged();
}
