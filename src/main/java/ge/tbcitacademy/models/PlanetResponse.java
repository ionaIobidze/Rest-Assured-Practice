package ge.tbcitacademy.models;

import lombok.Data;

import java.util.List;

@Data
public class PlanetResponse {
    private int count;
    private String next;
    private String previous;
    private List<Planet> results;
}

