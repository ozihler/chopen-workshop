package org.test_create_dancing_events.adapter.dataaccess;

import org.test_create_dancing_events.application.port.outbound.FetchUnpublishedDancingEvents;
import org.test_create_dancing_events.application.port.outbound.StoreUnpublishedDancingEvents;
import org.test_create_dancing_events.domain.EventOrganizer;
import org.test_create_dancing_events.domain.UnpublishedDancingEvents;

import java.util.ArrayList;
import java.util.Map;

public class InMemoryUnpublishedDancingEventsRepository implements FetchUnpublishedDancingEvents, StoreUnpublishedDancingEvents {
    private final Map<EventOrganizer, UnpublishedDancingEvents> unpublishedDancingEvents;

    public InMemoryUnpublishedDancingEventsRepository(Map<EventOrganizer, UnpublishedDancingEvents> unpublishedDancingEvents) {
        this.unpublishedDancingEvents = unpublishedDancingEvents;
    }

    @Override
    public UnpublishedDancingEvents fetchAllOfEventOrganizer(EventOrganizer eventOrganizer) {
        return this.unpublishedDancingEvents.getOrDefault(eventOrganizer, new UnpublishedDancingEvents(new ArrayList<>()));
    }

    @Override
    public void store(EventOrganizer eventOrganizer, UnpublishedDancingEvents unpublishedDancingEvents) {
        this.unpublishedDancingEvents.put(eventOrganizer, unpublishedDancingEvents);
    }
}
