package org.clyze.sarif.model;

import java.util.Collections;
import java.util.Map;

/**
 * An analysis artifact (such as a source file).
 */
public class Artifact implements MapGen {
    private final ArtifactLocation location;

    public Artifact(ArtifactLocation location) {
        this.location = location;
    }

    @Override
    public Map<String, Object> toMap() {
        return Collections.singletonMap("location", location.toMap());
    }
}
