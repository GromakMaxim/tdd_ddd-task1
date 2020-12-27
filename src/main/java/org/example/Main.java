package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        System.out.println("Введите желаемую сумму");
        int sum = myScan.nextInt();
        System.out.println();
        System.out.println("Введите годовую ставку в процентах");
        double persentYear = myScan.nextDouble();
        System.out.println();
        System.out.println("Введите срок кредита в месяцах");
        int loanPeriod = myScan.nextInt();
        System.out.println();

        LoanCalculator calculator = new LoanCalculator();
        int paymentPerMonth = calculator.calculateMonthyAmount(sum, loanPeriod, calculator.calculateRatePerMonth(persentYear));
        System.out.println("Ежемесячный платеж: " + paymentPerMonth);
        int loanSum = calculator.calculateCreditTotalSum(paymentPerMonth, loanPeriod);
        System.out.println("Итого сумма: " + loanSum);
        System.out.println("Сумма переплаты: " + calculator.calculateLoanOverpayment(paymentPerMonth, loanPeriod, sum));
    }
}
