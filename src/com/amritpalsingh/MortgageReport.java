package com.amritpalsingh;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private  MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println("PAYMENT SCHEDULED");
        System.out.println("-----------------");
        for (double balance: calculator.getRemainingBalance()) {
            System.out.println(currency.format(balance));
        }
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormat = currency.format(mortgage);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payment: " + mortgageFormat);
    }
}
