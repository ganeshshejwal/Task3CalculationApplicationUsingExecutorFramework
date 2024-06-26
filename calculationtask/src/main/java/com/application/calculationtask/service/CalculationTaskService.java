package com.application.calculationtask.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculationTaskService{

    private static final Logger logger= LoggerFactory.getLogger(CalculationTaskService.class);

    
    public void getSquare(int number) {
        int square=number*number;
        logger.info("Method getSquare executed successfully");
        System.out.println("Square of "+number+" = "+square);
    }

    public void getCube(int number) {
        int cube = number*number*number;
        logger.info("Method getCube executed successfully");
        System.out.println("Cube of "+number+" = "+cube);
    }

    public void isEvenOrOdd(int number) {
        String result=(number % 2 == 0)?"Even":"Odd";
        logger.info("Method isEvenOrOdd executed successfully");
        System.out.println(number+" is "+result);
    }

    public void isPrime(int number) {
        boolean isPrime = true;
        if (number<=1) {
            isPrime=false;
        } else {
            for (int i=2;i<=Math.sqrt(number);i++) {
                if (number%i==0) {
                    isPrime=false;
                    break;
                }
            }
        }
        logger.info("Method isPrime executed successfully");
       System.out.println(number+" is "+(isPrime ?"Prime":"Not Prime"));
    }

    public void isArmstrongNumber(int number) {
        int original=number;
        int sum=0;
        int digits=String.valueOf(number).length();
        int temp=number;
        while (temp>0) {
            int digit=temp%10;
            sum+=Math.pow(digit, digits);
            temp/=10;
        }
        boolean isArmstrong=(original == sum);
        logger.info("Method isArmstrongNumber executed successfully");
        System.out.println(number+" is "+(isArmstrong?"Armstrong":"Not Armstrong"));
    }

    public void isPalindrome(int number) {
        int original=number;
        int reverse=0;
        int temp=number;
        while (temp>0) {
            int digit=temp%10;
            reverse=reverse*10+digit;
            temp/=10;
        }
        boolean isPalindrome=(original == reverse);
        logger.info("Method isPalindrome executed successfully");
        System.out.println(number+" is "+(isPalindrome?"Palindrome":"Not Palindrome"));
    }

    public void  getFactorial(int number) {
        int fact=1;
        for (int i=1;i<=number;i++) {
            fact*=i;
        }
        logger.info("Method getFactorial executed successfully");
        System.out.println("Factorial of "+number+" = "+fact);
    }

    public void getReverse(int number) {
        int rev=0;
        int temp=number;
        while (temp>0){
            rev=rev*10+temp%10;
            temp/=10;
        }
        logger.info("Method getReverse executed successfully");
        System.out.println("Reverse of "+number+" = "+rev);
    }
}
