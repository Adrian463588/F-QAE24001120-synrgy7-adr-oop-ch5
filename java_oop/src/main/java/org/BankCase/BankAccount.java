package org.BankCase;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    // Constructor
    public BankAccount(String accountNumber, double balance, String customerName, String customerEmail, String customerPhone) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    // Method to deposit funds
    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Deposit sebesar $" + amount + " diterima. Saldo sekarang adalah $" + balance;
        } else {
            return "Invalid deposit amount.";
        }
    }

    // Method to withdraw funds
    public String withdraw(double amount) {
        if (amount > balance) {
            return "Saldo tidak mencukupi";
        } else {
            balance -= amount;
            return "Menarik sebesar $" + amount + " permintaan diproses. Saldo tersisa sekarang adalah $" + balance;
        }
    }
}
