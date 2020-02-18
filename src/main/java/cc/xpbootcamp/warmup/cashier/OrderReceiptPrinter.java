package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;

public class OrderReceiptPrinter {
    public static final String receiptHeader = "===== 老王超市，值得信赖 ======";
    public static final char newLine = '\n';

    private OrderReceipt orderReceipt;
    private Order order;

    DecimalFormat doubleFormatter = new DecimalFormat("#.00");

    public OrderReceiptPrinter(OrderReceipt orderReceipt) {
        this.orderReceipt = orderReceipt;
        this.order = orderReceipt.getOrder();
    }

    public String printReceipt() {
        orderReceipt.calculate();

        StringBuilder output = new StringBuilder();

        printReceiptHeaders(output);
        printOrderDate(output);
        order.getLineItems().forEach(lineItem -> {
            printProductDetails(output, lineItem);
        });
        printReceiptTails(output);

        return output.toString();
    }

    private void printReceiptHeaders(StringBuilder output) {
        output.append(receiptHeader).append(newLine).append(newLine)
                .append(this.order.getCustomerName())
                .append(this.order.getCustomerAddress());
    }

    private void printOrderDate(StringBuilder output) {
        output.append(this.order.getDate()).append(newLine).append(newLine);
    }

    private void printProductDetails(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription()).append('，')
                .append(doubleFormatter.format(lineItem.getPrice())).append(" x ")
                .append(lineItem.getQuantity()).append('，')
                .append(doubleFormatter.format(lineItem.totalAmount())).append(newLine);
    }

    private void printReceiptTails(StringBuilder output) {
        output.append("----------------------------").append(newLine);
        printsTheStateTax(output);
        printDiscount(output);
        printTotalAmount(output);
    }

    private void printsTheStateTax(StringBuilder output) {
        output.append("税额：").append(doubleFormatter.format(orderReceipt.getTotalSalesTax())).append(newLine);
    }

    private void printTotalAmount(StringBuilder output) {

        output.append("总价：").append(doubleFormatter.format(orderReceipt.getTotalAmount())).append(newLine);
    }

    private void printDiscount(StringBuilder output) {
        double totalDiscount = orderReceipt.getTotalDiscount();
        if (totalDiscount > 0) {
            output.append("折扣：").append(doubleFormatter.format(totalDiscount)).append(newLine);
        }
    }
}
