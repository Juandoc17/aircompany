package Planes;

import java.util.Objects;

/**
 * PassengerPlane class extends the base Plane class and adds passenger capacity as a specific feature.
 * This class represents planes mainly used for transporting passengers. It includes functionality
 * to store and retrieve the plane's passenger capacity.
 *
 * Changes and Improvements:
 * 1. Added comprehensive comments to describe parameters in the constructor and the method 'getPassengersCapacity'.
 * 2. Enhanced the 'toString' method to clearly represent all properties of the plane including the passengersCapacity.
 * 3. Improved coherence in the 'equals' and 'hashCode' methods to involve passengersCapacity, ensuring uniqueness based on this attribute.
 */
public class PassengerPlane extends Plane {

    private int passengersCapacity;

    /**
     * Constructs a PassengerPlane with specified parameters along with passenger capacity.
     *
     * @param model The model of the plane.
     * @param maxSpeed The maximum speed of the plane in kilometers per hour.
     * @param maxFlightDistance The maximum distance the plane can fly without refueling.
     * @param maxLoadCapacity The maximum load capacity of the plane in kilograms.
     * @param passengersCapacity The seating capacity of the plane.
     */
    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    /**
     * Returns the passenger capacity of the plane.
     *
     * @return The seating capacity.
     */
    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return "PassengerPlane{" +
                "model='" + getModel() + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                ", maxFlightDistance=" + getMaxFlightDistance() +
                ", maxLoadCapacity=" + getMaxLoadCapacity() +
                ", passengersCapacity=" + passengersCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerPlane)) return false;
        if (!super.equals(o)) return false;
        PassengerPlane plane = (PassengerPlane) o;
        return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}