import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ua.opnu.java.inheritance.bill.DiscountBill2;
import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {

    @Nested
    @DisplayName("Tests for the fourth task (DiscountBill2 - Composition)")
    class Test {

        @org.junit.jupiter.api.Test
        @DisplayName("Test getTotal() (Preferred, Complex)")
        void test8() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-2"), preferred);
            bill.add(new Item("candy bar", 1.35, 0.25));
            bill.add(new Item("toy car", 3.25, 0.50));
            bill.add(new Item("apple", 0.30, 0.05));
            bill.add(new Item("orange", 0.30, 0.05));
            bill.add(new Item("newspaper", 0.99, 0.0));
            double expected = 5.34;
            assertEquals(expected, bill.getTotal(), 0.001);
        }

        @org.junit.jupiter.api.Test
        @DisplayName("Test getDiscountCount() (Preferred, Complex)")
        void test14() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-2"), preferred);
            bill.add(new Item("notebook", 3.00, 0.15));
            bill.add(new Item("lemonade", 1.50, 0.0));
            bill.add(new Item("bread", 2.25, 0.35));
            bill.add(new Item("gift card", 75.00, 0.0));
            bill.add(new Item("bagels", 1.30, 0.16));
            bill.add(new Item("antique table", 125.00, 35.50));
            int expected = 4;
            assertEquals(expected, bill.getDiscountCount());
        }

        @org.junit.jupiter.api.Test
        @DisplayName("Test getDiscountPercent() (Complex)")
        void test26() {
            boolean preferred = true;
            DiscountBill2 bill = new DiscountBill2(new Employee("clerk-2"), preferred);
            bill.add(new Item("vinegar", 4.18, 0.0));
            bill.add(new Item("soup", 2.50, 0.15));
            bill.add(new Item("rice", 3.0, 0.75));
            bill.add(new Item("coffee", 4.25, 0.25));
            bill.add(new Item("flour", 6.50, 2.25));
            double expected = 16.6421928536466;
            assertEquals(expected, bill.getDiscountPercent(), 0.0001);
        }
    }
}