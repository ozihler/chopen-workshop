package org.test_create_dancing_events.adapter.dataaccess;

import org.test_create_dancing_events.application.port.outbound.PrevalidateUnpublishedDancingEvent;
import org.test_create_dancing_events.domain.UnpublishedDancingEvent;
import org.test_create_dancing_events.domain.exception.PrevalidationFailedException;
import org.test_create_dancing_events.domain.exception.Reason;

import java.util.Arrays;
import java.util.Set;

public class LocalValidationGateway implements PrevalidateUnpublishedDancingEvent {
    private final Set<String> badWords = Set.of("shit");

    @Override
    public void prevalidate(UnpublishedDancingEvent unpublishedDancingEvent) throws PrevalidationFailedException {
        if (containsBadWord(unpublishedDancingEvent.getTitle().value())
                || containsBadWord(unpublishedDancingEvent.getDescription().value())) {
            throw new PrevalidationFailedException("Title contains bad word. Remove any of the following words: " + badWords, Reason.SWEARING);
        }
    }

    private boolean containsBadWord(String string) {
        return Arrays.stream(string.split(" "))
                .map(String::toLowerCase)
                .anyMatch(badWords::contains);
    }


}
