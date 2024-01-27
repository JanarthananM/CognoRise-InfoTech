package com.JavaDevelopmentTask.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame
{

    private static final List<String> words = new ArrayList<>(List.of("apple", "banana", "orange", "computer", "science"));
    private static final int MAX_WRONG_GUESSES = 6;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			Random random = new Random();

			String word = words.get(random.nextInt(words.size()));
			char[] hiddenWord = new char[word.length()];
			for (int i = 0; i < word.length(); i++) {
			    hiddenWord[i] = '-';
			}

			int wrongGuesses = 0;
			List<Character> guessedLetters = new ArrayList<>();

			while (wrongGuesses < MAX_WRONG_GUESSES && !isWordGuessed(hiddenWord)) {
			    printHangman(wrongGuesses);
			    printWord(hiddenWord);
			    System.out.print("Guess a letter: ");
			    char guess = scanner.next().charAt(0);
			    guessedLetters.add(guess);

			    if (word.contains(String.valueOf(guess))) {
			        updateWord(word, hiddenWord, guess);
			    } else {
			        wrongGuesses++;
			        System.out.println("Incorrect guess.");
			    }
			}

			if (isWordGuessed(hiddenWord)) {
			    System.out.println("Congratulations! You guessed the word: " + word);
			} else {
			    printHangman(MAX_WRONG_GUESSES);
			    System.out.println("You lost! The word was: " + word);
			}
		}
    }

    // Helper methods
    private static void printHangman(int wrongGuesses) {
        // Implement ASCII art for hangman based on wrongGuesses
        // ...
    }

    private static void printWord(char[] hiddenWord) {
        System.out.println("Word: " + String.valueOf(hiddenWord));
    }

    private static void updateWord(String word, char[] hiddenWord, char guess) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                hiddenWord[i] = guess;
            }
        }
    }

    private static boolean isWordGuessed(char[] hiddenWord) {
        for (char c : hiddenWord) {
            if (c == '-') {
                return false;
            }
        }
        return true;
    }
}