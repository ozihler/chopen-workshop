package org.creatingdancingevents.application.ports.outbound;

public interface PresentDancingEventCreationFailure {
    void present(Exception e);
}
