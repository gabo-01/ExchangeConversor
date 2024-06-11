package fernando.Conversor.Request;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fernando.Conversor.Changes.Change;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request {

    public Change Request(String monedaOriginal, String monedaCambio, String cantidad ) throws IOException, InterruptedException {


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/419ce95a370f0825e046aebb/pair/"+monedaOriginal.toUpperCase()+"/"+monedaCambio.toUpperCase()+"/"+cantidad))
                .build();

        HttpResponse <String> response= client.send(request,HttpResponse.BodyHandlers.ofString());


        Gson gson= new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting().create();

        String json=response.body();

        Change changeexchange=gson.fromJson(json,Change.class);

        return changeexchange;
    }
}
