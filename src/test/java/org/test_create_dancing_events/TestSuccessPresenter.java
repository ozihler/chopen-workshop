package org.test_create_dancing_events;

import org.test_create_dancing_events.domain.UnpublishedDancingEvent;

public class TestSuccessPresenter {
    private UnpublishedDancingEvent unpublishedDancingEvent;

    public void present(UnpublishedDancingEvent unpublishedDancingEvent) {

        this.unpublishedDancingEvent = unpublishedDancingEvent;
    }

    public UnpublishedDancingEvent getValue() {
        return unpublishedDancingEvent;
    }
}
