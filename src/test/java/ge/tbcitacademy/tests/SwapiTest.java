package ge.tbcitacademy.tests;

import ge.tbcitacademy.models.Planet;
import ge.tbcitacademy.steps.SwapiSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class SwapiTest {

    private SwapiSteps swapiSteps = new SwapiSteps();

    @Test
    @Description("Test to validate planets API")
    public void testPlanetsApi() throws Exception {
        Response response = swapiSteps.swapiPage.getAllPlanets();
        List<Planet> planets = swapiSteps.deserializePlanetsResponse(response);
        List<Planet> recentPlanets = swapiSteps.getThreeMostRecentPlanets(planets);

        validatePlanetFields(recentPlanets.get(0));

        Planet longestRotationPlanet = swapiSteps.getPlanetWithLongestRotationPeriod(planets);
        Response residentResponse = swapiSteps.swapiPage.getResidentByUrl(longestRotationPlanet.getResidents()[0]);

        assertNotNull(residentResponse.getBody());
    }

    @Step("Validate planet fields")
    public void validatePlanetFields(Planet planet) {
        assertNotNull(planet.getName());
        assertNotNull(planet.getRotation_period());
        assertNotNull(planet.getDiameter());
        assertNotNull(planet.getClimate());
        assertNotNull(planet.getGravity());
    }
}