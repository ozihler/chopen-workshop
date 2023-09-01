package org.creatingdancingevents.application.ports.outbound;

public record DancingEventRecord(String id, String title, String description, String eventOrganizerId) {
}
