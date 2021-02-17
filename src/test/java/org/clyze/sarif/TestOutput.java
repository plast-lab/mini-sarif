package org.clyze.sarif;

import java.io.File;
import java.util.Collections;
import java.util.List;
import org.clyze.sarif.model.*;
import org.junit.jupiter.api.Test;

public class TestOutput {
    @Test
    public void test() {
        // Create the rule.
        List<Rule> rules = Collections.singletonList(new Rule("rule-1", "error-1", "Error 1", "Error #1 at this point.", "error"));
        // Create one result (with location) for the rule above.
        List<Location> locations = Collections.singletonList(new Location(new ArtifactLocation("path/to/file"), 1, 1, 1, 5));
        List<Result> results = Collections.singletonList(new Result("rule-1", 0, new Message("This code is unsafe."), locations));
        File out = new File("build", "test.sarif");
        assert !out.exists() || out.delete();
        try {
            SARIFWriter.write("test-tool", "Test tool v.1.0", "1.0", out, rules, results);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        assert out.exists();
    }
}
