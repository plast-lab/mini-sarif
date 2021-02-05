package org.clyze.sarif.model;

import java.util.Collections;
import java.util.Map;

public class Tool implements MapGen {
    private final Driver driver;

    public Tool(Driver driver) {
        this.driver = driver;
    }

    @Override
    public Map<String, Object> toMap() {
        return Collections.singletonMap("driver", driver.toMap());
    }
}
