package com.JavaDevelopmentTask.java;

import java.util.Scanner;

public class CalculatorApp
{
    public static void main(String[] args) 
{
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the first number: ");
			double num1 = scanner.nextDouble();

			System.out.print("Enter the second number: ");
			double num2 = scanner.nextDouble();

			System.out.print("Enter the operator (+, -, *, /): ");
			char operator = scanner.next().charAt(0);

			try {
			    double result = 0;
			    switch (operator) {
			        case
 
'+':
			            result = num1 + num2;
			            break;
			        case
 
'-':
			            result = num1 - num2;
			            break;
			        case
 
'*':
			            result = num1 * num2;
			            break;
			        case
 
'/':
			            if (num2 == 0) {
			                throw
 
new ArithmeticException("Division by zero");
			            }
			            result = num1 / num2;
			            break;
			        default:
			            System.out.println("Invalid operator");
			            return;
			    }

			    System.out.println("Result: " + result);
			} catch (ArithmeticException e) {
			    System.out.println("Error: " + e.getMessage());
			}
		}
    }
}
