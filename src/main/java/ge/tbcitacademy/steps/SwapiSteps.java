package ge.tbcitacademy.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import ge.tbcitacademy.models.Planet;
import ge.tbcitacademy.models.PlanetResponse;
import ge.tbcitacademy.pages.SwapiPage;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class SwapiSteps {

    public SwapiPage swapiPage = new SwapiPage();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Step("Deserialize planets response")
    public List<Planet> deserializePlanetsResponse(Response response) throws Exception {
        String jsonString = response.getBody().asString();
        PlanetResponse planetResponse = objectMapper.readValue(jsonString, PlanetResponse.class);
        return planetResponse.getResults();
    }

    @Step("Get three most recent planets")
    public List<Planet> getThreeMostRecentPlanets(List<Planet> planets) {
        return planets.stream()
                .sorted(Comparator.comparing(Planet::getCreated).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    @Step("Get planet with the longest rotation period")
    public Planet getPlanetWithLongestRotationPeriod(List<Planet> planets) {
        return planets.stream()
                .max(Comparator.comparingInt(planet -> Integer.parseInt(planet.getRotation_period())))
                .orElseThrow(() -> new RuntimeException("No planets found"));
    }
}