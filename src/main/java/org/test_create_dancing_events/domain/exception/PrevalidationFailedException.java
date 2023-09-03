package org.test_create_dancing_events.domain.exception;

public class PrevalidationFailedException extends Exception {

    private final Reason reason;

    public PrevalidationFailedException(Reason reason) {
        super();
        this.reason = reason;
    }

    public Reason getReason() {
        return reason;
    }
}
