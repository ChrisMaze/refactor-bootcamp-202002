package cc.xpbootcamp.warmup.cashier;

import java.util.concurrent.atomic.AtomicReference;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        PrintReceiptHeaders(output);

        // prints lineItems
        AtomicReference<Double> totalSalesTax = new AtomicReference<>(0d);
        AtomicReference<Double> totalAmount = new AtomicReference<>(0d);
        order.getLineItems().forEach(lineItem -> {
            printReceiptBody(output, lineItem);
            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax.updateAndGet(v -> v + salesTax);
            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount.updateAndGet(v -> v + lineItem.totalAmount() + salesTax);
        });
        // prints the state tax
        output.append("Sales Tax").append('\t').append(totalSalesTax.get());

        // print total amount
        output.append("Total Amount").append('\t').append(totalAmount.get());
        return output.toString();
    }

    private void printReceiptBody(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.totalAmount());
        output.append('\n');
    }

    private void PrintReceiptHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }
}
