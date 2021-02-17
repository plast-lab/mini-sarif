A Java library to serialize static analysis results using the [SARIF
format](https://rawgit.com/sarif-standard/sarif-spec/master/Static%20Analysis%20Results%20Interchange%20Format%20(SARIF).html).

This library does not support the full SARIF specification but aims to
offer support for displaying simple analysis results.

Tested with GitHub ("codeql-action/upload-sarif" Action) and Visual
Studio Code (with the SARIF viewer plugin).

For a basic example of using this library, see the included test code in src/test.
For more examples, see [Doop](https://bitbucket.org/yanniss/doop) or
[source-ir-fitter](https://github.com/plast-lab/source-ir-fitter/).
