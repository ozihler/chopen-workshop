package org.test_create_dancing_events.adapter.dataaccess;

import org.springframework.stereotype.Repository;
import org.test_create_dancing_events.application.port.outbound.PrevalidateUnpublishedDancingEvent;
import org.test_create_dancing_events.domain.UnpublishedDancingEvent;
import org.test_create_dancing_events.domain.exception.PrevalidationFailedException;
import org.test_create_dancing_events.domain.exception.Reason;

import java.util.Arrays;
import java.util.Set;

@Repository
public class LocalValidationGateway implements PrevalidateUnpublishedDancingEvent {
    private final Set<String> badWords = Set.of("shit");

    @Override
    public void prevalidate(UnpublishedDancingEvent unpublishedDancingEvent) throws PrevalidationFailedException {
        if (containsAnyBadWord(unpublishedDancingEvent)) {
            throw new PrevalidationFailedException("Title contains bad word. Remove any of the following words: " + badWords, Reason.SWEARING);
        }
    }

    private boolean containsAnyBadWord(UnpublishedDancingEvent unpublishedDancingEvent) {
        return containsBadWord(unpublishedDancingEvent.title().value())
                || containsBadWord(unpublishedDancingEvent.description().value());
    }

    private boolean containsBadWord(String string) {
        return Arrays.stream(string.split(" "))
                .map(String::toLowerCase)
                .anyMatch(badWords::contains);
    }


}
