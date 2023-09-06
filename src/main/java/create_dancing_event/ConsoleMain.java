package create_dancing_event;

import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        var consoleController = new ConsoleController(new Scanner(System.in));

        consoleController.execute();
    }
}
