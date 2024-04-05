package ge.tbcitacademy.pages;


import static ge.tbcitacademy.data.Constants.BASE_URL1;
import static io.restassured.RestAssured.given;

import ge.tbcitacademy.models.Booking;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookingPage {

    public Response createBooking(Booking booking) {
        return given()
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post(BASE_URL1 + "/booking")
                .then()
                .extract()
                .response();
    }

    public Response updateBooking(int bookingId, Booking booking, String token) {
        return given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .body(booking)
                .when()
                .put(BASE_URL1 + "/booking/" + bookingId)
                .then()
                .extract()
                .response();
    }

    public Response authenticate(String username, String password) {
        return given()
                .contentType(ContentType.JSON)
                .body("{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}")
                .when()
                .post(BASE_URL1 + "/auth")
                .then()
                .extract()
                .response();
    }
}