package org.test_create_dancing_events.domain;

import java.util.Objects;

public record EventOrganizer(long id) {

    public EventOrganizer {
        if (id < 0) {
            throw new IllegalArgumentException("Event organizer id must be positive");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventOrganizer that = (EventOrganizer) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
