package org.test_create_dancing_events;

import org.test_create_dancing_events.application.port.outbound.PresentDancingEventCreation;
import org.test_create_dancing_events.domain.UnpublishedDancingEvent;

public class TestPresenter implements PresentDancingEventCreation {
    private UnpublishedDancingEvent unpublishedDancingEvent;
    private Exception exception;

    @Override
    public void presentFailure(Exception e) {
        this.exception = e;
    }

    @Override
    public void presentSuccess(UnpublishedDancingEvent unpublishedDancingEvents) {
        this.unpublishedDancingEvent = unpublishedDancingEvents;
    }

    public UnpublishedDancingEvent getUnpublishedDancingEvent() {
        return unpublishedDancingEvent;
    }

    public Exception getException() {
        return exception;
    }
}

