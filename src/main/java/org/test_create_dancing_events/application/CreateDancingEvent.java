package org.test_create_dancing_events.application;

import org.test_create_dancing_events.application.port.CreateDancingEventInput;
import org.test_create_dancing_events.application.port.outbound.PresentDancingEventsCreation;

public interface CreateDancingEvent {
    void execute(CreateDancingEventInput input, PresentDancingEventsCreation presenter);
}
