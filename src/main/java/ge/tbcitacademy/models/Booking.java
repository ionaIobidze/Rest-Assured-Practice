package ge.tbcitacademy.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Booking {
    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    private Integer totalprice;
    private Boolean depositpaid;

    @JsonProperty("bookingdates")
    private BookingDates bookingDates;

    private String additionalneeds;
    private transient Double saleprice;
    private String passportNo;
}


