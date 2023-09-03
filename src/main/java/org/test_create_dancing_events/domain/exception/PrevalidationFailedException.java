package org.test_create_dancing_events.domain.exception;

public class PrevalidationFailedException extends Exception {

    private final Reason reason;

    public PrevalidationFailedException(String message, Reason reason) {
        super(message);
        this.reason = reason;
    }

}
