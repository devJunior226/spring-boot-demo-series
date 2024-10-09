package training.backend.demo.student_school.revision;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    @JsonProperty("c-name")
    private String customerName;

    @JsonProperty("p-name")
    private String productName;

    @JsonProperty("p-quantity")
    private int quantity;

    /**
     * Will return our order in json format.
     *
     * @return an order
     */
    @Override
    public String toString() {
        return "Order{"
                + "customerName='" + customerName + '\'' + ", "
                + "productName='" + productName + '\''
                + ", quantity=" + quantity + '}';
    }
}
