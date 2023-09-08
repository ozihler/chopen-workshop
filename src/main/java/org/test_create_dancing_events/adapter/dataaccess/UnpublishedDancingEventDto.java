package org.test_create_dancing_events.adapter.dataaccess;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UnpublishedDancingEventDto(
        String title,
        String description,
        @JsonProperty("event_date")
        String eventDate
) {
}
