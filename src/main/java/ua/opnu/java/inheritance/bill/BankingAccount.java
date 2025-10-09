package ua.opnu.java.inheritance.bill; // ПЕРЕВІРТЕ ЦЕЙ ПАКЕТ

public class BankingAccount {
    private int balance; // Баланс у копійках

    public BankingAccount(Startup s) {
        this.balance = s.getInitialBalance();
    }

    public void debit(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    public void credit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Цей метод необхідний для MinMaxAccount.java!
    public int getBalance() {
        return balance;
    }
}