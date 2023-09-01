package org.creatingdancingevents;

import org.creatingdancingevents.adapter.data_access.InMemoryDancingEventRepository;
import org.creatingdancingevents.adapter.presentation.ConsoleController;
import org.creatingdancingevents.application.use_case.CreateDancingEventUseCase;

import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
        var repo = new InMemoryDancingEventRepository();
        var useCase = new CreateDancingEventUseCase(repo, repo);
        var console = new ConsoleController(new Scanner(System.in), System.out, useCase);

        console.execute();
    }

}
