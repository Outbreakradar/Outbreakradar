package io.github.Outbreakradar;

public class Outbreak {
    Location[] locations;
    Disease disease;
    String description;
    Outbreak(Location[] locations,Disease disease,String description)
    {
        this.locations=locations;
        this.disease=disease;
        this.description=description;
    }
}
