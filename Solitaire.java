/*
 * Class: CMSC 204 CRN 32235
 * Instructor: Gary Thai
 * Programmer: Sereen Sultana
 */

package Lab05_Iterator;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Solitaire {

	public static void main(String[] args) {

		Random rand = new Random();
		int num = rand.nextInt(89) + 10;

		ArrayList<Integer> solitaireGame = new ArrayList<Integer>();
		// Fill in each position with a random number
		for (int i = 0; i <= 20; i++) {
			num = rand.nextInt(89) + 10;
			// Each position should get its own random number
			solitaireGame.add(num);
		}

		// Print the values in the array list for the player
		System.out.println("Your numbers are as follows: ");
		for (int j = 0; j < solitaireGame.size(); j++) {
			int value = solitaireGame.get(j);
			System.out.print(value + " ");
		}

		ListIterator<Integer> firstValue = solitaireGame.listIterator();
		// Create a second iterator that starts at position 1
		ListIterator<Integer> secondValue = solitaireGame.listIterator(1);

		int firstNum = 0;
		int secondNum = 0;
		int count = 0;

		while ((firstValue.hasNext()) && (secondValue.hasNext())) {
			while ((firstValue.hasNext()) && (secondValue.hasNext())) {
			firstNum = firstValue.next();
			secondNum = secondValue.next();
			// Comparing the first digit of two adjacent values
			int firstFirstDigit = firstNum / 10;
			int secondFirstDigit = secondNum / 10;
			// Comparing the last digit of two adjacent values
			int firstLastDigit = firstNum % 10;
			int secondLastDigit = secondNum % 10;

			if ((firstFirstDigit == secondFirstDigit) || (firstLastDigit == secondLastDigit)) {

				firstValue.remove();
				firstNum = firstValue.next();

				firstValue.remove();

				// Find the index of the first iterator + 1
				int firstIndex = firstValue.nextIndex() + 1;

				// Use the first iterator's index + 1 as the index of the second iterator
				if (firstIndex < solitaireGame.size()) // Check if out of bounds
					secondValue = solitaireGame.listIterator(firstIndex);

				// Show the progress to the player
				System.out.println("\n\nYour current progress in the game is as follows: ");
				for (int j = 0; j < solitaireGame.size(); j++) {
					int value = solitaireGame.get(j);
					System.out.print(value + " ");
				}

			}

		
		}

		}

		if (solitaireGame.size() == 0) {
			System.out.println();
			System.out.println();
			System.out.println("Congrats you won!");
		} else {
			System.out.println();
			System.out.println("\nYour FINAL values in the game are as follows: ");
			for (int j = 0; j < solitaireGame.size(); j++) {
				int value = solitaireGame.get(j);
				System.out.print(value + " ");
			}
			System.out.println();
			System.out.println();
			System.out.println("You have no more moves. You have lost. \nPlease try again. Thank you.");
		}
	} // End of main method

} // End of class
