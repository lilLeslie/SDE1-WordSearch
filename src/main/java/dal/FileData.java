package dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileData {
    public List<String> readLinesFromFile() {
        List<String> words = new ArrayList<>();
        File wordsFile = new File("C:/Datamatiker/1st semester/SDE1/W44 - External Data Sources I/words.txt");
        try {
            if (wordsFile.exists()) {
                BufferedReader bReader = new BufferedReader(new FileReader(wordsFile.getAbsoluteFile()));
                while ((bReader.readLine() != null)) {
                    words.add(bReader.readLine());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }
}
