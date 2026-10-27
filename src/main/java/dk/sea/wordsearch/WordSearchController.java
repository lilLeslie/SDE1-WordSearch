package dk.sea.wordsearch;

import bll.WordSearchLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class WordSearchController implements Initializable {
    WordSearchLogic wordSearchLogic = new WordSearchLogic();
    @FXML
    private TextField txtInput;
    @FXML
    private ListView<String> lvAllWords;
    @FXML
    private ListView<String> lvAWords;
    @FXML
    private ListView<String> lvNWords;
    @FXML
    private ListView<String> lvHistory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvAllWords.setItems(wordSearchLogic.readFromAllWordsFile());
        lvAWords.setItems(wordSearchLogic.filterWordsStartingWith("a"));
        lvNWords.setItems(wordSearchLogic.filterWordsStartingWith("n"));
        lvHistory.setItems(wordSearchLogic.readFromHistoryFile());
    }


    public void search(ActionEvent actionEvent) throws IOException {
        if (txtInput.getText() != null) {
            wordSearchLogic.search(txtInput.getText());
            lvHistory.setItems(wordSearchLogic.readFromHistoryFile());
        }
    }

    public void clearHistory(ActionEvent actionEvent) throws IOException{
        wordSearchLogic.clearFile();
        lvHistory.setItems(wordSearchLogic.readFromHistoryFile());
    }

    private void update(){
        lvHistory.setItems(wordSearchLogic.readFromHistoryFile());
        txtInput.clear();
    }
}
