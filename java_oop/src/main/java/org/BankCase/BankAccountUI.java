package org.BankCase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccountUI {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 1000.0, "John Doe", "john@example.com", "123-456-7890");

        // Create the frame
        JFrame frame = new JFrame("Bank Account");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create and add labels
        JLabel balanceLabel = new JLabel("Current Balance: $" + account.getBalance());
        balanceLabel.setBounds(20, 20, 200, 25);
        frame.add(balanceLabel);

        JLabel depositLabel = new JLabel("Deposit Amount:");
        depositLabel.setBounds(20, 60, 100, 25);
        frame.add(depositLabel);

        JLabel withdrawLabel = new JLabel("Withdraw Amount:");
        withdrawLabel.setBounds(20, 100, 120, 25);
        frame.add(withdrawLabel);

        // Create and add text fields
        JTextField depositField = new JTextField();
        depositField.setBounds(150, 60, 150, 25);
        frame.add(depositField);

        JTextField withdrawField = new JTextField();
        withdrawField.setBounds(150, 100, 150, 25);
        frame.add(withdrawField);

        // Create and add buttons
        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(20, 140, 120, 25);
        frame.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(150, 140, 120, 25);
        frame.add(withdrawButton);

        // Create and add message label
        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(20, 180, 500, 25);
        frame.add(messageLabel);

        // Add action listeners for buttons
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String depositText = depositField.getText();
                if (!depositText.isEmpty()) {
                    try {
                        double depositAmount = Double.parseDouble(depositText);
                        String message = account.deposit(depositAmount);
                        messageLabel.setText(message);
                        balanceLabel.setText("Current Balance: $" + account.getBalance());
                        depositField.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid deposit amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Deposit field cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String withdrawText = withdrawField.getText();
                if (!withdrawText.isEmpty()) {
                    try {
                        double withdrawAmount = Double.parseDouble(withdrawText);
                        String message = account.withdraw(withdrawAmount);
                        if (message.equals("Saldo tidak mencukupi")) {
                            JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            messageLabel.setText(message);
                            balanceLabel.setText("Current Balance: $" + account.getBalance());
                            withdrawField.setText("");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid withdraw amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Withdraw field cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }
}
