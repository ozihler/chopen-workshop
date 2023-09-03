package org.creatingdancingevents.application.use_case;

import org.creatingdancingevents.application.ports.inbound.CreateDancingEvent;
import org.creatingdancingevents.application.ports.outbound.*;
import org.creatingdancingevents.domain.aggregate.UnpublishedDancingEvents;
import org.creatingdancingevents.domain.entity.DancingEvent;
import org.creatingdancingevents.domain.value.DancingEventId;
import org.creatingdancingevents.domain.value.Description;
import org.creatingdancingevents.domain.value.EventOrganizerId;
import org.creatingdancingevents.domain.value.Title;

import java.util.Random;

public class CreateDancingEventUseCase implements CreateDancingEvent {

    private final FetchUnpublishedDancingEvents fetchUnpublishedDancingEvents;
    private final StoreUnpublishedDancingEvents storeUnpublishedDancingEvents;

    public CreateDancingEventUseCase(
            FetchUnpublishedDancingEvents fetchUnpublishedDancingEvents,
            StoreUnpublishedDancingEvents storeUnpublishedDancingEvents) {
        this.fetchUnpublishedDancingEvents = fetchUnpublishedDancingEvents;
        this.storeUnpublishedDancingEvents = storeUnpublishedDancingEvents;
    }

    @Override
    public void execute(DancingEventInput input,
                        PresentCreatedDancingEvent presentSuccess,
                        PresentDancingEventCreationFailure presentFailure) {
        try {
            var eventOrganizerId = new EventOrganizerId(input.eventOrganizerId());
            DancingEvent dancingEvent = createFrom(input);
            UnpublishedDancingEvents unpublishedDancingEvents = fetchUnpublishedDancingEvents.forEventOrganizer(eventOrganizerId);

            unpublishedDancingEvents.add(dancingEvent);

            storeUnpublishedDancingEvents.ofEventOrganizer(eventOrganizerId, unpublishedDancingEvents);

            presentSuccess.present(toOutput(dancingEvent, eventOrganizerId));
        } catch (Exception e) {
            presentFailure.present(e);
        }
    }

    private static DancingEventOutput toOutput(DancingEvent dancingEvent, EventOrganizerId eventOrganizerId) {
        return new DancingEventOutput(
                dancingEvent.getDancingEventId().id(),
                dancingEvent.getTitle().title(),
                dancingEvent.getDescription().description(),
                eventOrganizerId.id());
    }

    private DancingEvent createFrom(DancingEventInput input) {
        return new DancingEvent(
                new DancingEventId(String.valueOf(new Random().nextInt(100000))),
                new Title(input.title()),
                new Description(input.description()));
    }
}
