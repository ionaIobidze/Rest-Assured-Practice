package ge.tbcitacademy.tests;

import ge.tbcitacademy.models.Order;
import ge.tbcitacademy.models.Pet;
import ge.tbcitacademy.steps.PetStoreSteps;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PetStoreTests {
    private final PetStoreSteps petStoreSteps = new PetStoreSteps();

    @Test
    public void testCreateOrder() {
        Order order = Order.builder()
                .id(1L)
                .petId(2L)
                .quantity(1)
                .shipDate("2023-05-15T13:45:30.000Z")
                .status("placed")
                .complete(true)
                .build();

        Response response = petStoreSteps.createOrder(order);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void addAndValidatePet() {
        Pet pet = new Pet();
        pet.setId(12345);
        pet.setName("Buddy");
        pet.setStatus("available");

        Response response = petStoreSteps.addPetAndValidate(pet);
        assertEquals(response.getStatusCode(), 200);
    }
}
