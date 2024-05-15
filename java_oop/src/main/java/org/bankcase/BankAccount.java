package org.bankcase;

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
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " made. New balance is $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw funds
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Saldo tidak mencukupi");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " processed. Remaining balance is $" + balance);
        }
    }

    // Main method to test the BankAccount class
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 1000.0, "John Doe", "john@example.com", "123-456-7890");

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Customer Name: " + account.getCustomerName());
        System.out.println("Customer Email: " + account.getCustomerEmail());
        System.out.println("Customer Phone: " + account.getCustomerPhone());
        System.out.println("Current Balance: $" + account.getBalance());

        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(1500.0);
    }
}

