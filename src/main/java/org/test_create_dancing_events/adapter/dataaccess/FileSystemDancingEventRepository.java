package org.test_create_dancing_events.adapter.dataaccess;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.test_create_dancing_events.application.port.outbound.FetchUnpublishedDancingEvents;
import org.test_create_dancing_events.application.port.outbound.StoreUnpublishedDancingEvents;
import org.test_create_dancing_events.domain.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileSystemDancingEventRepository implements FetchUnpublishedDancingEvents, StoreUnpublishedDancingEvents {

    public static final String JSON = "src/main/resources/unpublished_dancing_events.json";
    private HashMap<EventOrganizer, UnpublishedDancingEvents> repo = new HashMap<>();

    public FileSystemDancingEventRepository() {
        loadUnpublishedDancingEventsFromFile();
    }

    private void loadUnpublishedDancingEventsFromFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            var allUnpublishedDancingEvents = mapper.readValue(
                    new File(JSON),
                    UnpublishedDancingEventsJson.class);

            allUnpublishedDancingEvents.unpublishedDancingEventsPerEventOrganizer()
                    .forEach(dto -> repo.put(toEventOrganizer(dto), new UnpublishedDancingEvents(toEntities(dto))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static EventOrganizer toEventOrganizer(UnpublishedDancingEventsPerEventOrganizerDto dto) {
        return new EventOrganizer(Long.parseLong(dto.eventOrganizerId()));
    }

    private static ArrayList<UnpublishedDancingEvent> toEntities(UnpublishedDancingEventsPerEventOrganizerDto dto) {
        var unpublishedDancingEvents = new ArrayList<UnpublishedDancingEvent>();

        dto.unpublishedDancingEvents()
                .forEach(eventDto -> unpublishedDancingEvents.add(new UnpublishedDancingEvent(
                        new Title(eventDto.title()),
                        new Description(eventDto.description()),
                        new EventDate(eventDto.eventDate())
                )));
        return unpublishedDancingEvents;
    }

    @Override
    public UnpublishedDancingEvents fetchAllOfEventOrganizer(EventOrganizer eventOrganizer) {
        return this.repo.getOrDefault(eventOrganizer, new UnpublishedDancingEvents(new ArrayList<>()));
    }

    @Override
    public void store(EventOrganizer eventOrganizer, UnpublishedDancingEvents unpublishedDancingEvents) {
        this.repo.put(eventOrganizer, unpublishedDancingEvents);

        writeToFileSystem(unpublishedDancingEvents);

    }

    private void writeToFileSystem(UnpublishedDancingEvents unpublishedDancingEvents) {
        List<UnpublishedDancingEventsPerEventOrganizerDto> events = new ArrayList<>();
        for (var entry : repo.entrySet()) {

            List<UnpublishedDancingEventDto> asList = entry.getValue().getAll().stream().map(unpublishedDancingEvent -> new UnpublishedDancingEventDto(
                    unpublishedDancingEvent.title().value(),
                    unpublishedDancingEvent.description().value(),
                    unpublishedDancingEvent.eventDate().value()
            )).toList();
            events.add(new UnpublishedDancingEventsPerEventOrganizerDto(
                    String.valueOf(entry.getKey().id()), asList
            ));
        }

        var json = new UnpublishedDancingEventsJson(events);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File(JSON), json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
