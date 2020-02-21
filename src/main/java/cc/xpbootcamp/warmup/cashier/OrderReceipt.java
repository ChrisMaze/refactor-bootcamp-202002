package cc.xpbootcamp.warmup.cashier;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class OrderReceipt {
    private static final char NEW_LINE = '\n';
    private static final String DISCOUNT = "折扣";
    private static final String TOTAL_TAX = "税额";
    private static final String TOTAL_AMOUNT = "总价";
    private static final String FOOTER_FORMATTER = "%s：%.2f%s";
    private static final String LINE_ITEM_FORMATTER = "%s，%.2f x %d，%.2f%s";
    private static final String DIVIDING_LINE = "----------------------------" + NEW_LINE;
    private static final String RECEIPT_HEADER = "===== 老王超市，值得信赖 ======" + NEW_LINE + NEW_LINE;
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy年M月dd日,E\n", Locale.CHINA);

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {

        return generateReceiptHeader() +
                generateOrderDate() +
                generateCommodities() +
                generateReceiptFooter();
    }

    private String generateReceiptHeader() {
        return RECEIPT_HEADER;
    }

    private String generateOrderDate() {
        return order.getDate().format(DATE_FORMATTER);
    }

    private String generateCommodities() {
        StringBuilder lineItemsDetails = new StringBuilder();
        order.getCommodities().forEach(commodity -> {
            lineItemsDetails.append(String.format(LINE_ITEM_FORMATTER,
                    commodity.getDescription(),
                    commodity.getPrice(),
                    commodity.getQuantity(),
                    commodity.totalAmount(),
                    NEW_LINE));
        });
        return lineItemsDetails.toString();
    }

    private String generateReceiptFooter() {
        return DIVIDING_LINE
                + generateTotalTax()
                + generateDiscount()
                + generateTotalAmount();
    }

    private String generateTotalTax() {
        return String.format(FOOTER_FORMATTER, TOTAL_TAX, order.getTotalTax(), NEW_LINE);
    }

    private String generateDiscount() {
        return order.getDiscount() == 0 ? "" : (String.format(FOOTER_FORMATTER, DISCOUNT, order.getDiscount(), NEW_LINE));
    }

    private String generateTotalAmount() {
        return String.format(FOOTER_FORMATTER, TOTAL_AMOUNT, order.getTotalAmount(), NEW_LINE);
    }
}
