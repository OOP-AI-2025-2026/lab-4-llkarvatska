package ua.opnu.java.inheritance.bill;

// Завдання 4: Реалізація за допомогою Композиції (Composition)
public class DiscountBill2 {

    // Композиція: внутрішній об'єкт, який делегує основну роботу
    private GroceryBill bill;
    private boolean isRegularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        // Ініціалізуємо внутрішній об'єкт GroceryBill
        this.bill = new GroceryBill(clerk);
        this.isRegularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    // Метод add - делегує роботу, але додає логіку обліку знижок
    public void add(Item item) {
        bill.add(item);

        if (isRegularCustomer && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }

    // Метод getTotal - делегує повну суму, але віднімає знижку
    public double getTotal() {
        double subtotal = bill.getTotal();

        if (isRegularCustomer) {
            return subtotal - discountAmount;
        } else {
            // Для нерегулярних клієнтів повертаємо повну суму
            return subtotal;
        }
    }

    // Делегування: просто викликаємо метод внутрішнього об'єкта
    public Employee getClerk() {
        return bill.getClerk();
    }

    // Специфічні методи DiscountBill
    public int getDiscountCount() {
        return isRegularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return isRegularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        double total = bill.getTotal();
        double amount = getDiscountAmount();

        if (total == 0.0) {
            return 0.0;
        }
        return (amount / total) * 100.0;
    }
}