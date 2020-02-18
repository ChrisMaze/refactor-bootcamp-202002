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

    public String printReceiptOld() {
        StringBuilder output = new StringBuilder();

        printReceiptHeadersOld(output);

        AtomicReference<Double> totalSalesTax = new AtomicReference<>(0d);
        AtomicReference<Double> totalAmount = new AtomicReference<>(0d);
        order.getLineItems().forEach(lineItem -> {
            printProductDetails(output, lineItem);
            double salesTax = lineItem.totalAmount() * taxRate;
            totalSalesTax.updateAndGet(v -> v + salesTax);
            totalAmount.updateAndGet(v -> v + lineItem.totalAmount() + salesTax);
        });
        printsTheStateTax(output, totalSalesTax);
        printTotalAmount(output, totalAmount);
        return output.toString();
    }

    private void printTotalAmount(StringBuilder output, AtomicReference<Double> totalAmount) {
        output.append("Total Amount").append(tabs).append(totalAmount.get());
    }

    private void printsTheStateTax(StringBuilder output, AtomicReference<Double> totalSalesTax) {
        output.append("Sales Tax").append(tabs).append(totalSalesTax.get());
    }

    private void printProductDetails(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription()).append(tabs)
                .append(lineItem.getPrice()).append(tabs)
                .append(lineItem.getQuantity()).append(tabs)
                .append(lineItem.totalAmount()).append(newLine);
    }

    private void printReceiptHeadersOld(StringBuilder output) {
        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private String printReceiptHeaders() {
        return "===== 老王超市，值得信赖 ======\n\n" +
                order.getCustomerName() +
                order.getCustomerAddress();
    }

    private String printOrderDate() {
        return order.getDate() + "\n\n";
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(printReceiptHeaders())
                .append(printOrderDate());

        AtomicReference<Double> totalSalesTax = new AtomicReference<>(0d);
        AtomicReference<Double> totalAmount = new AtomicReference<>(0d);
        order.getLineItems().forEach(lineItem -> {
            printProductDetails(output, lineItem);
            double salesTax = lineItem.totalAmount() * taxRate;
            totalSalesTax.updateAndGet(v -> v + salesTax);
            totalAmount.updateAndGet(v -> v + lineItem.totalAmount() + salesTax);
        });
        printsTheStateTax(output, totalSalesTax);
        printTotalAmount(output, totalAmount);
        return output.toString();
    }
}
