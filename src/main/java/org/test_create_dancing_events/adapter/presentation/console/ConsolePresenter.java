package org.test_create_dancing_events.adapter.presentation.console;

import org.test_create_dancing_events.application.port.outbound.PresentDancingEventsCreation;
import org.test_create_dancing_events.domain.UnpublishedDancingEvent;

public class ConsolePresenter implements PresentDancingEventsCreation {
    @Override
    public void presentFailure(Exception e) {
        System.err.println(e.getMessage());
    }

    @Override
    public void presentSuccess(UnpublishedDancingEvent unpublishedDancingEvent) {
        System.out.println("Event created successfully!");
        System.out.println("Event details:");
        System.out.println(format(unpublishedDancingEvent));
    }

    private static String format(UnpublishedDancingEvent unpublishedDancingEvent) {
        return "Title: " + unpublishedDancingEvent.title().value() + "\n" +
                "Description: " + unpublishedDancingEvent.description().value() + "\n" +
                "Event date: " + unpublishedDancingEvent.eventDate().value() + "\n";
    }
}
