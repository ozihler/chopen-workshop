package org.test_create_dancing_events.application.port.outbound;

import org.test_create_dancing_events.domain.EventOrganizer;
import org.test_create_dancing_events.domain.UnpublishedDancingEvents;

public interface StoreUnpublishedDancingEvents {
    void store(EventOrganizer eventOrganizer, UnpublishedDancingEvents unpublishedDancingEvents);
}
