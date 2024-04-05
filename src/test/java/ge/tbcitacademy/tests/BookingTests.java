package ge.tbcitacademy.tests;

import ge.tbcitacademy.models.Booking;
import ge.tbcitacademy.models.BookingDates;
import ge.tbcitacademy.steps.BookingSteps;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static ge.tbcitacademy.data.Constants.*;
import static org.testng.Assert.assertEquals;

public class BookingTests {
    private final BookingSteps bookingSteps = new BookingSteps();
    private String token;

    @BeforeClass
    public void setUp() {
    token = bookingSteps.getAuthToken(USERNAME, PASSWORD);
    }

    @DataProvider(name = "bookingData")
    public Object[][] bookingData() {
        return new Object[][]{
                {Booking.builder()
                        .firstName(NAME1)
                        .lastName(LAST_NAME1)
                        .totalprice(TOTAL_PRISE1)
                        .depositpaid(true)
                        .bookingDates(new BookingDates(CHECK_IN_DATE1, CHECK_OUT_DATE1))
                        .additionalneeds(BREAKFAST)
                        .passportNo(null)
                        .build()},
                {Booking.builder()
                        .firstName(NAME2)
                        .lastName(LAST_NAME2)
                        .totalprice(456)
                        .depositpaid(false)
                        .bookingDates(new BookingDates(CHECK_IN_DATE2, CHECK_OUT_DATE2))
                        .additionalneeds(DINNER)
                        .passportNo(null)
                        .build()}
        };
    }

    @Test(dataProvider = "bookingData")
    public void testUpdateBooking(Booking booking) {
        Response createResponse = bookingSteps.createBooking(booking);
        assertEquals(createResponse.getStatusCode(), 200);

        int bookingId = createResponse.jsonPath().getInt("bookingid");

        booking.setAdditionalneeds("Updated Breakfast");
        Response updateResponse = bookingSteps.updateBooking(bookingId, booking, token);
        assertEquals(updateResponse.getStatusCode(), 200);
        assertEquals(updateResponse.jsonPath().getString("firstname"), booking.getFirstName());
        assertEquals(updateResponse.jsonPath().getString("additionalneeds"), "Updated Breakfast");
    }
}