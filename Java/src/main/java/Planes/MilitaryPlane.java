package Planes;

import models.MilitaryType;
import java.util.Objects;

/**
 * This class extends Plane to represent Military Planes with specific type attributes.
 * Enhancements and changes include:
 * 1. Ensured the class is named and encapsulated correctly.
 * 2. Added a setter for the 'type' property for better encapsulation.
 * 3. Overridden equals, hashCode, and toString methods are improved for better functionality and readability.
 */
public class MilitaryPlane extends Plane {

    private MilitaryType type;

    // Constructor ensures all planes have defined properties set upon instantiation
    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
    }

    // Getter for type
    public MilitaryType getType() {
        return type;
    }

    // Setter for type to allow changes if necessary
    public void setType(MilitaryType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        // Concisely append type information to Plane's toString output
        return "MilitaryPlane{" +
               "model='" + getModel() + '\'' +
               ", maxSpeed=" + getMaxSpeed() +
               ", maxFlightDistance=" + getMaxFlightDistance() +
               ", maxLoadCapacity=" + getMaxLoadCapacity() +
               ", type=" + type +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPlane)) return false;
        if (!super.equals(o)) return false;
        MilitaryPlane that = (MilitaryPlane) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        // Include type in the hash code computation to ensure consistency with equals
        return Objects.hash(super.hashCode(), type);
    }
}