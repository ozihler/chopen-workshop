package org.test_create_dancing_events.application.port.outbound;

import org.test_create_dancing_events.domain.EventOrganizer;
import org.test_create_dancing_events.domain.UnpublishedDancingEvents;

public interface FetchUnpublishedDancingEvents {
    UnpublishedDancingEvents fetchAllOfEventOrganizer(EventOrganizer eventOrganizer);
}
