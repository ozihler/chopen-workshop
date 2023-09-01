package org.creatingdancingevents.application.ports.outbound;

public interface PresentCreatedDancingEvent {
    void present(DancingEventRecord dancingEvent);
}
