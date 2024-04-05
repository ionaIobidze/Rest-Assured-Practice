package ge.tbcitacademy.pages;


import io.restassured.RestAssured;
import io.restassured.response.Response;

import static ge.tbcitacademy.data.Constants.BASE_URL2;

public class FakerApiPage {


    public Response getCreditCards(int quantity) {
        return RestAssured
                .given()
                .queryParam("_quantity", quantity)
                .get(BASE_URL2);
    }
}
