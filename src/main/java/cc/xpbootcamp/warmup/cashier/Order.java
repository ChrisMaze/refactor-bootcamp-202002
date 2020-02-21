package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Order {
    private static final double DISCOUNT_RATE = 0.02;

    private List<LineItem> lineItems;
    private LocalDate date;
    private double totalAmount;
    private double totalTax;
    private double discount;

    public Order(List<LineItem> lineItems, LocalDate date) {
        this.lineItems = lineItems;
        this.date = date;
        calculateTotalAmount();
        calculateTotalTax();
    }

    public LocalDate getDate() {
        return date;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public double getDiscount() {
        return discount;
    }

    public void calculateTotalAmount() {
        this.lineItems.forEach(lineItem -> {
            totalAmount += lineItem.totalAmount() + lineItem.totalTax();
        });
        if (isNeedDiscount()) makeDiscount();
    }

    public void calculateTotalTax() {
        this.lineItems.forEach(lineItem -> {
            totalTax += lineItem.totalTax();
        });
    }

    private void makeDiscount() {
        discount = totalAmount * DISCOUNT_RATE;
        totalAmount -= discount;
    }

    private boolean isNeedDiscount() {
        return date.getDayOfWeek().equals(DayOfWeek.WEDNESDAY);
    }

}
