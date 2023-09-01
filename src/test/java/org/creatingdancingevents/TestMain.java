package org.creatingdancingevents;

import org.creatingdancingevents.application.ports.inbound.CreateDancingEvent;
import org.creatingdancingevents.application.ports.outbound.GetNextDancingEventId;
import org.creatingdancingevents.application.use_case.CreateDancingEventUseCase;
import org.creatingdancingevents.domain.value.DancingEventId;

import java.util.Random;
import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
        executeCreateDancingEventUseCase();

    }

    private static void executeCreateDancingEventUseCase() {
        var repo = new InMemoryDancingEventRepository();
        var getNextDancingEventId = randomId();
        var useCase = new CreateDancingEventUseCase(repo, repo, getNextDancingEventId);
        var console = new ConsoleController(new Scanner(System.in), System.out, useCase);

        console.execute();
    }

    private static GetNextDancingEventId randomId() {
        return () -> new DancingEventId(String.valueOf(new Random().nextInt(100000))
        );
    }

}
