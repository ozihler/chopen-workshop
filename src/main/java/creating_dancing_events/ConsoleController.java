package creating_dancing_events;

import java.util.Scanner;

public class ConsoleController {
    private final Scanner scanner;

    public ConsoleController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void execute() {
        do {
            prompt("Please enter the required details to create a dancing event.");

            // add use case here

        } while (askToContinueAddingDancingEvents());

        finishPrompt();
    }

    private boolean askToContinueAddingDancingEvents() {
        prompt("Do you want to add another dancing event? (y/n)");

        return scanner.nextLine().trim().equalsIgnoreCase("y");
    }

    private void finishPrompt() {
        prompt("Goodbye!");
        scanner.close();
    }

    private static void prompt(String x) {
        System.out.println(x);
    }
}
