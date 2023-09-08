package org.test_create_dancing_events.adapter.dataaccess;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UnpublishedDancingEventsJson(
        @JsonProperty("unpublished_dancing_events_per_event_organizer")
        List<UnpublishedDancingEventsPerEventOrganizerDto> unpublishedDancingEventsPerEventOrganizer
) {

}
