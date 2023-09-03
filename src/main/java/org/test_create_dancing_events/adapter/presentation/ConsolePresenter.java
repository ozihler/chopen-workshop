package org.test_create_dancing_events.adapter.presentation;

import org.test_create_dancing_events.application.port.outbound.PresentDancingEventsCreation;
import org.test_create_dancing_events.domain.UnpublishedDancingEvent;

public class ConsolePresenter implements PresentDancingEventsCreation {
    @Override
    public void presentFailure(Exception e) {
        System.err.println(e.getMessage());
    }

    @Override
    public void presentSuccess(UnpublishedDancingEvent unpublishedDancingEvent) {
        System.out.println(unpublishedDancingEvent);
    }
}
