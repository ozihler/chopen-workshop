package org.test_create_dancing_events.application.port.outbound;

import org.test_create_dancing_events.domain.UnpublishedDancingEvent;

public interface PresentDancingEventCreation {
    void presentFailure(Exception e);

    void presentSuccess(UnpublishedDancingEvent unpublishedDancingEvents);
}
