import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.opnu.java.inheritance.bill.MinMaxAccount;
import ua.opnu.java.inheritance.bill.Startup;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    @DisplayName("Test initial Min/Max balance")
    void test1() {
        Startup s = new Startup(100);
        MinMaxAccount account = new MinMaxAccount(s);
        assertEquals(100, account.getMin());
        assertEquals(100, account.getMax());
    }

    @Test
    @DisplayName("Test multiple transactions")
    void test4() {
        Startup s = new Startup(500);
        MinMaxAccount account = new MinMaxAccount(s);
        account.credit(100);
        account.debit(350);
        account.credit(50);
        account.debit(100);

        assertEquals(200, account.getBalance());
        assertEquals(200, account.getMin());
        assertEquals(600, account.getMax());
    }
}