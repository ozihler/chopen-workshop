package org.test_create_dancing_events;

import org.test_create_dancing_events.adapter.dataaccess.InMemoryUnpublishedDancingEventsRepository;
import org.test_create_dancing_events.adapter.dataaccess.LocalValidationGateway;
import org.test_create_dancing_events.adapter.presentation.ConsoleController;
import org.test_create_dancing_events.adapter.presentation.ConsolePresenter;
import org.test_create_dancing_events.application.CreateDancingEventUseCase;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var prevalidator = new LocalValidationGateway();
        var repo = new InMemoryUnpublishedDancingEventsRepository(new HashMap<>());

        var createDancingEvent = new CreateDancingEventUseCase(repo, repo, prevalidator);

        ConsoleController console = new ConsoleController(createDancingEvent, new ConsolePresenter(), new Scanner(System.in));

        console.execute();
    }
}
