import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDay {
    @JsonProperty("Date")
    private String Date;
    @JsonProperty("Temperature")
    private Temperature TemperatureObject;

    public ForecastDay() {
    }

    public String getDate() {
        return Date;
    }

    public Temperature getTemperature() {
        return TemperatureObject;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setTemperature(Temperature TemperatureObject) {
        this.TemperatureObject = TemperatureObject;
    }

    @Override
    public String toString() {
        return "ForecastDay{" +
                "Date='" + Date + '\'' +
                ", TemperatureObject=" + TemperatureObject +
                '}';
    }
}