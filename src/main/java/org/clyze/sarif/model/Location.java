package org.clyze.sarif.model;

import java.util.HashMap;
import java.util.Map;

public class Location implements MapGen {
    private final ArtifactLocation artifactLocation;
    private final long startLine, startColumn, endLine, endColumn;

    public Location(ArtifactLocation artifactLocation, long startLine, long startColumn, long endLine, long endColumn) {
        this.artifactLocation = artifactLocation;
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> region = new HashMap<>();
        region.put("startLine", startLine);
        region.put("startColumn", atLeastOne(startColumn));
        region.put("endLine", endLine);
        region.put("endColumn", atLeastOne(endColumn));

        Map<String, Object> physicalLocation = new HashMap<>();
        physicalLocation.put("artifactLocation", artifactLocation.toMap());
        physicalLocation.put("region", region);

        Map<String, Object> ret = new HashMap<>();
        ret.put("physicalLocation", physicalLocation);
        return ret;
    }

    /**
     * Ensure that numbers are at least 1 (or some SARIF consumers such
     * as GitHub/CodeQL may fail to process data such as 0-value columns).
     * @param i    the original value
     * @return     the fixed value
     */
    private static long atLeastOne(long i) {
        return i < 1 ? 1 : i;
    }
}
