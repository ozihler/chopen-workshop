package org.creatingdancingevents.application.ports.outbound;

import org.creatingdancingevents.domain.aggregate.UnpublishedDancingEvents;
import org.creatingdancingevents.domain.value.EventOrganizerId;

public interface StoreUnpublishedDancingEvents {
    void forEventOrganizer(EventOrganizerId eventOrganizerId, UnpublishedDancingEvents unpublishedDancingEvents);
}
