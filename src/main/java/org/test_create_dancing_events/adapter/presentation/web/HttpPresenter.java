package org.test_create_dancing_events.adapter.presentation.web;

import org.springframework.http.ResponseEntity;
import org.test_create_dancing_events.adapter.presentation.web.dto.DancingEventDto;
import org.test_create_dancing_events.application.port.outbound.PresentDancingEventCreation;
import org.test_create_dancing_events.domain.UnpublishedDancingEvent;

public class HttpPresenter implements PresentDancingEventCreation {
    private UnpublishedDancingEvent unpublishedDancingEvent;

    @Override
    public void presentFailure(Exception e) {

    }

    @Override
    public void presentSuccess(UnpublishedDancingEvent unpublishedDancingEvent) {
        this.unpublishedDancingEvent = unpublishedDancingEvent;
    }

    ResponseEntity<DancingEventDto> getBody() {
        DancingEventDto dancingEventDto = new DancingEventDto(
                unpublishedDancingEvent.title().value(),
                unpublishedDancingEvent.description().value(),
                unpublishedDancingEvent.eventDate().value()
        );
        return ResponseEntity.ok(dancingEventDto);
    }
}
