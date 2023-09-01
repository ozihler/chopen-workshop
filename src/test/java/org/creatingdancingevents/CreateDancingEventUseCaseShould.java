package org.creatingdancingevents;

import org.creatingdancingevents.application.ports.outbound.DancingEventRecord;
import org.creatingdancingevents.application.ports.outbound.PresentCreatedDancingEvent;
import org.creatingdancingevents.application.use_case.CreateDancingEventUseCase;
import org.creatingdancingevents.domain.entity.DancingEvent;
import org.creatingdancingevents.domain.value.DancingEventId;
import org.creatingdancingevents.domain.value.Description;
import org.creatingdancingevents.domain.value.Title;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateDancingEventUseCaseShould {
    @Test
    public void create_a_dancing_event() {
        String testId = "de-1";
        String eventOrganizerIdS = "eo-1";
        DancingEventRecord input = new DancingEventRecord(null, "Title", "Description", eventOrganizerIdS);
        var presenter = new TestCreateDancingEventPresenter();

        TestUnpublishedDancingEventsRepository repo = new TestUnpublishedDancingEventsRepository();
        var useCase = new CreateDancingEventUseCase(
                repo, repo);

        useCase.execute(input, presenter, null);

        assertEquals(testId, presenter.presentedDancingEvent().id());
    }

    @Test
    public void store_a_dancing_event_within_unpublished_dancing_events_of_a_user() {
        String testId = "de-1";
        DancingEventRecord input = new DancingEventRecord(null, "Title", "Description", "eo-1");

        PresentCreatedDancingEvent presenter = dancingEvent -> {
        };
        var dancingEventsRepository = new TestUnpublishedDancingEventsRepository();

        var useCase = new CreateDancingEventUseCase(
                dancingEventsRepository,
                dancingEventsRepository
        );

        useCase.execute(input, presenter, null);

        var unpublishedDancingEvents = dancingEventsRepository.getUnpublishedDancingEvents();

        assertEquals(List.of(new DancingEvent(
                        new DancingEventId(testId),
                        new Title("Title"),
                        new Description("Description")
                ))
                , unpublishedDancingEvents.getAll());
    }

    @Test
    void allow_only_to_add_max_5_new_dancing_events_per_event_organizer() {

        var dancingEventsRepository = new TestUnpublishedDancingEventsRepository();

        var useCase = new CreateDancingEventUseCase(
                dancingEventsRepository,
                dancingEventsRepository
        );

        for (int i = 0; i < 5; i++) {
            useCase.execute(new DancingEventRecord(null, "Title", "Description", "eo-1"), Assertions::assertNotNull, null);
        }

        useCase.execute(new DancingEventRecord(null, "Title", "Description", "eo-1"), null, Assertions::assertNotNull);
    }

    @Test
    void allow_different_event_organizers_to_each_have_max_5_new_dancing_events() {

        var dancingEventsRepository = new InMemoryDancingEventRepository();

        var useCase = new CreateDancingEventUseCase(
                dancingEventsRepository,
                dancingEventsRepository
        );

        for (int i = 0; i < 5; i++) {
            useCase.execute(new DancingEventRecord(null, "Title", "Description", "eo-1"), Assertions::assertNotNull, null);
            useCase.execute(new DancingEventRecord(null, "Title", "Description", "eo-2"), Assertions::assertNotNull, null);
        }
        useCase.execute(new DancingEventRecord(null, "Title", "Description", "eo-1"), null, Assertions::assertNotNull);

        useCase.execute(new DancingEventRecord(null, "Title", "Description", "eo-2"), null, Assertions::assertNotNull);
    }

}
