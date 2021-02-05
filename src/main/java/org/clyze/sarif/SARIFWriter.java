package org.clyze.sarif;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.clyze.sarif.model.SARIF;

import java.io.File;
import java.io.IOException;

public class SARIFWriter {
    public static void write(SARIF sarif, File sarifOut) throws IOException {
        (new ObjectMapper()).writeValue(sarifOut, sarif.toMap());
    }
}
