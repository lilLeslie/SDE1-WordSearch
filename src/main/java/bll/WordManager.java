package bll;

import be.HistoryEntry;
import dal.HistoryDAO;
import dal.WordDAO;

import java.io.IOException;
import java.util.List;

public class WordManager {
    private static WordManager instance;
    private List<String> allWords;
    private List<String> wordsA;
    private List<String> wordsN;
    private WordDAO wordDAO;
    private HistoryDAO historyDAO;

    private WordManager() {
        wordDAO = new WordDAO();
        historyDAO = new HistoryDAO();
        allWords = loadWords("C:\\Datamatiker\\1st semester\\SDE1\\W44 - External Data Sources I\\words.txt");
        wordsA = getWordsStartingWithChar('a');
        wordsN = getWordsStartingWithChar('n');
    }

    public static WordManager getInstance(){
        if (instance == null) {
            instance = new WordManager();
        }
        return instance;
    }

    public List<String> loadWords(String filePath) {
        return wordDAO.getAllWords(filePath);
    }

    public List<String> getAllWords() {
        return allWords;
    }

    public List<String> getWordsA(){
        return wordsA;
    }

    public List<String> getWordsN(){
        return wordsN;
    }

    public List<String> getWordsStartingWithChar(char letter) {
        return allWords.stream().filter(s -> s.startsWith(String.valueOf(letter))).toList();
    }

    public boolean searchWord(String query) {
        return allWords.contains(query);
    }

    public List<HistoryEntry> getHistory() {
        return historyDAO.loadHistory();
    }

    public void addHistoryEntry(String query, boolean found) throws IOException {
        historyDAO.saveHistoryEntry(new HistoryEntry(query, found));
    }

    public void clearHistory() throws IOException {
        historyDAO.clearHistory();
    }
}
