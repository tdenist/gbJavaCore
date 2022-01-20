import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Maximum {
    @JsonProperty("Value")
    private Double Value;
    @JsonProperty("Unit")
    private String Unit;

    public Maximum() {
    }

    public Double getValue() {
        return Value;
    }

    public void setValue(Double value) {
        Value = value;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    @Override
    public String toString() {
        return "Maximum{" +
                "Value=" + Value +
                ", Unit='" + Unit + '\'' +
                '}';
    }
}
