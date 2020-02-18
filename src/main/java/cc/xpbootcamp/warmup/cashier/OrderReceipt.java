package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    public static final String receiptHeader = "===== 老王超市，值得信赖 ======";
    public static final double taxRate = .10;
    public static final char newLine = '\n';

    private double totalSalesTax = 0d;
    private double totalAmount = 0d;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    DecimalFormat doubleFormatter = new DecimalFormat("#.00");

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        printReceiptHeaders(output);
        printOrderDate(output);
        order.getLineItems().forEach(lineItem -> {
            printProductDetails(output, lineItem);
            calculateTotalAmount(lineItem.totalAmount());
        });
        printReceiptTails(output);

        return output.toString();
    }

    private void printReceiptHeaders(StringBuilder output) {
        output.append(receiptHeader).append(newLine).append(newLine)
                .append(order.getCustomerName())
                .append(order.getCustomerAddress());
    }

    private void printOrderDate(StringBuilder output) {
        output.append(order.getDate()).append(newLine).append(newLine);
    }

    private void printProductDetails(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription()).append('，')
                .append(doubleFormatter.format(lineItem.getPrice())).append(" x ")
                .append(lineItem.getQuantity()).append('，')
                .append(doubleFormatter.format(lineItem.totalAmount())).append(newLine);
    }

    private void calculateTotalAmount(double amount) {
        double salesTax = amount * taxRate;
        this.totalSalesTax += salesTax;
        this.totalAmount += amount + salesTax;
    }

    private void printReceiptTails(StringBuilder output) {
        output.append("----------------------------").append(newLine);
        printsTheStateTax(output);
        printTotalAmount(output);
    }

    private void printsTheStateTax(StringBuilder output) {
        output.append("税额：").append(doubleFormatter.format(totalSalesTax)).append(newLine);
    }

    private void printTotalAmount(StringBuilder output) {
        output.append("总价：").append(doubleFormatter.format(totalAmount)).append(newLine);
    }
}
