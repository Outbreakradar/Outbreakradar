package io.github.Outbreakradar;
import com.google.gson.Gson;

import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import java.net.http.HttpClient;
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
    Outbreak[] fetchOutbreakFromBackend()throws IOException,InterruptedException
    {
        Outbreak[] o = new Outbreak[100];
        int count=0;
        HttpClient client = HttpClient.newHttpClient();
        String jsonInput = "{\"location\":\""+"Kerala"+"\"}";
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
        Disease d1=gson.fromJson(newRes,Disease.class);

        return o;
    }





}
