package org.clyze.sarif.model;

import java.util.Collections;
import java.util.Map;

/**
 * Wrapper for SARIF tool metadata.
 */
public class Tool implements MapGen {
    private final Driver driver;

    /**
     * Create a new tool wrapper.
     * @param driver the analysis driver metadata
     */
    public Tool(Driver driver) {
        this.driver = driver;
    }

    @Override
    public Map<String, Object> toMap() {
        return Collections.singletonMap("driver", driver.toMap());
    }
}
