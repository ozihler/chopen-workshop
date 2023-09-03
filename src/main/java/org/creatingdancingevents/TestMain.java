package org.creatingdancingevents;

import org.creatingdancingevents.adapter.data_access.InMemoryDancingEventRepository;
import org.creatingdancingevents.adapter.presentation.ConsoleController;
import org.creatingdancingevents.application.use_case.CreateDancingEventUseCase;
import org.creatingdancingevents.domain.aggregate.UnpublishedDancingEvents;
import org.creatingdancingevents.domain.entity.DancingEvent;
import org.creatingdancingevents.domain.value.DancingEventId;
import org.creatingdancingevents.domain.value.Description;
import org.creatingdancingevents.domain.value.EventOrganizerId;
import org.creatingdancingevents.domain.value.Title;

import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
        var repo = new InMemoryDancingEventRepository();
        var unpublishedDancingEvents = new UnpublishedDancingEvents();
        unpublishedDancingEvents.add(new DancingEvent(new DancingEventId("1"), new Title("Dancing Event 1"), new Description("Dancing Event 1 Description")));
        unpublishedDancingEvents.add(new DancingEvent(new DancingEventId("2"), new Title("Dancing Event 2"), new Description("Dancing Event 2 Description")));
        unpublishedDancingEvents.add(new DancingEvent(new DancingEventId("3"), new Title("Dancing Event 3"), new Description("Dancing Event 3 Description")));
        unpublishedDancingEvents.add(new DancingEvent(new DancingEventId("4"), new Title("Dancing Event 4"), new Description("Dancing Event 4 Description")));
        unpublishedDancingEvents.add(new DancingEvent(new DancingEventId("5"), new Title("Dancing Event 5"), new Description("Dancing Event 5 Description")));

        repo.ofEventOrganizer(new EventOrganizerId("1"), unpublishedDancingEvents);

        var useCase = new CreateDancingEventUseCase(repo, repo);
        var console = new ConsoleController(new Scanner(System.in), System.out, useCase);

        console.execute();
    }

}
