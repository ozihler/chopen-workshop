package org.test_create_dancing_events.adapter.dataaccess;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UnpublishedDancingEventsPerEventOrganizerDto(
        @JsonProperty("id") String eventOrganizerId,
        @JsonProperty("unpublished_dancing_events") List<UnpublishedDancingEventDto> unpublishedDancingEvents
) {
}
