package org.creatingdancingevents;

import org.creatingdancingevents.application.ports.outbound.DancingEventInput;
import org.creatingdancingevents.application.ports.outbound.DancingEventOutput;
import org.creatingdancingevents.application.ports.outbound.PresentCreatedDancingEvent;

public class TestCreateDancingEventPresenter implements PresentCreatedDancingEvent {
    private DancingEventOutput dancingEvent;

    @Override
    public void present(DancingEventOutput dancingEvent) {
        this.dancingEvent = dancingEvent;
    }

    public DancingEventOutput presentedDancingEvent() {
        return dancingEvent;
    }
}
