package CODTECH;
import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        
	        int numberToGuess = random.nextInt(100) + 1; // Generates a random number between 1 and 100
	        int attempts = 0;
	        final int MAX_ATTEMPTS = 10; // Maximum number of attempts
	        
	        System.out.println("Welcome to the Number Guessing Game!");
	        System.out.println("I've picked a number between 1 and 100. Try to guess it within " + MAX_ATTEMPTS + " attempts.");

	        while (attempts < MAX_ATTEMPTS) {
	            System.out.print("Enter your guess: ");
	            int guess = scanner.nextInt();
	            attempts++;
	            
	            if (guess == numberToGuess) {
	                System.out.println("Congratulations! You've guessed the number " + numberToGuess + " correctly in " + attempts + " attempts.");
	                break;
	            } else if (guess < numberToGuess) {
	                System.out.println("Too low! Try again.");
	            } else {
	                System.out.println("Too high! Try again.");
	            }
	        }

	        if (attempts == MAX_ATTEMPTS) {
	            System.out.println("Sorry, you've used all your attempts. The number I picked was: " + numberToGuess);
	        }

	        scanner.close();
	    }
	}


