package student.inhertance;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleLogger implements Logger{

    Scanner scanner;
    public ConsoleLogger(Scanner sc){
        scanner = sc;
    }

    public int getInt() {

        do {
            String userInput = scanner.next();
            try {
                return Integer.parseInt(userInput);
            } catch (NumberFormatException ex) {
                System.err.println("Not a number!");
            }
        }
        while (true);
    }

    // practicing RE
    public String getCode( String regex ) {
        boolean valid = false;
        String code ="";

        while (!valid) {
            code = getString();
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(code);
            if (m.matches()) {
                valid = true;
            } else {
                System.out.println("Give me three digits");
            }
        }

        return code;
    }

    public LocalTime getTime() {
        do {
            String userInput = scanner.next();
            DateTimeFormatter strictTimeFormatter = DateTimeFormatter.ofPattern("HH:mm").withResolverStyle(ResolverStyle.STRICT);

            try {
                LocalTime time = LocalTime.parse(userInput, strictTimeFormatter);
                return time;
            } catch (DateTimeParseException | NullPointerException e) {
                System.out.println("Invalid time string. Give me HH:mm ");
            }
        }
        while (true);
    }


    public double getDouble() {
        do {
            String userInput = scanner.next();
            try {
                double number = Double.parseDouble(userInput);
                return number;
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format! n.n ");
            }
        }
        while (true);
    }

    public String getString() {
        return scanner.next();
    }


    @Override
    public void logMessage(String message){
        System.out.println(message);
    }
}
