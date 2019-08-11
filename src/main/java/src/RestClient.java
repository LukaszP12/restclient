package src;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RestClient {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://cat-fact.herokuapp.com/facts/random");
        InputStreamReader reader = new InputStreamReader(url.openStream());

        //GSON pozwala na zamiane JSON na obiekt
        CatFact catFact = new Gson().fromJson(reader, CatFact.class);
        System.out.println(catFact.getText());

        URL urlCatImage = new URL("https://aws.random.cat/meow");
        InputStreamReader readerCatImage = new InputStreamReader(urlCatImage.openStream());
        JsonObject jsonObject = new JsonParser().parse(readerCatImage).getAsJsonObject();
        System.out.println(jsonObject.get("file").getAsString()); // jezeli mamy pojedyncze pola to lepiej pobrac pojedyncza zmienna

    }
}