package dk.sea.wordsearch;

import bll.WordSearchLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class WordSearchController implements Initializable {
    WordSearchLogic wordSearchLogic = new WordSearchLogic();
    @FXML
    private ListView<String> lvAllWords;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvAllWords.setItems(wordSearchLogic.readFromAllWordsFile());
    }
}
