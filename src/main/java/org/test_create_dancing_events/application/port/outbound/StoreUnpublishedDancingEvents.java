package org.test_create_dancing_events.application.port.outbound;

import org.test_create_dancing_events.domain.UnpublishedDancingEvents;

public interface StoreUnpublishedDancingEvents {
    void store(UnpublishedDancingEvents unpublishedDancingEvents);
}
