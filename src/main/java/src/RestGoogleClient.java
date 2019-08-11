package src;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.GooglePlace;
import model.Result;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RestGoogleClient {

    public static void main(String[] args) throws IOException {

        URL urlGoogleClient = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=52.229770,21.011780&radius=50000&types=food&name=harbour&key=AIzaSyBTWia-ijvdYv9Bzt6qobq3UHJqUJL3nfY");
        InputStreamReader reader = new InputStreamReader(urlGoogleClient.openStream());
        GooglePlace googlePlace = new Gson().fromJson(reader,GooglePlace.class);

        for (Result result : googlePlace.getResults()) {
            System.out.println(result.getName());
        }

        System.out.println(googlePlace);

    }

}