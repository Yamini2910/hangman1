import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String username = null;
        String password = null;

        try {
            File file = new File("secret");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("username: ")) {
                    username = line.substring(10);
                } else if (line.startsWith("password: ")) {
                    password = line.substring(10);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("File \"secret\" is not found");
            System.exit(1);
        }

        if (username == null || password == null) {
            System.out.println("File's format is incorrect");
            System.exit(1);
        }

        if (!username.equals("admin") || !password.equals("!ha2n4gm0an!")) {
            System.out.println("Username or password are incorrect");
            System.exit(1);
        }

        System.out.println("Welcome to Hangman!");

        Hangman hangman = new Hangman();
        Scanner scanner = new Scanner(System.in);

        while (!hangman.gameover()) {
            System.out.println("Word: " + hangman.display());
            System.out.println("Attempts remaining: " + hangman.getattempts());
            System.out.print("Guess a letter: ");
            String input = scanner.nextLine();
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Invalid input. Please enter a single letter.");
                continue;
            }
            char letter = input.charAt(0);
            if (!hangman.guessletter(letter)) {
                System.out.println("Incorrect guess!");
            }
        }

        if (hangman.wordguess()) {
            System.out.println("Congratulations! You've guessed the word: " + hangman.display());
        } else {
            System.out.println("Sorry, you've run out of attempts. The word was: " + hangman.getword());
        }
    }
}
