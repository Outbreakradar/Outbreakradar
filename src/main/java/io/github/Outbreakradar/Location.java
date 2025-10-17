package io.github.Outbreakradar;

public class Location {
    String country;
    String state;
    String place;

    Location(String country,String state,String place)
    {
        this.country=country;
        this.state=state;
        this.place=place;
    }

    public static Location testLocation() {
        return new Location("India", "Kerala", "Mookkannoor");
    }
}
