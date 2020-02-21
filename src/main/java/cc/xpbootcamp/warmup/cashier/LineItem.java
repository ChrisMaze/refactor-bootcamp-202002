package cc.xpbootcamp.warmup.cashier;

import static cc.xpbootcamp.warmup.cashier.CalculationConstant.TAX_RATE;

public class LineItem {
    private String description;
    private double price;
    private int quantity;

    public LineItem(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double totalAmount() {
        return price * quantity;
    }

    public double totalTax() {
        return totalAmount() * TAX_RATE;
    }
}
