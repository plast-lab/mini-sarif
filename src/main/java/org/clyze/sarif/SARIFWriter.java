package org.clyze.sarif;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.clyze.sarif.model.SARIF;

import java.io.File;
import java.io.IOException;

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
}
