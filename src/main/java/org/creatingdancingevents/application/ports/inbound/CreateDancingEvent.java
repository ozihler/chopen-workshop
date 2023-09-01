package org.creatingdancingevents.application.ports.inbound;

import org.creatingdancingevents.application.ports.outbound.DancingEventRecord;
import org.creatingdancingevents.application.ports.outbound.PresentCreatedDancingEvent;
import org.creatingdancingevents.application.ports.outbound.PresentDancingEventCreationFailure;

public interface CreateDancingEvent {
    void execute(DancingEventRecord input, PresentCreatedDancingEvent presentSuccess, PresentDancingEventCreationFailure presentFailure);
}
