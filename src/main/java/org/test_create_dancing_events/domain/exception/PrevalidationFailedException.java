package org.test_create_dancing_events.domain.exception;

import org.test_create_dancing_events.application.port.outbound.Reason;

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
