package ge.tbcitacademy.models;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class Planet {
    private String name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    private String[] residents;
    private String[] films;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private String created;

    private String edited;
    private String url;

}