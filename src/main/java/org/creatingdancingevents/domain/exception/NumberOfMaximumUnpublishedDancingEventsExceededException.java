package org.creatingdancingevents.domain.exception;

public class NumberOfMaximumUnpublishedDancingEventsExceededException extends RuntimeException {
    public NumberOfMaximumUnpublishedDancingEventsExceededException() {
        super("Maximum number of unpublished dancing events reached. " +
                "You need to either remove an unpublished dancing event or publish one.");
    }
}
