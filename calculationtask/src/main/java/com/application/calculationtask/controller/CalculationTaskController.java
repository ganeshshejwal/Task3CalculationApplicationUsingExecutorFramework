package com.application.calculationtask.controller;

import com.application.calculationtask.service.CalculationTaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.Scanner;

@RestController
public class CalculationTaskController{

    private static final Logger logger=LoggerFactory.getLogger(CalculationTaskController.class);

    Scanner sc = new Scanner(System.in);
    int number;
    
    public CalculationTaskController(){
        System.out.print("Enter Numner of Range Between 0 to 9999 : ");
        number=sc.nextInt();
    }

    @Autowired
    CalculationTaskService service;

    @GetMapping("/api")
    public ResponseEntity<String> calculateMethod() {
        
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        
        try {
            Future<?>[] futures={
                    executorService.submit(() -> service.getSquare(number)),
                    executorService.submit(() -> service.getCube(number)),
                    executorService.submit(() -> service.isEvenOrOdd(number)),
                    executorService.submit(() -> service.isPrime(number)),
                    executorService.submit(() -> service.isArmstrongNumber(number)),
                    executorService.submit(() -> service.isPalindrome(number)),
                    executorService.submit(() -> service.getFactorial(number)),
                    executorService.submit(() -> service.getReverse(number))
            };

            for (Future<?> future : futures) {
                future.get(); 
            }

            logger.info("All tasks executed successfully");
            return ResponseEntity.status(HttpStatus.OK).body("All tasks executed successfully.");

        } catch (InterruptedException | ExecutionException e) {
            logger.error("Error occurred while executing tasks: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while executing tasks.");
        } finally {
            executorService.shutdown();
        }
    }
}
