package org.creatingdancingevents.application.ports.outbound;

public record DancingEventInput(String title, String description, String eventOrganizerId) {
}
