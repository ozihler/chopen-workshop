package create_dancing_event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @PostMapping
    public ResponseEntity<DancingEventDto> createDancingEvent(@RequestBody CreateDancingEventInput input) {
        logger.info("Received request to create dancing event: {}", input);

        // add use case here

        DancingEventDto body = new DancingEventDto();
        logger.info("Returning response: {}", body);
        return ResponseEntity.ok(body);
    }
}
