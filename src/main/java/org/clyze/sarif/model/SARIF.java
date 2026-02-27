package org.clyze.sarif.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** A POJO representation for the top-level SARIF data. */
public class SARIF implements MapGen {
    private final List<Run> runs;

    /**
     * Create a top-level SARIF payload.
     * @param runs the analysis runs contained in this payload
     */
    public SARIF(List<Run> runs) {
        this.runs = runs;
    }

    /**
     * Basic entry point to the format: construct a SARIF object and call
     * this method to get a map that can be converted to JSON.
     * @return   a generic map that represents values to be converted to JSON
     */
    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("$schema", "https://raw.githubusercontent.com/oasis-tcs/sarif-spec/master/Schemata/sarif-schema-2.1.0.json");
        map.put("version", "2.1.0");
        map.put("runs", MapGen.fromList(runs));
        return map;
    }
}
