package org.test_create_dancing_events.infrastructure;

import org.test_create_dancing_events.adapter.dataaccess.FileSystemDancingEventRepository;
import org.test_create_dancing_events.adapter.dataaccess.InMemoryUnpublishedDancingEventsRepository;
import org.test_create_dancing_events.adapter.dataaccess.LocalValidationGateway;
import org.test_create_dancing_events.adapter.presentation.console.ConsoleController;
import org.test_create_dancing_events.adapter.presentation.console.ConsolePresenter;
import org.test_create_dancing_events.application.CreateDancingEventUseCase;

import java.util.HashMap;
import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        var prevalidator = new LocalValidationGateway();
        var repo = new FileSystemDancingEventRepository();

        var createDancingEvent = new CreateDancingEventUseCase(repo, repo, prevalidator);

        ConsoleController console = new ConsoleController(createDancingEvent, new ConsolePresenter(), new Scanner(System.in));

        console.execute();
    }
}
