package org.creatingdancingevents;

import org.creatingdancingevents.application.ports.outbound.FetchUnpublishedDancingEvents;
import org.creatingdancingevents.application.ports.outbound.StoreUnpublishedDancingEvents;
import org.creatingdancingevents.domain.aggregate.UnpublishedDancingEvents;
import org.creatingdancingevents.domain.value.EventOrganizerId;

public class TestUnpublishedDancingEventsRepository implements FetchUnpublishedDancingEvents, StoreUnpublishedDancingEvents {

    private  UnpublishedDancingEvents unpublishedDancingEvents = new UnpublishedDancingEvents();

    public UnpublishedDancingEvents getUnpublishedDancingEvents() {
        return unpublishedDancingEvents;
    }

    @Override
    public UnpublishedDancingEvents forEventOrganizer(EventOrganizerId eventOrganizerId) {
        return unpublishedDancingEvents;
    }

    @Override
    public void forEventOrganizer(EventOrganizerId eventOrganizerId, UnpublishedDancingEvents unpublishedDancingEvents) {
        this.unpublishedDancingEvents = unpublishedDancingEvents;
    }
}
