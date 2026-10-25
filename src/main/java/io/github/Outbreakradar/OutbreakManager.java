package io.github.Outbreakradar;
import com.google.gson.Gson;

import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OutbreakManager {
    HashMap<String, Outbreak[]> outbreaks;


    public OutbreakManager() {
        outbreaks = new HashMap<>();
    }
    // Only for testing purposes
//    Outbreak[] testFetchOutbreaksFromBackend() {
//        outbreaks = new Outbreak[] {};
//
//        ArrayList<Outbreak> o = new ArrayList<>();
//
//        o.add(Outbreak.testOutbreak());
//        o.add(Outbreak.testOutbreak());
//        o.add(Outbreak.testOutbreak());
//
//        outbreaks = o.toArray(outbreaks);
//        return outbreaks;
//    }

    Outbreak[] fetchOutbreakFromBackend(String state)throws IOException,InterruptedException
    {

        if (outbreaks.containsKey(state)) {
            return outbreaks.get(state);
        }

        List<Outbreak> o = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        String jsonInput = "{\"location\":\""+state+"\"}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://matqlwjthgrctmwpsfsu.supabase.co/functions/v1/smooth-function"))
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im1hdHFsd2p0aGdyY3Rtd3BzZnN1Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTY1NjU0OTcsImV4cCI6MjA3MjE0MTQ5N30.PG8KcynbjKbLXEMpA7eOjZkVgwp2pxML_bhMoXmlFjk")
                .POST(HttpRequest.BodyPublishers.ofString(jsonInput))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body: " + response.body());
        String res=response.body();
        String newRes=res.substring(1,res.length()-1);

        Gson gson = new Gson();
        OutbreakJson[] outbreakJsons = gson.fromJson(res, OutbreakJson[].class);

        for (OutbreakJson oj : outbreakJsons) {

//            System.out.println("DISEASE NAME: " + oj.diseaseName);

            Location[] locations = new Location[oj.outbreakLocations.length];
            for (int j = 0; j < oj.outbreakLocations.length; j++) {
                locations[j] = new Location("India", state, oj.outbreakLocations[j]);
            }

            Disease d = new Disease(oj.diseaseName, null, null);

            Outbreak i = new Outbreak(locations, d, oj.description);
            o.add(i);

//            i.print();
//            System.out.println();
        }

        Outbreak[] oArray = o.toArray(new Outbreak[0]);
        outbreaks.put(state, oArray);
        return oArray;
    }





}
