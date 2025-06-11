package menu.terminalhandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInteractor {
    public static Integer getIntegerValueFromUser(Scanner scanner, Runnable printFunctions){
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            ConsoleHandler.invalidOption();
            printFunctions.run();
            return getIntegerValueFromUser(scanner, printFunctions);
        }
    }

    public static Date getDateValueFromUser(Scanner scanner, Runnable printFunctions) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
        } catch (ParseException e) {
            ConsoleHandler.invalidOption();
            printFunctions.run();
            return getDateValueFromUser(scanner, printFunctions);
        }
    }
}
