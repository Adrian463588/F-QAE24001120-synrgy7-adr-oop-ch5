package org.basic_syntax;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParkingCalculator
        extends JFrame {

    private JTextField jamParkirField;
    private JLabel resultLabel;

    public ParkingCalculator
            () {
        setTitle("Parking Fee Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel promptLabel = new JLabel("Masukkan jumlah jam parkir:");
        promptLabel.setBounds(20, 20, 200, 25);
        add(promptLabel);

        jamParkirField = new JTextField();
        jamParkirField.setBounds(220, 20, 150, 25);
        add(jamParkirField);

        JButton calculateButton = new JButton("Hitung Biaya");
        calculateButton.setBounds(20, 60, 150, 25);
        add(calculateButton);

        resultLabel = new JLabel("Biaya parkir: ");
        resultLabel.setBounds(20, 100, 350, 25);
        add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitungBiayaParkir();
            }
        });
    }

    private void hitungBiayaParkir() {
        try {
            int jamParkir = Integer.parseInt(jamParkirField.getText());
            double biaya = hitungBiayaParkir(jamParkir);
            resultLabel.setText(String.format("Biaya parkir untuk %d jam adalah $%.2f", jamParkir, biaya));
        } catch (NumberFormatException e) {
            resultLabel.setText("Masukkan jumlah jam yang valid.");
        }
    }

    public static double hitungBiayaParkir(int jamParkir) {

        // Menambahkan kondisi jika jam parkir adalah 0
        if (jamParkir == 0) {
            return 0;
        }

        if (jamParkir <= 5) {
            return jamParkir = 1; // Biaya $1 per jam untuk 5 jam pertama
        }

        else {

            int hari = jamParkir / 24;
            int sisaJam = jamParkir % 24;
            double biaya = hari * 15.0; // $15 per 24 jam

            if (sisaJam <= 5) {
                biaya += sisaJam * 0.5; // Biaya $1 per jam untuk 5 jam pertama dari sisa jam
            } else {
                biaya += 1 + (sisaJam - 5) * 0.5; // $1 untuk 5 jam pertama + $0.5 per jam berikutnya dari sisa jam
            }
            return biaya;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ParkingCalculator
                        ().setVisible(true);
            }
        });
    }
}
