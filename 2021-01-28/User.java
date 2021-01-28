package no.dnb.OnlineRetailer;

import java.util.Scanner;

public class User {

    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(String message) {
        do {
            System.out.print(message);
            String userInput = scanner.next();
            try {
                int number = Integer.parseInt(userInput);
                return number;
            } catch (NumberFormatException ex) {
                System.err.println("Not a number!");
            }
        }
        while (true);
    }

    public static double getDouble(String message) {
        do {
            System.out.print(message);
            String userInput = scanner.next();
            try {
                double number = Double.parseDouble(userInput);
                return number;
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format! Try again");
            }
        }
        while (true);
    }

    public static String getString(String message) {
        System.out.print(message);

        return scanner.next();
    }

    public static int getInt(String message, int min, int max) {
        do {
            System.out.print(message);
            String userInput = scanner.next();
            try {
                int number = Integer.parseInt(userInput);
                if (number >= min && number <= max) {
                    return number;
                }
            } catch (NumberFormatException ex) {
                //System.err.println("Not a number!");
            }
        }
        while (true);
    }


}
