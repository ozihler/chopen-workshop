package org.creatingdancingevents.application.use_case;

import org.creatingdancingevents.application.ports.inbound.CreateDancingEvent;
import org.creatingdancingevents.application.ports.outbound.*;
import org.creatingdancingevents.domain.aggregate.UnpublishedDancingEvents;
import org.creatingdancingevents.domain.entity.DancingEvent;
import org.creatingdancingevents.domain.value.Description;
import org.creatingdancingevents.domain.value.EventOrganizerId;
import org.creatingdancingevents.domain.value.Title;

public class CreateDancingEventUseCase implements CreateDancingEvent {

    private final FetchUnpublishedDancingEvents fetchUnpublishedDancingEvents;
    private final StoreUnpublishedDancingEvents storeUnpublishedDancingEvents;
    private final GetNextDancingEventId getNextDancingEventId;

    public CreateDancingEventUseCase(FetchUnpublishedDancingEvents fetchUnpublishedDancingEvents,
                                     StoreUnpublishedDancingEvents storeUnpublishedDancingEvents,
                                     GetNextDancingEventId getNextDancingEventId) {
        this.fetchUnpublishedDancingEvents = fetchUnpublishedDancingEvents;
        this.storeUnpublishedDancingEvents = storeUnpublishedDancingEvents;
        this.getNextDancingEventId = getNextDancingEventId;
    }

    @Override
    public void execute(DancingEventRecord input,
                        PresentCreatedDancingEvent presentSuccess,
                        PresentDancingEventCreationFailure presentFailure) {
        try {
            var eventOrganizerId = new EventOrganizerId(input.eventOrganizerId());
            DancingEvent dancingEvent = createFrom(input);
            UnpublishedDancingEvents unpublishedDancingEvents = fetchUnpublishedDancingEvents.forEventOrganizer(eventOrganizerId);

            unpublishedDancingEvents.add(dancingEvent);

            storeUnpublishedDancingEvents.forEventOrganizer(eventOrganizerId, unpublishedDancingEvents);

            presentSuccess.present(toOutput(dancingEvent));
        } catch (Exception e) {
            presentFailure.present(e);
        }

    }

    private static DancingEventRecord toOutput(DancingEvent dancingEvent) {
        return new DancingEventRecord(
                dancingEvent.getDancingEventId().id(),
                dancingEvent.getTitle().title(),
                dancingEvent.getDescription().description(),
                null);
    }

    private DancingEvent createFrom(DancingEventRecord input) {
        return new DancingEvent(getNextDancingEventId.nextId(),
                new Title(input.title()),
                new Description(input.description()));
    }
}
