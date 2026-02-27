package org.clyze.sarif.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The interface of SARIF nodes, each with the capability to generate a
 * map (and thus support easy JSON serialization).
 */
public interface MapGen {
    /**
     * Convert this node to a map suitable for JSON serialization.
     * @return a map representation of this node
     */
    Map<String, Object> toMap();

    /**
     * Utility method for list-of-nodes-inside-node.
     * @param l    a list of SARIF nodes
     * @return     a list of the generated maps for the nodes
     */
    static List<Map<String, Object>> fromList(List<? extends MapGen> l) {
        return l.stream().map(MapGen::toMap).collect(Collectors.toList());
    }
}
