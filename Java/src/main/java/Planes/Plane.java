package Planes;

import java.util.Objects;

/**
 * Abstract class representing a general Plane.
 * Changes made:
 * - Improved method naming to follow Java conventions.
 * - Removed redundant getter for load capacity that just returned a field value without modifications.
 * - Ensured all fields are private and provided appropriate public getters to maintain encapsulation.
 * */
public abstract class Plane {
    private String model;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    @Override
    public String toString() {
        return String.format("Plane{model='%s', maxSpeed=%d, maxFlightDistance=%d, maxLoadCapacity=%d}",
                             model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        if (o == null || getClass() != o.getClass()) 
            return false;
        Plane plane = (Plane) o;
        return maxSpeed == plane.maxSpeed &&
               maxFlightDistance == plane.maxFlightDistance &&
               maxLoadCapacity == plane.maxLoadCapacity &&
               Objects.equals(model, plane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}