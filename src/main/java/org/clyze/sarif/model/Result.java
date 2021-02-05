package org.clyze.sarif.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result implements MapGen {
    private final String ruleId;
    private final int ruleIndex;
    private final Message message;
    private final List<Location> locations;

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
