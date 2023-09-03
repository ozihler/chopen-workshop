package org.test_create_dancing_events.domain;

public class UnpublishedDancingEvent {

    private final Title title;
    private final Description description;
    private final EventDate eventDate;

    public UnpublishedDancingEvent(Title title, Description description, EventDate eventDate) {
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
    }

    public Description getDescription() {
        return description;
    }

    public Title getTitle() {
        return title;
    }

    public EventDate getEventDate() {
        return eventDate;
    }
}
