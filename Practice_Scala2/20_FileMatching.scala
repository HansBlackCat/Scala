

class FileMatcher {
    private def filesHere = (new java.io.File(".")).listFiles()

    def filesMatching(query: String, matcher: (String, String) => Boolean) = {
        for (
            file <- filesHere
            if (matcher(file.getName, query))
        ) yield file
    }

    def filesEnding(query: String) = {
        filesMatching(query, _.endsWith(_))
    }
}