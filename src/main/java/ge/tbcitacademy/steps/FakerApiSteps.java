package ge.tbcitacademy.steps;

import io.restassured.response.Response;
import ge.tbcitacademy.pages.FakerApiPage;

public class FakerApiSteps {
    private final FakerApiPage fakerApiPage = new FakerApiPage();

    public Response getCreditCards(int quantity) {
        return fakerApiPage.getCreditCards(quantity);
    }
}