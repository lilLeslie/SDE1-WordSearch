package dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataAccess {
    public List<String> readLines(String path) {
        File file = new File(path);
        if (!file.exists()){
            throw new IllegalArgumentException("File not found: " + path);
        }
        List<String> lines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while((line = br.readLine()) != null){
                lines.add(line);
            }
        }
        catch (IOException e){
            throw new RuntimeException("Could not read from file: " + e);
        }
        return lines;
    }
}
