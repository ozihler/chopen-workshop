package org.test_create_dancing_events.application.port.inbound;

import org.test_create_dancing_events.application.port.outbound.PresentDancingEventCreation;

public interface CreateDancingEvent {
    void execute(CreateDancingEventInput input, PresentDancingEventCreation presenter);
}
