/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.randomnumberguess;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Student
 */


public class Randomnumberguess {

    public static void main(String[] args) {
        Random randomGenerator = new Random(); // Instance of the random class
        int secretNumber = randomGenerator.nextInt(100) + 1;
        int userGuess = 0;
        int attempt = 0; //to track user attempts
        int maxAttempts = 3;
       
        while (userGuess != secretNumber && attempt < maxAttempts) {
            String input = JOptionPane.showInputDialog("Hey, guess a number between 1 and 100:");
            attempt++;
            // Handle case where user clicks "Cancel" or closes the dialog
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Game cancelled. The secret number was: " + secretNumber);
                return; // Exit the program safely
            }
           
            // Handle case where user types letters instead of numbers
            try {
                userGuess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid whole number.");
                continue; // Skip the rest of the loop and ask again
            }

            if (userGuess > secretNumber) {
                JOptionPane.showMessageDialog(null, "Your guess is too high.");
            } else if (userGuess < secretNumber) {
                JOptionPane.showMessageDialog(null, "Your guess is too low.");
            } else {
                JOptionPane.showMessageDialog(null, "Congrats! You win!");
                JOptionPane.showMessageDialog(null, "you won in "+ attempt+" attempts");
            }
        }
         JOptionPane.showMessageDialog(null, "You have reached max attempts, this is the secret number : "+ secretNumber);
    }
}
