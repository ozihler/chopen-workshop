package org.test_create_dancing_events.application.port.outbound;

import org.test_create_dancing_events.domain.exception.PrevalidationFailedException;
import org.test_create_dancing_events.domain.UnpublishedDancingEvent;

public interface PrevalidateUnpublishedDancingEvent {
    void prevalidate(UnpublishedDancingEvent unpublishedDancingEvent) throws PrevalidationFailedException;
}
