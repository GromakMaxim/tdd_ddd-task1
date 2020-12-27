package org.example;

public class LoanCalculator {

    public double calculateRatePerMonth(double percent) {
        if (percent <= 0) {
            throw new ArithmeticException("Процент по кредиту не может быть <= 0");
        }
        return percent / 100 / percent;
    }

    public int calculateMonthyAmount(int sum, int monthsNumber, double persent) {
        if (sum <= 0) {
            throw new ArithmeticException("Сумма кредита не может быть  <= 0");
        } else if (persent <= 0) {
            throw new ArithmeticException("Процент по кредиту не может быть <= 0");
        } else if (monthsNumber <= 0) {
            throw new ArithmeticException("Период кредитования не может быть <= 0");
        }

        double numerator = (persent * Math.pow((1 + persent), monthsNumber));
        double denominator = Math.pow((1 + persent), monthsNumber) - 1;

        return (int) (sum * (numerator / denominator));
    }

    public int calculateCreditTotalSum(int monthAmount, int monthsNumber) {
        if (monthAmount <= 0) {
            throw new ArithmeticException("Платеж в месяц не может быть <= 0");
        } else if (monthsNumber <= 0) {
            throw new ArithmeticException("Период кредитования не может быть <= 0");
        }
        return monthAmount * monthsNumber;
    }

    public int calculateLoanOverpayment(int monthAmount, int monthsNumber, int sum) {
        if (monthAmount <= 0) {
            throw new ArithmeticException("Платеж в месяц не может быть <= 0");
        } else if (monthsNumber <= 0) {
            throw new ArithmeticException("Период кредитования не может быть <= 0");
        } else if (sum <= 0) {
            throw new ArithmeticException("Сумма кредита не может быть  <= 0");
        }

        return (monthAmount * monthsNumber) - sum;
    }
}
