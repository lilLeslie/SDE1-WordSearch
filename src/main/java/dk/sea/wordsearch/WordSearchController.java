package dk.sea.wordsearch;

import bll.WordSearchLogic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class WordSearchController implements Initializable {
    WordSearchLogic wordSearchLogic = new WordSearchLogic();
    @FXML
    private ListView<String> lvAllWords;
    @FXML
    private ListView<String> lvAWords;
    @FXML
    private ListView<String> lvNWords;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvAllWords.setItems(wordSearchLogic.readFromAllWordsFile());
        lvAWords.setItems(wordSearchLogic.filterWordsStartingWith("a"));
        lvNWords.setItems(wordSearchLogic.filterWordsStartingWith("n"));
    }


}
