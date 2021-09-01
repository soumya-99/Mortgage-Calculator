package com.soumyadeep;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------Mortgage Calculator--------");

        int principle = (int) readNumber("Principle (1K - 1M): ", 1000, 1_000_000);
        float yearlyInterestRate = (float) readNumber("Interest (1 - 30): ", 1, 30);
        byte years = (byte) readNumber("No of Years (1 - 80): ", 1, 80);

        double mortgage = calculateMortgage(principle, yearlyInterestRate, years);
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(mortgage));
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value > min && value <= max) break;
            System.out.println("Enter a value between " + min + " to " + max);
        }
        return value;
    }

    public static double calculateMortgage(int principle, float yearlyInterestRate, byte years) {
        int totalMonths = years * 12;
        float monthlyInterestRate = (yearlyInterestRate / 100) / 12;
        return principle * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalMonths)) / (Math.pow((1 + monthlyInterestRate), totalMonths) - 1);
    }
}