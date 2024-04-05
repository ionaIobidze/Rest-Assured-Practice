package ge.tbcitacademy.pages;

import ge.tbcitacademy.models.Order;
import ge.tbcitacademy.models.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static ge.tbcitacademy.data.Constants.BASE_URL3;
import static io.restassured.RestAssured.given;

public class PetStorePage {


    public Response createOrder(Order order) {
        return given()
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post(BASE_URL3 + "/store/order")
                .then()
                .extract()
                .response();
    }

    public Response addPet(Pet pet) {
        return given()
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
                .body(pet)
                .when()
                .post(BASE_URL3 + "/pet")
                .then()
                .extract()
                .response();
    }

    public Response getPet(long petId) {
        return given()
                .accept(ContentType.XML)
                .when()
                .get(BASE_URL3 + "/pet/" + petId)
                .then()
                .extract()
                .response();
    }
}
