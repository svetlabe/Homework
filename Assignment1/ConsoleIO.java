package reskillAssignmentOne;

/*
Vi kan slette de som vi ikke trenger etterpå,
beholder alle som jeg brukte tidligere forløpig.
P.t. tror jeg at vi trenger kun getInt() for å få valg fra brukeren
 */

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleIO implements IO {

    Scanner scanner;
    public ConsoleIO(Scanner sc){
        scanner = sc;
    }

    // We can use this in the menu when we need to get correct user choice
    @Override
    public int getInt(String message) {
        do {
            logMessage(message);
            String userInput = scanner.next();
            try {
                return Integer.parseInt(userInput);
            } catch (NumberFormatException ex) {
                System.err.println("Not a number!");
            }
        }
        while (true);
    }


    // Use this to print output on the screen
    @Override
    public void logMessage(String message){
        System.out.println(message);
    }

    @Override
    public String getString(String message) {
        logMessage(message);

        return scanner.next();
    }

    @Override
    public long getLong(String message){
        do {
            logMessage(message);
            String userInput = scanner.next();
            try {
                return Long.parseLong(userInput);
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format! Try again");
            }
        }
        while (true);
    }
}
