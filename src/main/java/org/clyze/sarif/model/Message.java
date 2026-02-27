package org.clyze.sarif.model;

import java.util.Collections;
import java.util.Map;

/**
 * A human-readable message attached to a result.
 */
public class Message implements MapGen {
    private final String text;

    /**
     * Create a new message.
     * @param text the message text
     */
    public Message(String text) {
        this.text = text;
    }

    @Override
    public Map<String, Object> toMap() {
        return Collections.singletonMap("text", text);
    }
}
