package org.creatingdancingevents.domain.value;

import java.util.Objects;

public final class EventOrganizerId {
    private final String id;

    public EventOrganizerId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("EventOrganizerId cannot be null or blank");
        }
        this.id = id;
    }

    public String id() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (EventOrganizerId) obj;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "EventOrganizerId[" +
                "id=" + id + ']';
    }

}
