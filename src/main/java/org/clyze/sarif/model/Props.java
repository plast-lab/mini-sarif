package org.clyze.sarif.model;

import java.util.Collections;
import java.util.Map;

/**
 * Extra SARIF properties emitted at the run level.
 */
public class Props implements MapGen {
    /**
     * Create an instance of default run properties.
     */
    public Props() {
    }

    /**
     * Convert this node to a map suitable for JSON serialization.
     * @return a map representation of this node
     */
    public Map<String, Object> toMap() {
        return Collections.singletonMap("format", "sarif-output");
    }
}
