import Planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.Arrays;
import java.util.List;

/**
 * AirportTest class tests the functionality of the Airport class, ensuring it manages planes correctly.
 *
 * Changes made:
 * 1. Implemented missing methods in the Airport class necessary for filtering and retrieving specific types of planes.
 * 2. Corrected and clarified test methods to accurately reflect the tested functionality and ensure the consistency of method calls.
 * 3. Enhanced assertion messages within tests for clearer understanding of test failures.
 * 4. Utilized Java Stream API for more concise and readable test validation conditions.
 */
public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
        // Instances of various planes...
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        Assert.assertTrue(transportMilitaryPlanes.stream()
            .allMatch(plane -> plane.getType() == MilitaryType.TRANSPORT),
            "Should be transport planes.");
    }

    @Test
    public void testGetPlaneWithMaxPassengerCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlane = airport.getPlaneWithMaxPassengerCapacity();
        Assert.assertEquals(expectedPlane, planeWithMaxPassengerCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<Plane> sortedPlanes = airport.getPlanes();

        boolean isSortedCorrectly = true;
        for (int i = 0; i < sortedPlanes.size() - 1; i++) {
            if (sortedPlanes.get(i).getMaxLoadCapacity() > sortedPlanes.get(i + 1).getMaxLoadCapacity()) {
                isSortedCorrectly = false;
                break;
            }
        }
        Assert.assertTrue(isSortedCorrectly, "Planes should be sorted by max load capacity from least to greatest.");
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        Assert.assertTrue(bomberMilitaryPlanes.size() > 0, "No bombers found among military planes.");
    }

    @Test
    public void testExperimentalPlanesClassificationLevel() {
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        Assert.assertFalse(experimentalPlanes.stream()
            .anyMatch(plane -> plane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED),
            "There should be no unclassified experimental planes.");
    }
}