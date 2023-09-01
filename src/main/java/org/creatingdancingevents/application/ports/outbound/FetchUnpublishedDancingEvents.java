package org.creatingdancingevents.application.ports.outbound;

import org.creatingdancingevents.domain.aggregate.UnpublishedDancingEvents;
import org.creatingdancingevents.domain.value.EventOrganizerId;

public interface FetchUnpublishedDancingEvents {
    UnpublishedDancingEvents forEventOrganizer(EventOrganizerId eventOrganizerId);
}
