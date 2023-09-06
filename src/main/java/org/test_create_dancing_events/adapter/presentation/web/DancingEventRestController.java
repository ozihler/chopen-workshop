package org.test_create_dancing_events.adapter.presentation.web;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.test_create_dancing_events.adapter.presentation.web.dto.DancingEventDto;
import org.test_create_dancing_events.application.port.inbound.CreateDancingEvent;
import org.test_create_dancing_events.application.port.inbound.CreateDancingEventInput;

@RestController
public class DancingEventRestController {


    private final CreateDancingEvent useCase;

    public DancingEventRestController(CreateDancingEvent useCase) {
        this.useCase = useCase;
    }

    @PostMapping(path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DancingEventDto> create(@RequestBody CreateDancingEventInput input) {

        HttpPresenter presenter = new HttpPresenter();

        useCase.execute(input, presenter);

        return presenter.getBody();
    }

}
