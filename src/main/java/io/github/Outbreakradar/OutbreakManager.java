package io.github.Outbreakradar;

import java.util.ArrayList;

public class OutbreakManager {
    Outbreak[] outbreaks;

    // Only for testing purposes
    Outbreak[] testFetchOutbreaksFromBackend() {
        outbreaks = new Outbreak[] {};

        ArrayList<Outbreak> o = new ArrayList<>();

        o.add(Outbreak.testOutbreak());
        o.add(Outbreak.testOutbreak());
        o.add(Outbreak.testOutbreak());

        outbreaks = o.toArray(outbreaks);
        return outbreaks;
    }




}
