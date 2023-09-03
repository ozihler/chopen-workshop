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

            UnpublishedDancingEvent unpublishedDancingEvent = createFrom(input);

            prevalidateUnpublishedDancingEvent.prevalidate(unpublishedDancingEvent);

            unpublishedDancingEvents.add(unpublishedDancingEvent);

            storeUnpublishedDancingEvents.store(unpublishedDancingEvents);

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
