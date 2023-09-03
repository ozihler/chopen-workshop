package org.test_create_dancing_events.application.port.inbound;

import org.test_create_dancing_events.application.port.inbound.CreateDancingEventInput;
import org.test_create_dancing_events.application.port.outbound.PresentDancingEventsCreation;

public interface CreateDancingEvent {
    void execute(CreateDancingEventInput input, PresentDancingEventsCreation presenter);
}
