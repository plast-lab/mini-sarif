package org.clyze.sarif.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Rule implements MapGen {
    private final String id, name, shortDescription, fullDescription, level;

    public Rule(String id, String name, String shortDescription, String fullDescription, String level) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.level = level;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("id", id);
        ret.put("name", name);
        ret.put("shortDescription", Collections.singletonMap("text", shortDescription));
        ret.put("fullDescription", Collections.singletonMap("text", fullDescription));
        ret.put("defaultConfiguration", Collections.singletonMap("level", level));
        return ret;
    }
}
