package org.creatingdancingevents.adapter.data_access;

import org.creatingdancingevents.application.ports.outbound.FetchUnpublishedDancingEvents;
import org.creatingdancingevents.application.ports.outbound.StoreUnpublishedDancingEvents;
import org.creatingdancingevents.domain.aggregate.UnpublishedDancingEvents;
import org.creatingdancingevents.domain.value.EventOrganizerId;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDancingEventRepository
        implements
        FetchUnpublishedDancingEvents,
        StoreUnpublishedDancingEvents {
    private final Map<EventOrganizerId, UnpublishedDancingEvents> unpublishedDancingEvents = new HashMap<>();

    @Override
    public void forEventOrganizer(EventOrganizerId eventOrganizerId, UnpublishedDancingEvents unpublishedDancingEvents) {
        this.unpublishedDancingEvents.put(eventOrganizerId, unpublishedDancingEvents);
        System.out.println("Events in DB:"+ this.unpublishedDancingEvents);
    }

    @Override
    public UnpublishedDancingEvents forEventOrganizer(EventOrganizerId eventOrganizerId) {
        return unpublishedDancingEvents.getOrDefault(eventOrganizerId, new UnpublishedDancingEvents());
    }

}