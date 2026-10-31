package dal;

import be.HistoryEntry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryDAO {
    private String filePath = "C:\\Datamatiker\\1st semester\\SDE1\\W44 - External Data Sources I\\history.txt";

    public List<HistoryEntry> loadHistory(){
        List<HistoryEntry> historyEntries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                historyEntries.add(csvToHistoryEntry(line));
            }
            return historyEntries;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveHistoryEntry(HistoryEntry entry) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(entry.toCsvString());
            bw.newLine();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public void clearHistory() throws IOException {
        try (FileWriter fw = new FileWriter(filePath, false)) {
            fw.write("");
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    private HistoryEntry csvToHistoryEntry(String csvEntry) {
        String[] parts = csvEntry.split(",");
        return new HistoryEntry(parts[0], parts[1].equals("true"));
    }
}
