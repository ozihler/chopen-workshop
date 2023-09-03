package org.test_create_dancing_events;

import org.junit.jupiter.api.Test;
import org.test_create_dancing_events.application.CreateDancingEventUseCase;
import org.test_create_dancing_events.application.port.inbound.CreateDancingEventInput;
import org.test_create_dancing_events.application.port.outbound.PrevalidateUnpublishedDancingEvent;
import org.test_create_dancing_events.domain.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateDancingEventUseCaseShould {
    @Test
    void create_a_dancing_event() {
        var testRepo = new TestRepo();
        var useCase = new CreateDancingEventUseCase(testRepo, testRepo, prevalidateDummy());
        var input = createInput();
        var testPresenter = new TestPresenter();

        useCase.execute(input, testPresenter);

        assertEquals(new UnpublishedDancingEvents(List.of(from(input))), testRepo.repo.get(new EventOrganizer(input.eventOrganizerId())));
        assertEquals(from(input), testPresenter.getUnpublishedDancingEvent());
    }

    private static UnpublishedDancingEvent from(CreateDancingEventInput input) {
        return new UnpublishedDancingEvent(
                new Title(input.title()),
                new Description(input.description()),
                new EventDate(input.eventDate()));
    }

    private static CreateDancingEventInput createInput() {
        String title = "title";
        String description = "description";
        String date = "2021-01-01";
        int eventOrganizerId = 1;
        return new CreateDancingEventInput(title, description, date, eventOrganizerId);
    }

    private static PrevalidateUnpublishedDancingEvent prevalidateDummy() {
        return unpublishedDancingEvent -> {

        };
    }
}
