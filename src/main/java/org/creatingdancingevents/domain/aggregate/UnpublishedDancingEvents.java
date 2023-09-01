package org.creatingdancingevents.domain.aggregate;

import org.creatingdancingevents.domain.entity.DancingEvent;

import java.util.ArrayList;
import java.util.List;

public class UnpublishedDancingEvents {

    private final List<DancingEvent> unpublishedDancingEvents = new ArrayList<>();

    public List<DancingEvent> getAll() {
        return unpublishedDancingEvents;
    }

    public void add(DancingEvent dancingEvent) {
        if (unpublishedDancingEvents.size() >= 5) {
            throw new IllegalStateException("Maximum number of unpublished dancing events reached");
        }
        this.unpublishedDancingEvents.add(dancingEvent);
    }
}
