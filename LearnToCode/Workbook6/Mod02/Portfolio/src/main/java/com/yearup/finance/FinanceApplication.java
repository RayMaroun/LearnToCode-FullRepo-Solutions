package com.yearup.finance;

public class FinanceApplication {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(123, "Pam", 12500);
        Valuable account2 = new BankAccount(456, "Gary", 1500);
        // try to deposit money into both accounts
        account1.deposit(100);
        account2.deposit(100); // This will show an error


    }
}
