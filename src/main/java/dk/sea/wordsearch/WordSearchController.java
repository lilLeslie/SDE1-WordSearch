package dk.sea.wordsearch;

import be.HistoryEntry;
import bll.WordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WordSearchController implements Initializable {
    @FXML
    private TextField txtInput;
    @FXML
    private ListView<String> lvAllWords;
    @FXML
    private ListView<String> lvWordsA;
    @FXML
    private ListView<String> lvWordsN;
    @FXML
    private ListView<HistoryEntry> lvHistory;
    @FXML
    private Label lblTotalWordCount;
    @FXML
    private Label lblSearchResult;
    WordSearchModel wordSearchModel;

    public WordSearchController() throws IOException {
        wordSearchModel = new WordSearchModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvAllWords.setItems(wordSearchModel.getObsAllWords());
        lvWordsA.setItems(wordSearchModel.getObsWordsA());
        lvWordsN.setItems(wordSearchModel.getObsWordsN());
        lvHistory.setItems(wordSearchModel.getObsHistory());
        lblTotalWordCount.setText(lvAllWords.getItems().size()+"");
    }


    public void search(ActionEvent actionEvent) throws IOException {
        String query = txtInput.getText();
        if (!query.isEmpty()) {
            boolean isFound = wordSearchModel.search(query);
//            lvHistory.setItems(wordSearchModel.getObsHistory()); Spørg Henrik
            lblSearchResult.setText(query + (isFound ? " is found!" : " is NOT found!"));
        }
    }

    public void clearHistory(ActionEvent actionEvent) throws IOException {
        wordSearchModel.clearHistory();
//        lvHistory.setItems(wordSearchModel.getObsHistory());
    }
}
