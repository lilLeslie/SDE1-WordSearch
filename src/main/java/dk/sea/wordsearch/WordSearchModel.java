package dk.sea.wordsearch;

import be.HistoryEntry;
import be.WordStatistic;
import bll.WordManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

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
        boolean isFound = wordManager.searchWord(query);
        HistoryEntry entry = new HistoryEntry(query, isFound);
        wordManager.addHistoryEntry(entry); // add entry to file
        obsHistory.add(entry); // add entry directly to the observable list for performance purposes??? Spørg Henrik
        return isFound;
    }

    public void clearHistory() throws IOException {
        wordManager.clearHistory();
        obsHistory.clear(); // clear the observable list directly instead of reading through the layers?
    }

    public WordStatistic getWordStatistics(String word){
        return wordManager.getWordStatistic(word);
    }
}
