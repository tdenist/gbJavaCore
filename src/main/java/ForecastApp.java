import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ForecastApp {

    public static void main(String[] args) throws IOException, ParseException {

        OkHttpClient client = new OkHttpClient();

        HttpUrl urlLacation = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("locations/v1/cities/search")
                .addQueryParameter("apikey","RgGbfDeDWGqJarvtON2i7NjkMbGlSgDL")
                .addQueryParameter("q", "Кострома")
                .build();

        System.out.println(urlLacation);

        Request requestlocation = new Request.Builder()
                .url(urlLacation)
                .build();

        Response response = client.newCall(requestlocation).execute();

        String body = response.body().string();
        System.out.println(body);

        body = body.substring(1, body.length() - 1); //удаляю квадратнаые скобки

        JSONObject jsonObjectBody = (JSONObject) new JSONParser().parse(body);
        System.out.println(jsonObjectBody);
        String lacationKey = (String) jsonObjectBody.get("Key");

        HttpUrl urlForecast = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("forecasts/v1/daily/5day/")
                .addPathSegment(lacationKey)
                //.addPathSegment("293552")
                .addQueryParameter("apikey","RgGbfDeDWGqJarvtON2i7NjkMbGlSgDL")
                .addQueryParameter("language","ru-ru")
                .addQueryParameter("metric","true")
                .build();

        System.out.println(urlForecast);

        Request requestForecast = new Request.Builder()
                .url(urlForecast)
                .build();

        response = client.newCall(requestForecast).execute();

        System.out.println(response.body().string());
    }
}
