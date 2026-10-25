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

    public static Outbreak testOutbreak() {
        Location[] locations = new Location[] {Location.testLocation(), Location.testLocation()};
        Disease d = new Disease("dengue", null, null);

        return new Outbreak(locations, d, "Given info is fake and only for testing purposes");
    }

    public void print() {
        System.out.println(disease.name);
        for (Location l : locations) {
            System.out.print(l.place + " ");
        }
    }
}
