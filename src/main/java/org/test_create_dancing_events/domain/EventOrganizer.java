package org.test_create_dancing_events.domain;

public record EventOrganizer(long id) {

    public EventOrganizer {
        if (id < 0) {
            throw new IllegalArgumentException("Event organizer id must be positive");
        }
    }
}
