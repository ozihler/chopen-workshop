package org.creatingdancingevents;

import org.creatingdancingevents.application.ports.outbound.StoreDancingEvent;
import org.creatingdancingevents.domain.entity.DancingEvent;

public class TestStoreDancingEvent implements StoreDancingEvent {

    private DancingEvent dancingEvent;

    public DancingEvent get() {
        return dancingEvent;
    }

    @Override
    public DancingEvent store(DancingEvent dancingEvent) {
        this.dancingEvent = dancingEvent;
        return dancingEvent;
    }
}
