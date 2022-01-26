import entity.Forecast;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {

    private static final  String DB_PATH = "jdbc:sqlite:weather.db";
    private String getForecastByCity = "select distinct localdate, mintemp, maxtemp from weather where city = ? order by localdate";
    private String insertForecast = "insert into weather (city, localdate, mintemp, maxtemp) values (?, ?, ?, ?)";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveForecastToDB(Forecast forecast) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DB_PATH)){

            PreparedStatement saveForecast = connection.prepareStatement(insertForecast);

            saveForecast.setString(1, forecast.getCity());
            saveForecast.setString(2, forecast.getLocalDate());
            saveForecast.setDouble(3, forecast.getMinTemp());
            saveForecast.setDouble(4, forecast.getMaxTemp());

            return saveForecast.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new SQLException("Сохранение в базу данных не выполнено!");
    }

    public int[] saveForecastToDB(List<Forecast> forecastList) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)){

            PreparedStatement saveForecast = connection.prepareStatement(insertForecast);

            for (Forecast forecast:forecastList) {

                saveForecast.setString(1, forecast.getCity());
                saveForecast.setString(2, forecast.getLocalDate());
                saveForecast.setDouble(3, forecast.getMinTemp());
                saveForecast.setDouble(4, forecast.getMaxTemp());

                saveForecast.addBatch();
            }
            return saveForecast.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new SQLException("Сохранение в базу данных не выполнено!");
    }

    public List<Forecast> getSavedToDBForecast(String city) {

        List<Forecast> forecastList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_PATH)){

            PreparedStatement statement = connection.prepareStatement(getForecastByCity);
            statement.setString(1, city);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("В городе - " + city);
            while (resultSet.next()){
                System.out.println("Погода на " + resultSet.getString("localdate").substring(0,10) + ":\n" +
                        "\t" + "Минимальная температура: " + resultSet.getDouble("mintemp") + "\n" +
                        "\t" + "Максимальная температура: " + resultSet.getDouble("maxtemp"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  forecastList;
    }
}
