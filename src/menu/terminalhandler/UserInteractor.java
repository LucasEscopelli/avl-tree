package menu.terminalhandler;

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

}
