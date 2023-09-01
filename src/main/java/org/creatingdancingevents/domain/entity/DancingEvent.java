package org.creatingdancingevents.domain.entity;

import org.creatingdancingevents.domain.value.Description;
import org.creatingdancingevents.domain.value.DancingEventId;
import org.creatingdancingevents.domain.value.Title;

import java.util.Objects;

public class DancingEvent {
    private final DancingEventId dancingEventId;
    private final Title title;
    private final Description description;

    public DancingEvent(DancingEventId dancingEventId, Title title, Description description) {
        this.dancingEventId = dancingEventId;
        this.title = title;
        this.description = description;
    }

    public DancingEventId getDancingEventId() {
        return dancingEventId;
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DancingEvent that = (DancingEvent) o;
        return Objects.equals(dancingEventId, that.dancingEventId) && Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dancingEventId, title, description);
    }

    @Override
    public String toString() {
        return "DancingEvent{" +
                "dancingEventId=" + dancingEventId +
                ", title=" + title +
                ", description=" + description +
                '}';
    }
}
