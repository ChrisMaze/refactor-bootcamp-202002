package cc.xpbootcamp.warmup.cashier;

import java.util.concurrent.atomic.AtomicReference;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    public static final double taxRate = .10;
    public static final char tabs = '\t';
    public static final char newLine = '\n';
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        PrintReceiptHeaders(output);

        AtomicReference<Double> totalSalesTax = new AtomicReference<>(0d);
        AtomicReference<Double> totalAmount = new AtomicReference<>(0d);
        order.getLineItems().forEach(lineItem -> {
            printReceiptBody(output, lineItem);
            double salesTax = lineItem.totalAmount() * taxRate;
            totalSalesTax.updateAndGet(v -> v + salesTax);
            totalAmount.updateAndGet(v -> v + lineItem.totalAmount() + salesTax);
        });
        PrintsTheStateTax(output, totalSalesTax);
        PrintTotalAmount(output, totalAmount);
        return output.toString();
    }

    private void PrintTotalAmount(StringBuilder output, AtomicReference<Double> totalAmount) {
        output.append("Total Amount").append(tabs).append(totalAmount.get());
    }

    private void PrintsTheStateTax(StringBuilder output, AtomicReference<Double> totalSalesTax) {
        output.append("Sales Tax").append(tabs).append(totalSalesTax.get());
    }

    private void printReceiptBody(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription());
        output.append(tabs);
        output.append(lineItem.getPrice());
        output.append(tabs);
        output.append(lineItem.getQuantity());
        output.append(tabs);
        output.append(lineItem.totalAmount());
        output.append(newLine);
    }

    private void PrintReceiptHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }
}
