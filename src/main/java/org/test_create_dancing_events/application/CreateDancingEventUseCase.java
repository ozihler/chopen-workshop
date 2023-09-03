package org.test_create_dancing_events.application;

import org.test_create_dancing_events.application.port.CreateDancingEventInput;
import org.test_create_dancing_events.application.port.outbound.FetchUnpublishedDancingEvents;
import org.test_create_dancing_events.application.port.outbound.PresentDancingEventsCreation;
import org.test_create_dancing_events.application.port.outbound.PrevalidateUnpublishedDancingEvent;
import org.test_create_dancing_events.application.port.outbound.StoreUnpublishedDancingEvents;
import org.test_create_dancing_events.domain.*;

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
    public void execute(CreateDancingEventInput input, PresentDancingEventsCreation presenter) {
        try {

            UnpublishedDancingEvents unpublishedDancingEvents = fetchUnpublishedDancingEvents.fetchAllOfEventOrganizer(new EventOrganizer(input.eventOrganizerId()));

            Description description = new Description(input.description());
            Title title = new Title(input.title());
            EventDate eventDate = new EventDate(input.eventDate());

            UnpublishedDancingEvent unpublishedDancingEvent = new UnpublishedDancingEvent(title, description,eventDate);

            prevalidateUnpublishedDancingEvent.prevalidate(unpublishedDancingEvent);

            unpublishedDancingEvents.add(unpublishedDancingEvent);

            storeUnpublishedDancingEvents.store(unpublishedDancingEvents);

            presenter.presentSuccess(unpublishedDancingEvent);
        } catch (Exception e) {
            presenter.presentFailure(e);
        }
    }

}
