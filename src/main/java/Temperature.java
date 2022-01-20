import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    @JsonProperty("Minimum")
    private Minimum MinimumObject;
    @JsonProperty("Maximum")
    private Maximum MaximumObject;

    public Temperature() {
    }

    public Minimum getMinimum() {
        return MinimumObject;
    }

    public Maximum getMaximum() {
        return MaximumObject;
    }

    public void setMinimum(Minimum MinimumObject) {
        this.MinimumObject = MinimumObject;
    }

    public void setMaximum(Maximum MaximumObject) {
        this.MaximumObject = MaximumObject;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "MinimumObject=" + MinimumObject +
                ", MaximumObject=" + MaximumObject +
                '}';
    }
}
