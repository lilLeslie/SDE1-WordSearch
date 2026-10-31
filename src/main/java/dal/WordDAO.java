package dal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordDAO {
    /**
     * Reads all lines of {@code filePath}
     * @param filePath Absolute path of words.txt file
     * @return List of all words in the file
     */
    public List<String> getAllWords(String filePath) {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
            return words;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}