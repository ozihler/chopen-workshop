package org.test_create_dancing_events;

import org.test_create_dancing_events.application.port.outbound.FetchUnpublishedDancingEvents;
import org.test_create_dancing_events.application.port.outbound.StoreUnpublishedDancingEvents;
import org.test_create_dancing_events.domain.EventOrganizer;
import org.test_create_dancing_events.domain.UnpublishedDancingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestRepo implements FetchUnpublishedDancingEvents, StoreUnpublishedDancingEvents {
    final Map<EventOrganizer, UnpublishedDancingEvents> repo = new HashMap<>();

    @Override
    public UnpublishedDancingEvents fetchAllOfEventOrganizer(EventOrganizer eventOrganizer) {
        return repo.getOrDefault(eventOrganizer, new UnpublishedDancingEvents(new ArrayList<>()));
    }

    @Override
    public void store(EventOrganizer eventOrganizer, UnpublishedDancingEvents unpublishedDancingEvents) {
        this.repo.put(eventOrganizer, unpublishedDancingEvents);
    }
}
