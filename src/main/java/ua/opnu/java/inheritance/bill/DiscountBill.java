package ua.opnu.java.inheritance.bill;

import java.util.List;

// Завдання 1: Успадкування від GroceryBill
public class DiscountBill extends GroceryBill {
    private boolean isRegularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.isRegularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    @Override
    public void add(Item item) {
        super.add(item);

        // Облік знижки відбувається тільки для постійних клієнтів І якщо є знижка > 0
        if (isRegularCustomer && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        double subtotal = super.getTotal();

        if (isRegularCustomer) {
            return subtotal - discountAmount;
        } else {
            // Для нерегулярних клієнтів повертаємо повну суму
            return subtotal;
        }
    }

    // Виправлення: повертає 0, якщо клієнт не постійний
    public int getDiscountCount() {
        if (!isRegularCustomer) {
            return 0;
        }
        return discountCount;
    }

    // Виправлення: повертає 0.0, якщо клієнт не постійний
    public double getDiscountAmount() {
        if (!isRegularCustomer) {
            return 0.0;
        }
        return discountAmount;
    }

    // Виправлення: повертає 0.0, якщо клієнт не постійний
    public double getDiscountPercent() {
        if (!isRegularCustomer) {
            return 0.0;
        }

        double total = super.getTotal();
        // Використовуємо вже обчислену discountAmount
        double amount = getDiscountAmount();

        if (total == 0.0) {
            return 0.0;
        }
        return (amount / total) * 100.0;
    }
}