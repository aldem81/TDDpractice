package main.java.entities.device;

import java.util.Objects;

/**
 * Basic class for devices.
 *
 * @author leshak
 *
 */
public abstract class Device implements Pluggable {

    private Integer id;
    private String model;
    private Integer power;
    private boolean isPlugged;

    public Integer getId() {
        return this.id;
    }

    void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    void setModel(String model) {
        this.model = model;
    }

    public Integer getPower() {
        return this.power;
    }

    void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public void plugIn() {
        this.isPlugged = true;
    }

    @Override
    public void unplug() {
        this.isPlugged = false;
    }

    @Override
    public boolean isPlugged() {
        return this.isPlugged;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Device))
            return false;
        Device d = (Device)o;
        return d.id == id && d.model.equals(model) && d.power == power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, power);
    }

    @Override
    public String toString() {
        return String.format(this.getClass().getName() + ": id = " + getId() + ", model = " + getModel() + ", power = " + getPower());
    }
}
