package org.clyze.sarif.model;

import java.util.HashMap;
import java.util.Map;

/**
 * The location of an artifact (such as a source file path).
 */
public class ArtifactLocation implements MapGen {
    private final String uri;
    private final String uriBaseId = "%SRCROOT%";
    private final int index = 0;

    /**
     * Create an artifact location object.
     * @param uri   the path, relative to the sources root
     */
    public ArtifactLocation(String uri) {
        this.uri = uri;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("uri", uri);
        ret.put("uriBaseId", uriBaseId);
        ret.put("index", index);
        return ret;
   }
}
