package org.VehicleCase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Membuat objek HondaJazz
        HondaJazz hondaJazz = new HondaJazz("Red", 80.0, 40.0, "Automatic", true);
        ToyotaFortuner toyotaFortuner = new ToyotaFortuner("Black", 90.0, 60.0, "Manual", false);
        SuzukiKatana suzukiKatana = new SuzukiKatana("Blue", 70.0, 50.0, "Manual", false);

        // Membuat frame
        JFrame frame = new JFrame("Vehicle UI");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Membuat tombol dan field untuk HondaJazz
        JLabel hondaLabel = new JLabel("Honda Jazz:");
        hondaLabel.setBounds(20, 20, 150, 25);
        frame.add(hondaLabel);

        JButton moveHondaButton = new JButton("Move Forward");
        moveHondaButton.setBounds(20, 50, 150, 25);
        frame.add(moveHondaButton);

        JButton toggleEcoButton = new JButton("Toggle Eco Mode");
        toggleEcoButton.setBounds(20, 80, 150, 25);
        frame.add(toggleEcoButton);

        // Membuat tombol dan field untuk ToyotaFortuner
        JLabel toyotaLabel = new JLabel("Toyota Fortuner:");
        toyotaLabel.setBounds(200, 20, 150, 25);
        frame.add(toyotaLabel);

        JButton turnToyotaButton = new JButton("Turn");
        turnToyotaButton.setBounds(200, 50, 150, 25);
        frame.add(turnToyotaButton);

        JButton toggle4WDButton = new JButton("Toggle 4WD");
        toggle4WDButton.setBounds(200, 80, 150, 25);
        frame.add(toggle4WDButton);

        // Membuat tombol dan field untuk SuzukiKatana
        JLabel suzukiLabel = new JLabel("Suzuki Katana:");
        suzukiLabel.setBounds(20, 150, 150, 25);
        frame.add(suzukiLabel);

        JTextField refuelField = new JTextField();
        refuelField.setBounds(20, 180, 100, 25);
        frame.add(refuelField);

        JButton refuelButton = new JButton("Refuel");
        refuelButton.setBounds(130, 180, 100, 25);
        frame.add(refuelButton);

        JButton toggleRoofRackButton = new JButton("Toggle Roof Rack");
        toggleRoofRackButton.setBounds(20, 210, 150, 25);
        frame.add(toggleRoofRackButton);

        // Menambahkan label pesan
        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(20, 250, 500, 25);
        frame.add(messageLabel);

        // Action listeners
        moveHondaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hondaJazz.moveForward();
                messageLabel.setText("Honda Jazz is moving forward.");
            }
        });

        toggleEcoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hondaJazz.toggleEcoMode();
                String status = hondaJazz.isEcoMode() ? "ON" : "OFF";
                messageLabel.setText("Honda Jazz toggled Eco Mode. Status: " + status);
            }
        });

        // Array satu elemen untuk menyimpan status putaran
        final boolean[] isTurnedLeft = {false};

        turnToyotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTurnedLeft[0]) {
                    toyotaFortuner.turn("right");
                    messageLabel.setText("Toyota Fortuner turned right.");
                } else {
                    toyotaFortuner.turn("left");
                    messageLabel.setText("Toyota Fortuner turned left.");
                }
                isTurnedLeft[0] = !isTurnedLeft[0]; // Toggle status putaran
            }
        });



        toggle4WDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toyotaFortuner.toggleFourWheelDrive();
                String status = toyotaFortuner.isFourWheelDrive() ? "ENGAGED" : "DISENGAGED";
                messageLabel.setText("Toyota Fortuner toggled 4WD. Status: " + status);
            }
        });

        refuelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(refuelField.getText());
                    suzukiKatana.refuel(amount);
                    messageLabel.setText("Suzuki Katana refueled with " + amount + " liters.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid fuel amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        toggleRoofRackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suzukiKatana.toggleRoofRack();
                String status = suzukiKatana.hasRoofRack() ? "INSTALLED" : "REMOVED";
                messageLabel.setText("Suzuki Katana toggled Roof Rack. Status: " + status);
            }
        });

        // Menampilkan frame
        frame.setVisible(true);
    }
}
