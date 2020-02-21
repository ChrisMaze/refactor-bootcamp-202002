package cc.xpbootcamp.warmup.cashier;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class OrderReceipt {
    public static final String RECEIPT_HEADER = "===== 老王超市，值得信赖 ======";
    public static final char NEW_LINE = '\n';

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public String printReceipt() {

        StringBuilder receipt = new StringBuilder();

        receipt.append(generateReceiptHeader());

        receipt.append(generateOrderDate());

        receipt.append(generateLineItems());

        receipt.append(generateReceiptFooter());

        return receipt.toString();
    }

    private String generateReceiptFooter() {
        return "----------------------------" + NEW_LINE
                + generateTotalTax()
                + generateDiscount()
                + generateTotalAmount();
    }

    private String generateTotalTax() {
        return String.format("%s：%.2f%s", "税额", order.getTotalTax(), NEW_LINE);
    }

    private String generateDiscount() {
        return order.getDiscount() == 0 ? "" : (String.format("%s：%.2f%s", "折扣", order.getDiscount(), NEW_LINE));
    }

    private String generateTotalAmount() {
        return String.format("%s：%.2f", "总价", order.getTotalAmount());
    }

    private String generateReceiptHeader() {
        return RECEIPT_HEADER + NEW_LINE + NEW_LINE;
    }

    private String generateOrderDate() {
        return order.getDate().format(DateTimeFormatter.ofPattern("yyyy年M月dd日,E\n", Locale.CHINA));
    }

    private String generateLineItems() {
        StringBuilder lineItemsDetails = new StringBuilder();
        order.getLineItems().forEach(lineItem -> {
            lineItemsDetails.append(String.format("%s，%.2f x %d，%.2f\n", lineItem.getDescription(), lineItem.getPrice(), lineItem.getQuantity(), lineItem.totalAmount()));
        });
        return lineItemsDetails.toString();
    }
}
