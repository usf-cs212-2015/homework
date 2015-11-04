import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextFileWordMatcher {

    /**
     * Counts the number of matches found within a file.
     *
     * @param file        file to read
     * @param wordRegex   regex to compare against words
     * @param splitRegex  regex to split lines into words
     *
     * @return number of matches
     *
     * @see String#split(String)
     * @see String#matches(String)
     */
    public static int countWords(Path file, String wordRegex, String splitRegex) {
        int count = 0;

        try (
            BufferedReader reader =
                    Files.newBufferedReader(file, Charset.forName("UTF-8"));
        ) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                for (String word : line.split(splitRegex)) {
                    if (word.matches(wordRegex)) {
                        count++;
                    }
                }
            }
        }
        catch (IOException e) {
            count = 0;
            System.err.println(e.getMessage());
        }

        return count;
    }

    /**
     * Counts the number of matches found within a file. Splits words by whitespace.
     *
     * @param file        file to read
     * @param wordRegex   regex to compare against words
     *
     * @return number of matches
     *
     * @see #countWords(Path, String, String)
     */
    public static int countWords(Path file, String wordRegex) {
        return countWords(file, wordRegex, "(?U)\\p{Space}+");
    }


    /**
     * Parses all text files found within the provided path, and looks for words
     * that match the provided regex.
     *
     * @param path   path to process
     * @param regex  regex to match against words
     *
     * @return number of matches found
     *
     * @see #countWords(Path, String)
     */
    public static int parseTextFiles(Path path, String regex) {
        int count = 0;

        if (Files.isDirectory(path)) {
            try (
                DirectoryStream<Path> directory = Files.newDirectoryStream(path);
            ) {
                for (Path current : directory) {
                    count += parseTextFiles(current, regex);
                }
            }
            catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        else if (Files.isReadable(path) && path.toString().toLowerCase().endsWith(".txt")) {
            count += countWords(path, regex);
        }

        return count;
    }

//    public static void main(String[] args) {
//        // sanity check code (to be replaced by unit tests)
//        String regex = "(?i)guten.*";
//        String[] files = {"11.txt", "98.txt", "1322.txt", "1342.txt", "1661.txt"};
//
//        Map<String, Integer> counts = new HashMap<>();
//        Arrays.stream(files).forEach(s -> counts.put(s, countWords(Paths.get("text", s), regex)));
//
//        // {98.txt=87, 11.txt=87, 1322.txt=87, 1342.txt=87, 1661.txt=89}
//        System.out.println(counts);
//
//        // 437
//        System.out.println(counts.values().stream().mapToInt(Integer::intValue).sum());
//        System.out.println(parseTextFiles(Paths.get("text"), regex));
//        System.out.println(parseTextFiles(Paths.get("."), regex));
//    }
}
