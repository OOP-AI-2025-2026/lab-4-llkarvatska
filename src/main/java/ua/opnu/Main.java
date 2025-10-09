package ua.opnu.java.inheritance.account;

// --- Необхідні Імпорти для класів пакету 'bill' ---
import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.DiscountBill;
import ua.opnu.java.inheritance.bill.DiscountBill2;
import ua.opnu.java.inheritance.bill.Item;
import ua.opnu.java.inheritance.bill.MinMaxAccount;
import ua.opnu.java.inheritance.bill.Startup;

// --- Необхідні Імпорти для класів пакету 'point' ---
import ua.opnu.java.inheritance.point.Point3D;

public class Main {
    public static void main(String[] args) {
        // Тест DiscountBill
        Employee clerk = new Employee("Оксана");
        DiscountBill bill = new DiscountBill(clerk,true);
        bill.add(new Item("Хліб",25,2));
        bill.add(new Item("Молоко",40,0));
        bill.add(new Item("Сир",80,10));

        System.out.println("Касир: "+clerk.getName());
        System.out.println("Кількість товарів зі знижкою: "+bill.getDiscountCount());
        System.out.println("Загальна знижка (грн): "+bill.getDiscountAmount());
        System.out.println("Відсоток знижки: "+bill.getDiscountPercent()+"%");
        System.out.println("До сплати: "+bill.getTotal()+" грн");

        // Тест MinMaxAccount
        System.out.println("\n--- Тест MinMaxAccount ---");
        Startup s = new Startup(1000);
        MinMaxAccount account = new MinMaxAccount(s);
        account.credit(500);
        account.debit(200);
        account.credit(300);
        account.debit(700);

        System.out.println("Поточний баланс: "+account.getBalance());
        System.out.println("Мінімальний баланс: "+account.getMin());
        System.out.println("Максимальний баланс: "+account.getMax());

        // Тест Point3D
        System.out.println("\n--- Тест Point3D ---");
        Point3D p1 = new Point3D();
        Point3D p2 = new Point3D(3,4,5);
        System.out.println("p1: "+p1);
        System.out.println("p2: "+p2);
        p1.setLocation(1,2,3);
        p2.setLocation(7,8);
        System.out.println("p1 після setLocation(1,2,3): "+p1);
        System.out.println("p2 після setLocation(7,8): "+p2);
        System.out.println("Відстань між p1 і p2: "+p1.distance(p2));
        System.out.println("Відстань від початку координат до p1: "+p1.distanceFromOrigin());
        System.out.println("Відстань від початку координат до p2: "+p2.distanceFromOrigin());

        // Тест DiscountBill2
        System.out.println("\n--- Тест DiscountBill2 ---");
        Employee clerk2 = new Employee("Іван");
        DiscountBill2 bill2 = new DiscountBill2(clerk2,true);
        bill2.add(new Item("Хліб",25,2));
        bill2.add(new Item("Сир",80,10));
        System.out.println("Касир: "+bill2.getClerk().getName());
        System.out.println("Кількість товарів зі знижкою: "+bill2.getDiscountCount());
        System.out.println("Загальна знижка (грн): "+bill2.getDiscountAmount());
        System.out.println("Відсоток знижки: "+bill2.getDiscountPercent()+"%");
        System.out.println("До сплати: "+bill2.getTotal()+" грн");
    }
}