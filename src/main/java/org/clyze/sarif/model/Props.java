package org.clyze.sarif.model;

import java.util.Collections;
import java.util.Map;

public class Props implements MapGen {
    public Map<String, Object> toMap() {
        return Collections.singletonMap("format", "sarif-output");
    }
}
