package org.creatingdancingevents.application.ports.outbound;

import org.creatingdancingevents.domain.value.DancingEventId;

public interface GetNextDancingEventId {
    DancingEventId nextId();
}
