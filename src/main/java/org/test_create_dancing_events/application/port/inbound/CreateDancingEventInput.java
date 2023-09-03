package org.test_create_dancing_events.application.port.inbound;

public record CreateDancingEventInput(String title, String description, String eventDate, long eventOrganizerId) {

}
