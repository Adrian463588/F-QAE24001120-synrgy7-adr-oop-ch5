package org.basic_syntax;
import java.util.Scanner;

public class ParkingCalculator {

    public static double hitungBiayaParkir(int jamParkir) {
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah jam parkir: ");
        int jamParkir = scanner.nextInt();

        double biaya = hitungBiayaParkir(jamParkir);
        System.out.printf("Biaya parkir untuk %d jam adalah $%.2f\n", jamParkir, biaya);

        scanner.close();
    }
}

