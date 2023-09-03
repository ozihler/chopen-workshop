package org.creatingdancingevents.application.ports.outbound;

public record DancingEventOutput(String id, String title, String description, String eventOrganizerId) {
}
