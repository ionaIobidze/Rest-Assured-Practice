package ge.tbcitacademy.tests;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import ge.tbcitacademy.steps.FakerApiSteps;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class FakerApiTests {
    private final FakerApiSteps fakerApiSteps = new FakerApiSteps();

    @Test
    public void validateCreditCardSchema() {
        Response response = fakerApiSteps.getCreditCards(2);

        String schema = "{\n" +
                "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\n" +
                "  \"type\": \"object\",\n" +
                "  \"properties\": {\n" +
                "    \"data\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": {\n" +
                "        \"type\": \"object\",\n" +
                "        \"properties\": {\n" +
                "          \"number\": {\"type\": \"string\"},\n" +
                "          \"expiration\": {\"type\": \"string\"},\n" +
                "          \"pin\": {\"type\": \"string\"},\n" +
                "          \"owner\": {\"type\": \"string\", \"pattern\": \".{2,}\"},\n" +
                "          \"status\": {\"type\": \"string\", \"pattern\": \"OK\"}\n" +
                "        },\n" +
                "        \"required\": [\"number\", \"expiration\", \"pin\", \"owner\", \"status\"]\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"required\": [\"data\"]\n" +
                "}";

        assertThat(response.getBody().asString(), JsonSchemaValidator.matchesJsonSchema(schema));
    }
}