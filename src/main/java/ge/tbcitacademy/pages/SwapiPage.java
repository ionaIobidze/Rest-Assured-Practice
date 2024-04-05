package ge.tbcitacademy.pages;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static ge.tbcitacademy.data.Constants.BASE_URL4;

public class SwapiPage {

    private RequestSpecification requestSpecification;

    public SwapiPage() {
        RestAssured.baseURI = BASE_URL4;
        requestSpecification = RestAssured.given().baseUri(RestAssured.baseURI);
    }

    @Step("Get all planets")
    public Response getAllPlanets() {
        return requestSpecification
                .queryParam("format", "json")
                .get("/planets/");
    }

    @Step("Get resident by URL: {url}")
    public Response getResidentByUrl(String url) {
        return requestSpecification.get(url);
    }
}
