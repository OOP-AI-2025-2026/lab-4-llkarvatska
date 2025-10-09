package ua.opnu.java.inheritance.bill; // ПЕРЕВІРТЕ ЦЕЙ ПАКЕТ

public class MinMaxAccount extends BankingAccount { // Рядок 3
    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) { // Рядок 7
        super(s); // Рядок 8
        int initialBalance = super.getBalance();
        this.minBalance = initialBalance;
        this.maxBalance = initialBalance;
    }

    private void updateMinMax() {
        int currentBalance = super.getBalance();
        if (currentBalance < minBalance) {
            minBalance = currentBalance;
        }
        if (currentBalance > maxBalance) {
            maxBalance = currentBalance;
        }
    }

    @Override // Рядок 14
    public void debit(int amount) {
        super.debit(amount);
        updateMinMax();
    }

    @Override // Рядок 20
    public void credit(int amount) {
        super.credit(amount);
        updateMinMax();
    }

    public int getMin() {
        return minBalance;
    }

    public int getMax() {
        return maxBalance;
    }
}