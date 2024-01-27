package com.JavaDevelopmentTask.java;
import java.util.Random;
 
import java.util.Scanner;

public class NumberGuessingGame
{
  public static void
 
main(String[] args)
 
{
    Random rand = new Random();

    
int numberToGuess = rand.nextInt(100) + 1;
    int guessCount = 0;
    int maxGuesses = 10;

    try (Scanner scanner = new Scanner(System.in)) {
		while (guessCount < maxGuesses) {
		  System.out.println("Guess a number between 1 and 100:");
		  int guess = scanner.nextInt();
		  guessCount++;

		  if (guess == numberToGuess) {
		    System.out.println("Congratulations! You guessed the number in " + guessCount + " tries!");
		    break;
		  } else if (guess < numberToGuess) {
		    System.out.println("Too low! Try again.");
		  } else {
		    System.out.println("Too high! Try again.");
		  }
		}
	}

    if (guessCount == maxGuesses) {
      System.out.println("Sorry, you ran out of guesses. The number was " + numberToGuess);
    }
  }
}

