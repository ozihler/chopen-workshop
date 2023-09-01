package org.creatingdancingevents.application.ports.outbound;

import org.creatingdancingevents.domain.entity.DancingEvent;

public interface StoreDancingEvent {
    DancingEvent store(DancingEvent dancingEvent);
}
