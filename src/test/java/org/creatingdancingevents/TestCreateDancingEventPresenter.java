package org.creatingdancingevents;

import org.creatingdancingevents.application.ports.outbound.DancingEventRecord;
import org.creatingdancingevents.application.ports.outbound.PresentCreatedDancingEvent;

public class TestCreateDancingEventPresenter implements PresentCreatedDancingEvent {
    private DancingEventRecord dancingEvent;

    @Override
    public void present(DancingEventRecord dancingEvent) {
        this.dancingEvent = dancingEvent;
    }

    public DancingEventRecord presentedDancingEvent() {
        return dancingEvent;
    }
}
