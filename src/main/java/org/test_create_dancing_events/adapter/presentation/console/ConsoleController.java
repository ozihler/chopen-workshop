package org.test_create_dancing_events.adapter.presentation.console;

import org.test_create_dancing_events.application.port.inbound.CreateDancingEvent;
import org.test_create_dancing_events.application.port.inbound.CreateDancingEventInput;

import java.util.Scanner;

public class ConsoleController {
    private final Scanner scanner;
    private final ConsolePresenter presenter;
    private final CreateDancingEvent createDancingEvent;

    public ConsoleController(CreateDancingEvent createDancingEvent, ConsolePresenter presenter, Scanner scanner) {
        this.createDancingEvent = createDancingEvent;
        this.scanner = scanner;
        this.presenter = presenter;
    }

    public void execute() {
        do {
            CreateDancingEventInput input = askEventOrganizerForInput();
            createDancingEvent.execute(input, presenter);
        } while (shouldContinue());

        cleanUps();
    }

    private void cleanUps() {
        System.out.println("Goodbye!");
        scanner.close();
    }

    private CreateDancingEventInput askEventOrganizerForInput() {
        System.out.println("Please enter the following information to create a new dancing event:");
        System.out.println("Title:");
        String title = scanner.nextLine();
        System.out.println("Description:");
        String description = scanner.nextLine();
        System.out.println("Date (yyyy-mm-dd):");
        String date = scanner.nextLine();
        System.out.println("Event organizer id:");
        String eventOrganizerId = scanner.nextLine();

        return new CreateDancingEventInput(
                title,
                description,
                date,
                Integer.parseInt(eventOrganizerId));
    }

    private boolean shouldContinue() {
        System.out.println("Do you want to create another dancing event? (y/n)");
        return scanner.nextLine().equals("y");
    }
}
