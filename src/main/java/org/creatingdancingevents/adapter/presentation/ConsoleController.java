package org.creatingdancingevents.adapter.presentation;

import org.creatingdancingevents.application.ports.inbound.CreateDancingEvent;
import org.creatingdancingevents.application.ports.outbound.DancingEventRecord;
import org.creatingdancingevents.application.ports.outbound.PresentCreatedDancingEvent;
import org.creatingdancingevents.application.ports.outbound.PresentDancingEventCreationFailure;

import java.io.PrintStream;
import java.util.Scanner;


public class ConsoleController {
    private final CreateDancingEvent useCase;
    Scanner scanner;
    PrintStream out;

    public ConsoleController(Scanner scanner, PrintStream out, CreateDancingEvent createDancingEvent) {
        this.scanner = scanner;
        this.out = out;
        useCase = createDancingEvent;
    }

    public void execute() {
        boolean continueOrFinish;
        do {
            out.println("Please enter the details for your event:");
            out.println("Event name:");
            String title = scanner.nextLine();

            out.println("Event description:");
            String description = scanner.nextLine();

            out.println("Event organizer id:");
            String eventOrganizer = scanner.nextLine();

            DancingEventRecord input = new DancingEventRecord(null, title, description, eventOrganizer);

            PresentCreatedDancingEvent presentSuccess = dancingEvent -> {
                out.println("Your event has been created with id: " + dancingEvent.id());
                out.println("Here are the details:");
                out.println("Title: " + dancingEvent.title());
                out.println("Description: " + dancingEvent.description());
                out.println("Event organizer: " + dancingEvent.eventOrganizerId());
            };
            PresentDancingEventCreationFailure presentFailure = e -> out.println("There was an error creating your event: " + e.getMessage());

            useCase.execute(input, presentSuccess, presentFailure);

            out.println("Would you like to create another event? (true/false)");
            continueOrFinish = scanner.nextLine().equals("true");
        } while (continueOrFinish);
    }


}
