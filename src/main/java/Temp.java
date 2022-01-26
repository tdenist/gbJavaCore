import java.sql.*;

public class Temp {

    public static void main(String[] args) {

        String DB_PATH = "jdbc:sqlite:weather.db";
        String getForecast = "select * from weather";
        String insertForecast = "insert into weather (city, localdate, mintemp, maxtemp) values (?, ?, ?, ?)";

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(DB_PATH)){

            Statement statement = connection.createStatement();
            System.out.println(statement.executeQuery("SELECT name FROM sqlite_master"));

            PreparedStatement saveForecast = connection.prepareStatement(insertForecast);

            saveForecast.setString(1, "Москва");
            saveForecast.setString(2, "2022-01-25");
            saveForecast.setDouble(3, -2);
            saveForecast.setDouble(4, 0);

            saveForecast.execute();

            connection.createStatement();
            System.out.println(statement.executeQuery(getForecast));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
