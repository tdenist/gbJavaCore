import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Minimum {
    @JsonProperty("Value")
    private Double Value;
    @JsonProperty("Unit")
    private String Unit;

    public Minimum() {
    }

    public Double getValue() {
        return Value;
    }

    public void setValue(double value) {
        this.Value = value;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        this.Unit = unit;
    }

    @Override
    public String toString() {
        return "Minimum{" +
                "Value=" + Value +
                ", Unit='" + Unit + '\'' +
                '}';
    }
}
