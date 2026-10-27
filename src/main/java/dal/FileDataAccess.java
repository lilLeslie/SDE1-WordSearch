package dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataAccess {
    public void writeLine(String filePath, String line) {
        File file = new File(filePath);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Could not write to file: " + e);
        }
    }

    public List<String> readLines(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IllegalArgumentException("File not found: " + filePath);
        }
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read from file: " + e);
        }
        return lines;
    }
    public void clearFile(String filePath){
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IllegalArgumentException("File not found: " + filePath);
        }

        try (FileWriter fw = new FileWriter(file, false)){

        } catch (IOException e){
            throw new RuntimeException("Could not clear file: " + e.getMessage(), e);
        }
    }
}
