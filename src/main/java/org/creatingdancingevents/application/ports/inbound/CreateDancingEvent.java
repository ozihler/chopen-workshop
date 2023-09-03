package org.creatingdancingevents.application.ports.inbound;

import org.creatingdancingevents.application.ports.outbound.DancingEventInput;
import org.creatingdancingevents.application.ports.outbound.PresentCreatedDancingEvent;
import org.creatingdancingevents.application.ports.outbound.PresentDancingEventCreationFailure;

public interface CreateDancingEvent {
    void execute(DancingEventInput input, PresentCreatedDancingEvent presentSuccess, PresentDancingEventCreationFailure presentFailure);
}
