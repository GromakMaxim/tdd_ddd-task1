package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CreditCalculatorTest {
    LoanCalculator calculator;

    @Before
    public void init(){
        calculator = new LoanCalculator();
    }

    @Test
    public void testCalculateRatePerMonth() {
        double actual = calculator.calculateRatePerMonth(12);
        double expected = 0.01;
        assertEquals(expected, actual,0.001);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateRatePerMonth_WithZeroPersent(){
        calculator.calculateRatePerMonth(0);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateRatePerMonth_WithNegativePersent(){
        calculator.calculateRatePerMonth(-12);
    }



    @Test
    public void testCalculateMonthAmount() {
        int actual = (calculator.calculateMonthyAmount(20_000, 36, 0.01));
        int expected = 664;
        assertEquals(expected, actual);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateMonthAmount_WithNegativeSum(){
        calculator.calculateMonthyAmount(-20_000, 36, 0.01);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateMonthAmount_WithZeroSum(){
        calculator.calculateMonthyAmount(0, 36, 0.01);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateMonthAmount_WithNegativeLoanPeriod(){
        calculator.calculateMonthyAmount(20_000, -36, 0.01);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateMonthAmount_WithNegativeLoanPercent(){
        calculator.calculateMonthyAmount(20_000, 36, -0.01);
    }




    @Test
    public void testCalculateCreditTotalSum(){
        int actual = calculator.calculateCreditTotalSum(664, 36);
        int expected = 664 * 36;
        assertEquals(expected, actual);
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculateCreditTotalSum_WithNegativeMonthPayment(){
        calculator.calculateCreditTotalSum(-1000, 36);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateCreditTotalSum_WithZeroMonthPayment(){
        calculator.calculateCreditTotalSum(0, 36);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateCreditTotalSum_WithNegativeLoanPeriod(){
        calculator.calculateCreditTotalSum(1000, -36);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateCreditTotalSum_WithZeroLoanPeriod(){
        calculator.calculateCreditTotalSum(1000, 0);
    }




    @Test
    public void testCalculateLoanOverpayment(){
        int actual = calculator.calculateLoanOverpayment(664,36, 20_000);
        int expected = (664*36)-20_000;
        assertEquals(expected, actual);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateLoanOverpayment_WithNegativeMonthPayment(){
        calculator.calculateLoanOverpayment(-1000,36, 20_000);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateLoanOverpayment_WithZeroMonthPayment(){
        calculator.calculateLoanOverpayment(0,36, 20_000);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateLoanOverpayment_WithNegativeLoanPeriod(){
        calculator.calculateLoanOverpayment(1000,-36, 20_000);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateLoanOverpayment_WithZeroLoanPeriod(){
        calculator.calculateLoanOverpayment(1000,0, 20_000);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateLoanOverpayment_WithNegativeSum(){
        calculator.calculateLoanOverpayment(1000,0, -20_000);
    }
    @Test(expected = ArithmeticException.class)
    public void testCalculateLoanOverpayment_WithZerpSum(){
        calculator.calculateLoanOverpayment(1000,36, 0);
    }
}
