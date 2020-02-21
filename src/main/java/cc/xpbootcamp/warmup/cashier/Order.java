package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Order {
    private static final double DISCOUNT_RATE = 0.02;

    private List<Commodity> commodities;
    private LocalDate date;
    private double totalAmount;
    private double totalTax;
    private double discount;

    public Order(List<Commodity> commodities, LocalDate date) {
        this.commodities = commodities;
        this.date = date;
        calculateTotalAmount();
        calculateTotalTax();
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Commodity> getCommodities() {
        return commodities;
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
        this.commodities.forEach(commodity -> {
            totalAmount += commodity.totalAmount() + commodity.totalTax();
        });
        if (isNeedDiscount()) makeDiscount();
    }

    public void calculateTotalTax() {
        this.commodities.forEach(commodity -> {
            totalTax += commodity.totalTax();
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
