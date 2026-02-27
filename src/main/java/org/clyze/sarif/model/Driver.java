package org.clyze.sarif.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The metadata describing the analysis tool driver.
 */
public class Driver implements MapGen {
    private final String name, fullName, version, semanticVersion;
    private final List<Rule> rules;

    /**
     * Create a new tool driver.
     * @param name the simple name of the tool
     * @param fullName the full name of the tool
     * @param version the tool version
     * @param semanticVersion the semantic version of the tool
     * @param rules the rules supported by the tool
     */
    public Driver(String name, String fullName, String version, String semanticVersion, List<Rule> rules) {
        this.name = name;
        this.fullName = fullName;
        this.version = version;
        this.semanticVersion = semanticVersion;
        this.rules = rules;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("name", name);
        ret.put("fullName", fullName);
        ret.put("rules", MapGen.fromList(rules));
        ret.put("version", version);
        ret.put("semanticVersion", semanticVersion);
        return ret;
    }
}
