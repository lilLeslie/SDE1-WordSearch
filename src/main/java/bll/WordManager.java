package bll;

import be.HistoryEntry;
import be.WordStatistic;
import dal.HistoryDAO;
import dal.WordDAO;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class WordManager {
    private static WordManager instance;
    private WordAnalyzer wordAnalyzer;
    private List<String> allWords;
    private List<String> wordsA;
    private List<String> wordsN;
    private WordDAO wordDAO;
    private HistoryDAO historyDAO;

    private WordManager() {
        wordAnalyzer = new WordAnalyzer();
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

    /**
     * Filters allWords that start with {@code letter}
     * @param letter Letter to filter by
     * @return List of all words starting with {@code letter}
     */
    public List<String> getWordsStartingWithChar(char letter) {
        return allWords.stream().filter(s -> s.startsWith(String.valueOf(letter))).toList();
    }

    /**
     * Checks if {@code query} exists in allWords
     * @param query Word to search for in allWords
     * @return true if word exists, else false
     */
    public boolean searchWord(String query) {
        return Collections.binarySearch(allWords, query) >= 0;
    }

    public List<HistoryEntry> getHistory() {
        return historyDAO.loadHistory();
    }

    public void addHistoryEntry(HistoryEntry entry) throws IOException {
        historyDAO.saveHistoryEntry(entry);
    }

    public void clearHistory() throws IOException {
        historyDAO.clearHistory();
    }

    public WordStatistic getWordStatistic(String word){
        return wordAnalyzer.analyze(word);
    }
}
