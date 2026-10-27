package bll;

import dal.FileDataAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Locale;

public class WordSearchLogic {
    private String allWordsFilePath = "C:/Datamatiker/1st semester/SDE1/W44 - External Data Sources I/words.txt";
    private String historyFilePath = "C:/Datamatiker/1st semester/SDE1/W44 - External Data Sources I/history.txt";
    private FileDataAccess fileDataAccess = new FileDataAccess();

    public ObservableList<String> readFromAllWordsFile() {
        return FXCollections.observableList(fileDataAccess.readLines(allWordsFilePath));
    }

    public ObservableList<String> filterWordsStartingWith(String string) {
        return FXCollections.observableList(fileDataAccess.readLines(allWordsFilePath).stream().filter(s -> s!=null && s.startsWith(string)).toList());
    }

    public void search(String search) {
        for (String s: fileDataAccess.readLines(allWordsFilePath)){
            if (s.equals(search.toLowerCase(Locale.ROOT))){
                fileDataAccess.writeLine(historyFilePath, "Searched for " + search + " and found result");
                return;
            }
            else continue;
        }
        fileDataAccess.writeLine(historyFilePath, "Searched for " + search + " and found no result");
    }

    public ObservableList<String> readFromHistoryFile() {
        return FXCollections.observableList(fileDataAccess.readLines(historyFilePath));
    }

    public void clearFile(){
        fileDataAccess.clearFile(historyFilePath);
    }
}
