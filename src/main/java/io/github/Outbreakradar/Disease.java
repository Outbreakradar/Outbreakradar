package io.github.Outbreakradar;
import com.google.gson.Gson;

import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import java.util.Arrays;

public class Disease {
    String name;
    String[] symptoms;
    String[] treatments;
    Disease(String name,String[] symptoms,String[] treatments)
    {
        this.name=name;
        this.symptoms=symptoms;
        this.treatments=treatments;
    }
    void fetchDetails() throws IOException,InterruptedException
   {
       if(this.symptoms !=null && this.treatments!=null)
       {
           return;
       }
       HttpClient client = HttpClient.newHttpClient();

       String jsonInput = "{\"name\":\""+this.name.toLowerCase()+"\"}";

       HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create("https://matqlwjthgrctmwpsfsu.supabase.co/functions/v1/fetchDiseaseDetails"))
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
       this.name=d1.name;
       this.symptoms= d1.symptoms;
       this.treatments= d1.treatments;

   }

}
