package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private List<LineItem> lineItems;
    private String date;

    public Order(List<LineItem> lineItems, String date) {
        this.lineItems = lineItems;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
}
