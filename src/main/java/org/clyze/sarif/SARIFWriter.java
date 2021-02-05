package org.clyze.sarif;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.clyze.sarif.model.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The main entry points of the library.
 */
@SuppressWarnings("unused")
public class SARIFWriter {
    /**
     * Write a SARIF object to a file.
     * @param sarif          the SARIF object to write
     * @param sarifOut       the target file
     * @throws IOException   on file write error
     */
    public static void write(SARIF sarif, File sarifOut) throws IOException {
        (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValue(sarifOut, sarif.toMap());
    }

    /**
     * Write analysis results to a file.
     * @param name         the simple name of the analysis tool
     * @param fullName     the full name of the analysis tool
     * @param version      the version
     * @param sarifOut     the target file
     * @param rules        the list of analysis rules
     * @param results      the list of analysis results
     * @throws IOException on file write error
     */
    public static void write(String name, String fullName, String version,
                             File sarifOut, List<Rule> rules, List<Result> results)
            throws IOException {
        Driver driver = new Driver(name, fullName, version, "1.0", rules);
        Run run = new Run(results, new ArrayList<>(), new Tool(driver));
        SARIF sarif = new SARIF(Collections.singletonList(run));
        write(sarif, sarifOut);
    }
}
