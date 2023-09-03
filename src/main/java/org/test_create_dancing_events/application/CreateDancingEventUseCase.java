package org.test_create_dancing_events.application;

import org.springframework.stereotype.Component;
import org.test_create_dancing_events.application.port.inbound.CreateDancingEvent;
import org.test_create_dancing_events.application.port.inbound.CreateDancingEventInput;
import org.test_create_dancing_events.application.port.outbound.FetchUnpublishedDancingEvents;
import org.test_create_dancing_events.application.port.outbound.PresentDancingEventCreation;
import org.test_create_dancing_events.application.port.outbound.PrevalidateUnpublishedDancingEvent;
import org.test_create_dancing_events.application.port.outbound.StoreUnpublishedDancingEvents;
import org.test_create_dancing_events.domain.*;

@Component
public class CreateDancingEventUseCase implements CreateDancingEvent {

    private final FetchUnpublishedDancingEvents fetchUnpublishedDancingEvents;
    private final StoreUnpublishedDancingEvents storeUnpublishedDancingEvents;
    private final PrevalidateUnpublishedDancingEvent prevalidateUnpublishedDancingEvent;


    public CreateDancingEventUseCase(FetchUnpublishedDancingEvents fetchUnpublishedDancingEvents, StoreUnpublishedDancingEvents storeUnpublishedDancingEvents, PrevalidateUnpublishedDancingEvent prevalidateUnpublishedDancingEvent) {
        this.fetchUnpublishedDancingEvents = fetchUnpublishedDancingEvents;
        this.storeUnpublishedDancingEvents = storeUnpublishedDancingEvents;
        this.prevalidateUnpublishedDancingEvent = prevalidateUnpublishedDancingEvent;
    }

    @Override
    public void execute(CreateDancingEventInput input, PresentDancingEventCreation presenter) {
        try {
            EventOrganizer eventOrganizer = new EventOrganizer(input.eventOrganizerId());

            UnpublishedDancingEvents unpublishedDancingEvents = fetchUnpublishedDancingEvents.fetchAllOfEventOrganizer(eventOrganizer);

            UnpublishedDancingEvent unpublishedDancingEvent = createFrom(input);

            prevalidateUnpublishedDancingEvent.prevalidate(unpublishedDancingEvent);

            unpublishedDancingEvents.add(unpublishedDancingEvent);

            storeUnpublishedDancingEvents.store(eventOrganizer, unpublishedDancingEvents);

            presenter.presentSuccess(unpublishedDancingEvent);
        } catch (Exception e) {
            presenter.presentFailure(e);
        }
    }

    private static UnpublishedDancingEvent createFrom(CreateDancingEventInput input) {
        Description description = new Description(input.description());
        Title title = new Title(input.title());
        EventDate eventDate = new EventDate(input.eventDate());

        return new UnpublishedDancingEvent(title, description,eventDate);
    }

}
