package dk.sea.wordsearch;

import be.HistoryEntry;
import bll.WordManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class WordSearchModel {
    private WordManager wordManager;
    private ObservableList<String> obsAllWords;
    private ObservableList<String> obsWordsA;
    private ObservableList<String> obsWordsN;
    private ObservableList<HistoryEntry> obsHistory;

    public WordSearchModel() {
        wordManager = WordManager.getInstance();
        obsAllWords = FXCollections.observableList(wordManager.getAllWords());
        obsHistory = FXCollections.observableList(wordManager.getHistory());
        obsWordsA = FXCollections.observableList(wordManager.getWordsA());
        obsWordsN = FXCollections.observableList(wordManager.getWordsN());
    }

    public ObservableList<String> getObsAllWords() {
        return obsAllWords;
    }

    public ObservableList<String> getObsWordsA() {
        return obsWordsA;
    }

    public ObservableList<String> getObsWordsN() {
        return obsWordsN;
    }

    public ObservableList<HistoryEntry> getObsHistory() {
        return obsHistory;
    }

    public boolean search(String query) throws IOException {
        boolean wordFound = wordManager.searchWord(query);
        wordManager.addHistoryEntry(query, wordFound);
        obsHistory = FXCollections.observableList(wordManager.getHistory());
        return wordFound;
    }

    public void clearHistory() throws IOException {
        wordManager.clearHistory();
        obsHistory = FXCollections.observableList(wordManager.getHistory());
    }
}
