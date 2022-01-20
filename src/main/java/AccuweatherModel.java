import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Iterator;

public class AccuweatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "pD1iEnQ9ftS0FqfR2DByTcp7CnrKf9Kj";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String LANGUAGE = "ru-ru";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter("language", "ru-ru")
                        .addQueryParameter("metric", "true")
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                //System.out.println(weatherResponse);
                //TODO: сделать человекочитаемый вывод погоды. Выбрать параметры для вывода на свое усмотрение
                //Например: Погода в городе Москва - 5 градусов по цельсию Expect showers late Monday night

                System.out.println("В городе - " + selectedCity);
                forecastDaysAsText(weatherResponse);
                break;

            case FIVE_DAYS:
                HttpUrl httpUrl5days = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter("language", "ru-ru")
                        .addQueryParameter("metric", "true")
                        .build();

                Request request5days = new Request.Builder()
                        .url(httpUrl5days)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(request5days).execute();
                String weatherResponse5days = fiveDayForecastResponse.body().string();
                //System.out.println(weatherResponse5days);

                System.out.println("В городе - " + selectedCity);
                forecastDaysAsText(weatherResponse5days);
                break;
        }
    }

    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .addQueryParameter("language", LANGUAGE)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();
        //System.out.println(responseString);

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }

    private void forecastDaysAsText(String weatherResponse) throws JsonProcessingException {
        Iterator<JsonNode> forecastDaysJSON = objectMapper
                .readTree(weatherResponse)
                .at("/DailyForecasts")
                .iterator();

        while (forecastDaysJSON.hasNext()){
            String forecastDayJSON = forecastDaysJSON.next().toString();
            ForecastDay forecastDayFromJSON = objectMapper.readValue(forecastDayJSON, ForecastDay.class);
            System.out.println("Погода на " + forecastDayFromJSON.getDate().substring(0,10) + ":\n" +
                    "\t" + "Минимальная температура: " + forecastDayFromJSON.getTemperature().getMinimum().getValue() +
                    " " + forecastDayFromJSON.getTemperature().getMinimum().getUnit()+ "\n" +
                    "\t" + "Максимальная температура: " + forecastDayFromJSON.getTemperature().getMaximum().getValue() +
                    " " + forecastDayFromJSON.getTemperature().getMaximum().getUnit());
        }
    }
}