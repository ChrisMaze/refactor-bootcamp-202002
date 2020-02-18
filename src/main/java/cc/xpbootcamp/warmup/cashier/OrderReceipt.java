package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;
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
    private Double totalSalesTax = 0d;
    private Double totalAmount = 0d;
    DecimalFormat doubleFormatter = new DecimalFormat("#.00");

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceiptOld() {
        StringBuilder output = new StringBuilder();

        printReceiptHeadersOld(output);

        order.getLineItems().forEach(lineItem -> {
            printProductDetails(output, lineItem);
            double salesTax = lineItem.totalAmount() * taxRate;
            this.totalSalesTax += salesTax;
            this.totalAmount += lineItem.totalAmount() + salesTax;
        });
        printsTheStateTax(output, totalSalesTax);
        printTotalAmount(output, totalAmount);
        return output.toString();
    }

    private void printTotalAmount(StringBuilder output, Double totalAmount) {
        output.append("Total Amount").append(tabs).append(totalAmount);
    }

    private void printsTheStateTax(StringBuilder output, Double totalSalesTax) {
        output.append("Sales Tax").append(tabs).append(totalSalesTax);
    }

    private void printProductDetails(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription()).append('，')
                .append(doubleFormatter.format(lineItem.getPrice())).append(" x ")
                .append(lineItem.getQuantity()).append('，')
                .append(doubleFormatter.format(lineItem.totalAmount())).append(newLine);
    }

    private void printReceiptHeadersOld(StringBuilder output) {
        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private void printReceiptHeaders(StringBuilder output) {
        output.append("===== 老王超市，值得信赖 ======\n\n")
                .append(order.getCustomerName())
                .append(order.getCustomerAddress());
    }

    private void printOrderDate(StringBuilder output) {
        output.append(order.getDate()).append("\n\n");
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        printReceiptHeaders(output);

        printOrderDate(output);

        order.getLineItems().forEach(lineItem -> {
            printProductDetails(output, lineItem);

            double salesTax = lineItem.totalAmount() * taxRate;
            this.totalSalesTax += salesTax;
            this.totalAmount += lineItem.totalAmount() + salesTax;
        });
        output.append("----------------------------\n");
        printsTheStateTax(output, this.totalSalesTax);
        printTotalAmount(output, this.totalAmount);
        return output.toString();
    }
}
