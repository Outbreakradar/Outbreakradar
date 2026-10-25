package io.github.Outbreakradar;

public class OutbreakJson {
    String diseaseName;
    String[] outbreakLocations;
    String description;

    public OutbreakJson(String diseaseName,String[] outbreakLocations, String description) {
        this.diseaseName = diseaseName;
        this.outbreakLocations = outbreakLocations;
        this.description = description;
    }
}
