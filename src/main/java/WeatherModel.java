import entity.Forecast;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface WeatherModel {
    void getWeather(String selectedCity, Period period) throws IOException, SQLException;

    List<Forecast> getSavedToDBWeather(String city);
}
