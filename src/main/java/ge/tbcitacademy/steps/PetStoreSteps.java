package ge.tbcitacademy.steps;

import ge.tbcitacademy.models.Order;
import ge.tbcitacademy.models.Pet;
import ge.tbcitacademy.pages.PetStorePage;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PetStoreSteps {
    private final PetStorePage petStorePage = new PetStorePage();

    public Response createOrder(Order order) {
        return petStorePage.createOrder(order);
    }

    public Response addPet(Pet pet) {
        return petStorePage.addPet(pet);
    }

    public Response getPet(long petId) {
        return petStorePage.getPet(petId);
    }

    public Response addPetAndValidate(Pet pet) {
        Response response = addPet(pet);
        validateAddedPet(response, pet);
        return response;
    }

    private void validateAddedPet(Response response, Pet expectedPet) {
        Pet createdPet = response.as(Pet.class);
        assertNotNull(createdPet);
        assertEquals(createdPet.getId(), expectedPet.getId());
        assertEquals(createdPet.getName(), expectedPet.getName());
        assertEquals(createdPet.getStatus(), expectedPet.getStatus());
    }
}
