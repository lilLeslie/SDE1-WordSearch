package dal;

import be.HistoryEntry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryDAO {
    private String filePath = "C:\\Datamatiker\\1st semester\\SDE1\\W44 - External Data Sources I\\history.txt"; // Spørg Henrik

    /**
     * Retrieves csv data from {@code history.txt} file
     * @return A list of all history entries.
     */
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

    /**
     * Appends history entry as csv to {@code history.txt} file
     * @param entry HistoryEntry object to save
     */
    public void saveHistoryEntry(HistoryEntry entry) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(entry.toCsvString());
            bw.newLine();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    /**
     * Clears {@code history.txt} file
     */
    public void clearHistory() throws IOException {
        try (FileWriter fw = new FileWriter(filePath, false)) {
            fw.write("");
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    /**
     * Converts a {@code HistoryEntry.toCsvString()} to a {@code HistoryEntry} object
     * @param csvEntry A {@code HistoryEntry}.toCsvString()
     * @return {@code HistoryEntry} object from csv
     */
    private HistoryEntry csvToHistoryEntry(String csvEntry) {
        String[] parts = csvEntry.split(",");
        return new HistoryEntry(parts[0], parts[1].equals("true"));
    }
}
