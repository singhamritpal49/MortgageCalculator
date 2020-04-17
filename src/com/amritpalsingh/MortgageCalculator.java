package com.amritpalsingh;

import java.text.NumberFormat;

public class MortgageCalculator {
    // Static Fields
    private final static byte MONTH_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    // Instance Fields
    private int principal;
    private float annualInterest;
    private byte years;

    // Constructor
    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    // Method For Calculating Balance;
    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest  = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1+ monthlyInterest,numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments)-1);
        return balance;

    }

    // Method For Calculating Mortgage
    public double calculateMortgage() {
        float monthlyInterest  = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1+ monthlyInterest, numberOfPayments))
                / (Math.pow(1+ monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }

    public double[] getRemainingBalance() {
        double[] balances = new double[getNumberOfPayments()];
        for(short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }



    // Getter
    // private because its implementation detail
    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTH_IN_YEAR;
    }

    // Getter
    // private because its implementation detail
    private int getNumberOfPayments() {
        return years * MONTH_IN_YEAR;
    }
}
