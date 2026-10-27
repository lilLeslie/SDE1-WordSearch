package bll;

import dal.FileDataAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class WordSearchLogic {
    private String allWordsFilePath = "C:/Datamatiker/1st semester/SDE1/W44 - External Data Sources I/words.txt";
    private FileDataAccess fileDataAccess = new FileDataAccess();

    public ObservableList<String> readFromAllWordsFile() {
        return FXCollections.observableList(fileDataAccess.readLines(allWordsFilePath));
    }

    public ObservableList<String> filterWordsStartingWith(String string) {
        List<String> filteredList = fileDataAccess.readLines(allWordsFilePath).stream().filter(s -> s != null && s.startsWith(string)).toList();
        return FXCollections.observableList(filteredList);
    }
}
