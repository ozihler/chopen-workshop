package org.test_create_dancing_events.domain;

public class EventOrganizer {
    private final long id;

    public EventOrganizer(long id) {
        this.id = id;
        if(id < 0) {
            throw new IllegalArgumentException("Event organizer id must be positive");
        }
    }

    public long getId() {
        return id;
    }
}
