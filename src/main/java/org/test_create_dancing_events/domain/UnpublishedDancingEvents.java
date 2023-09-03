package org.test_create_dancing_events.domain;

import org.test_create_dancing_events.domain.exception.NumberOfUnpublishedDancingEventsReachedMaxNumberException;

import java.util.List;

public class UnpublishedDancingEvents {
    private static final int MAX_NUMBER_OF_UNPUBLISHED_DANCING_EVENTS = 5;
    private final List<UnpublishedDancingEvent> unpublishedDancingEvents;

    public UnpublishedDancingEvents(List<UnpublishedDancingEvent> unpublishedDancingEvents) {
        this.unpublishedDancingEvents = unpublishedDancingEvents;
    }

    public void add(UnpublishedDancingEvent unpublishedDancingEvent) {
        if (numberOfAllowedUnpublishedDancingEventsExceeded()) {
            throw new NumberOfUnpublishedDancingEventsReachedMaxNumberException("Number of unpublished dancing events reached max number");
        }

        unpublishedDancingEvents.add(unpublishedDancingEvent);
    }

    private boolean numberOfAllowedUnpublishedDancingEventsExceeded() {
        return unpublishedDancingEvents.size() > MAX_NUMBER_OF_UNPUBLISHED_DANCING_EVENTS;
    }

    @Override
    public String toString() {
        return "UnpublishedDancingEvents{" +
                "unpublishedDancingEvents=" + unpublishedDancingEvents +
                '}';
    }
}
