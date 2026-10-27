package bll;

import dal.FileData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WordSearchLogic {
    private FileData fileData = new FileData();

    public ObservableList<String> readFromAllWordsFile(){
        return FXCollections.observableList(fileData.readLinesFromFile());
    }
}
