package org.test_create_dancing_events.domain.exception;

public class NumberOfUnpublishedDancingEventsReachedMaxNumberException extends RuntimeException {
    public NumberOfUnpublishedDancingEventsReachedMaxNumberException(String message) {
        super(message);
    }
}
