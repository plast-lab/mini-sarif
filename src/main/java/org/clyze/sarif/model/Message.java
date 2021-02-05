package org.clyze.sarif.model;

import java.util.Collections;
import java.util.Map;

public class Message implements MapGen {
    private final String text;

    public Message(String text) {
        this.text = text;
    }

    @Override
    public Map<String, Object> toMap() {
        return Collections.singletonMap("text", text);
    }
}