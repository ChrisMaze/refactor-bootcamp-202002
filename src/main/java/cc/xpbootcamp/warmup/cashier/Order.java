package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<LineItem> lineItems;
    private String date;

    public Order(String customerName, String customerAddress, List<LineItem> lineItems, String date) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getDate() {
        return date;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
}
