package org.clyze.sarif.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A single analysis result entry.
 */
public class Result implements MapGen {
    private final String ruleId;
    private final int ruleIndex;
    private final Message message;
    private final List<Location> locations;

    /**
     * Create a new analysis result.
     * @param ruleId the id of the rule that produced this result
     * @param ruleIndex the index of the rule in the rule list
     * @param message the message describing the result
     * @param locations the source locations associated with the result
     */
    public Result(String ruleId, int ruleIndex, Message message, List<Location> locations) {
        this.ruleId = ruleId;
        this.ruleIndex = ruleIndex;
        this.message = message;
        this.locations = locations;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("ruleId", ruleId);
        ret.put("ruleIndex", ruleIndex);
        ret.put("message", message.toMap());
        ret.put("locations", MapGen.fromList(locations));
        return ret;
    }
}
