package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {

    public static final double taxRate = 0.10;
    public static final double discountRate = 0.02;

    private double totalSalesTax = 0d;
    private double totalAmount = 0d;
    private double totalDiscount = 0d;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public Order getOrder() { return order; }

    public double getTotalSalesTax() { return totalSalesTax; }

    public double getTotalAmount() { return totalAmount; }

    public double getTotalDiscount() { return totalDiscount; }

    public void calculate() {
        calculateTotalAmount();
        calculateDiscount();
    }

    private void calculateTotalAmount() {
        order.getLineItems().forEach(lineItem -> {
            double amount = lineItem.totalAmount();
            double salesTax = amount * taxRate;
            this.totalSalesTax += salesTax;
            this.totalAmount += amount + salesTax;
        });
    }

    private void calculateDiscount() {
        if (order.getDate().contains("星期三")) {
            this.totalDiscount = totalAmount * discountRate;
            this.totalAmount -= this.totalDiscount;
        }
    }
}
