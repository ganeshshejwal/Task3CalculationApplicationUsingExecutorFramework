package com.application.calculationtask.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.calculationtask.service.CalculationTaskService;

public class CalculationTaskServiceTests {

    @Mock
    Logger logger;

    @InjectMocks
    CalculationTaskService calculationTaskService;

    @BeforeEach
    public void setup() {
        logger = LoggerFactory.getLogger(CalculationTaskServiceTests.class);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSquare() {
        int number = 5;
        calculationTaskService.getSquare(number);
        Mockito.verify(logger).info("Method getSquare executed successfully");
    }

    @Test
    public void testGetCube() {
        int number = 3;
        calculationTaskService.getCube(number);
        Mockito.verify(logger).info("Method getCube executed successfully");
    }

    @Test
    public void testIsEvenOrOdd() {
        int evenNumber = 4;
        int oddNumber = 7;
        calculationTaskService.isEvenOrOdd(evenNumber);
        calculationTaskService.isEvenOrOdd(oddNumber);
        Mockito.verify(logger, Mockito.times(2)).info("Method isEvenOrOdd executed successfully");
    }

    @Test
    public void testIsPrime() {
        int primeNumber = 17;
        int nonPrimeNumber = 20;
        calculationTaskService.isPrime(primeNumber);
        calculationTaskService.isPrime(nonPrimeNumber);
        Mockito.verify(logger, Mockito.times(2)).info("Method isPrime executed successfully");
    }

    @Test
    public void testIsArmstrongNumber() {
        int armstrongNumber = 153;
        int nonArmstrongNumber = 123;
        calculationTaskService.isArmstrongNumber(armstrongNumber);
        calculationTaskService.isArmstrongNumber(nonArmstrongNumber);
        Mockito.verify(logger, Mockito.times(2)).info("Method isArmstrongNumber executed successfully");
    }

    @Test
    public void testIsPalindrome() {
        int palindromeNumber = 121;
        int nonPalindromeNumber = 123;
        calculationTaskService.isPalindrome(palindromeNumber);
        calculationTaskService.isPalindrome(nonPalindromeNumber);
        Mockito.verify(logger, Mockito.times(2)).info("Method isPalindrome executed successfully");
    }

    @Test
    public void testGetFactorial() {
        int number = 5;
        calculationTaskService.getFactorial(number);
        Mockito.verify(logger).info("Method getFactorial executed successfully");
    }

    @Test
    public void testGetReverse() {
        int number = 456;
        calculationTaskService.getReverse(number);
        Mockito.verify(logger).info("Method getReverse executed successfully");
    }
}
