package Planes;

/**
 * MyPlane class extends Plane for custom plane types. 
 * As of now, it behaves like the general Plane, but can be extended with more unique attributes and methods.
 * 
 * Changes and remarks:
 * 1. Basic structure with essential Plane parameters has been set up.
 */
public class MyPlane extends Plane {
    
    /**
     * Constructs a new instance of MyPlane.
     * 
     * @param model              the model of the plane.
     * @param maxSpeed           the maximum speed of the plane in kilometers per hour.
     * @param maxFlightDistance  the maximum flight distance of the plane in kilometers.
     * @param maxLoadCapacity    the maximum load capacity of the plane in kilograms.
     */
    public MyPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}