package training.backend.demo.revision;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}
