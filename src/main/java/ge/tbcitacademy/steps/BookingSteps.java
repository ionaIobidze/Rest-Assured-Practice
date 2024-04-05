package ge.tbcitacademy.steps;


import ge.tbcitacademy.models.Booking;
import ge.tbcitacademy.pages.BookingPage;
import io.restassured.response.Response;

public class BookingSteps {
    private final BookingPage bookingPage = new BookingPage();

    public Response createBooking(Booking booking) {
        return bookingPage.createBooking(booking);
    }

    public Response updateBooking(int bookingId, Booking booking, String token) {
        return bookingPage.updateBooking(bookingId, booking, token);
    }

    public String getAuthToken(String username, String password) {
        Response response = bookingPage.authenticate(username, password);
        return response.jsonPath().getString("token");
    }
}