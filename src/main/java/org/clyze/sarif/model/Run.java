package org.clyze.sarif.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** A single run of an analysis tool. */
public class Run implements MapGen {
    private final List<Result> results;
    private final List<Artifact> artifacts;
    private final Tool tool;
    private final String columnKind = "utf16CodeUnits";
    private final MapGen properties = new Props();

    /**
     * Create a new analysis run.
     * @param results the emitted analysis results
     * @param artifacts the artifacts participating in the analysis
     * @param tool the tool metadata
     */
    public Run(List<Result> results, List<Artifact> artifacts, Tool tool) {
        this.results = results;
        this.artifacts = artifacts;
        this.tool = tool;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("results", MapGen.fromList(results));
        ret.put("artifacts", MapGen.fromList(artifacts));
        ret.put("tool", tool.toMap());
        ret.put("columnKind", columnKind);
        ret.put("properties", properties.toMap());
        return ret;
    }
}
