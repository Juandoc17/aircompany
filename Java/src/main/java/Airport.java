import Planes.ExperimentalPlane;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import models.MilitaryType;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Airport class to manage the operations related to planes.
 * CHANGES:
 * - Code cleaned to remove unnecessary comments and improve readability.
 * - Used Java 8 features for more concise and readable code.
 * - Method names have been improved for better readability.
 */
public class Airport {
    private List<Plane> planes;

    public Airport(List<Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream()
                     .filter(plane -> plane instanceof PassengerPlane)
                     .map(plane -> (PassengerPlane) plane)
                     .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream()
                     .filter(plane -> plane instanceof MilitaryPlane)
                     .map(plane -> (MilitaryPlane) plane)
                     .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream()
                     .filter(plane -> plane instanceof ExperimentalPlane)
                     .map(plane -> (ExperimentalPlane) plane)
                     .collect(Collectors.toList());
    }

    public PassengerPlane getPlaneWithMaxPassengerCapacity() {
        return getPassengerPlanes().stream()
                     .max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity))
                     .orElseThrow(NoSuchElementException::new);
    }

    public Airport sortByMaxDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
        return this;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
    return this.getMilitaryPlanes().stream()
        .filter(plane -> plane.getType() == MilitaryType.TRANSPORT)
        .collect(Collectors.toList());
   }

   public List<MilitaryPlane> getBomberMilitaryPlanes() {
    return this.getMilitaryPlanes().stream()
        .filter(plane -> plane.getType() == MilitaryType.BOMBER)
        .collect(Collectors.toList()); 
   }

   public List<Plane> getPlanes() {
    return planes;
   }

    @Override
    public String toString() {
        return planes.stream()
                     .map(Plane::toString)
                     .collect(Collectors.joining(", ", "Airport{planes=[", "]}"));
    }
}