package org.creatingdancingevents.adapter.presentation;

import org.creatingdancingevents.application.ports.inbound.CreateDancingEvent;
import org.creatingdancingevents.application.ports.outbound.DancingEventInput;
import org.creatingdancingevents.application.ports.outbound.PresentCreatedDancingEvent;
import org.creatingdancingevents.application.ports.outbound.PresentDancingEventCreationFailure;

import java.io.PrintStream;
import java.util.Scanner;


public class ConsoleController {
    private final CreateDancingEvent createDancingEvent;
    Scanner scanner;
    PrintStream out;

    public ConsoleController(Scanner scanner, PrintStream out, CreateDancingEvent createDancingEvent) {
        this.scanner = scanner;
        this.out = out;
        this.createDancingEvent = createDancingEvent;
    }

    public void execute() {
        do {
            DancingEventInput input = collectInputFromCommandLine();
            createDancingEvent.execute(input, successPresenter(), errorPresenter());
        } while (askUserToContinueOrFinish());
    }

    private DancingEventInput collectInputFromCommandLine() {
        out.println("Please enter the details for your event:");
        out.println("Event name:");
        String title = scanner.nextLine();

        out.println("Event description:");
        String description = scanner.nextLine();

        out.println("Event organizer id:");
        String eventOrganizer = scanner.nextLine();

        return new DancingEventInput(title, description, eventOrganizer);
    }

    private PresentCreatedDancingEvent successPresenter() {
        return dancingEvent -> {
            out.println("Your event has been created with id: " + dancingEvent.id());
            out.println("Here are the details:");
            out.println("Title: " + dancingEvent.title());
            out.println("Description: " + dancingEvent.description());
            out.println("Event organizer: " + dancingEvent.eventOrganizerId());
        };
    }

    private PresentDancingEventCreationFailure errorPresenter() {
        return e -> {
            out.println("There was an error creating your event: " + e.getMessage());
        };
    }

    private boolean askUserToContinueOrFinish() {
        out.println("Would you like to create another event? (y/n)");
        String answer = scanner.nextLine();
        return answer.equalsIgnoreCase("true")
                || answer.equalsIgnoreCase("y")
                || answer.equalsIgnoreCase("ye")
                || answer.equalsIgnoreCase("yeah")
                || answer.equalsIgnoreCase("yes");
    }
}
