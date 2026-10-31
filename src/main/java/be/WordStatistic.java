package be;

import java.util.Map;

public class WordStatistic {
    private String word;
    private int length;
    private int vowelCount;
    private int consonantsCount;
    private int uniqueLettersCount;
    private boolean isPalindrome;
    private Map<Character, Integer> charFrequency;

    public WordStatistic(String word, int length, int vowelCount, int consonantsCount, int uniqueLettersCount, boolean isPalindrome, Map<Character, Integer> charFrequency) {
        this.word = word;
        this.length = length;
        this.vowelCount = vowelCount;
        this.consonantsCount = consonantsCount;
        this.uniqueLettersCount = uniqueLettersCount;
        this.isPalindrome = isPalindrome;
        this.charFrequency = charFrequency;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getVowelCount() {
        return vowelCount;
    }

    public void setVowelCount(int vowelCount) {
        this.vowelCount = vowelCount;
    }

    public int getConsonantsCount() {
        return consonantsCount;
    }

    public void setConsonantsCount(int consonantsCount) {
        this.consonantsCount = consonantsCount;
    }

    public int getUniqueLettersCount() {
        return uniqueLettersCount;
    }

    public void setUniqueLettersCount(int uniqueLettersCount) {
        this.uniqueLettersCount = uniqueLettersCount;
    }

    public boolean isPalindrome() {
        return isPalindrome;
    }

    public void setPalindrome(boolean palindrome) {
        isPalindrome = palindrome;
    }

    public Map<Character, Integer> getCharFrequency() {
        return charFrequency;
    }

    public void setCharFrequency(Map<Character, Integer> charFrequency) {
        this.charFrequency = charFrequency;
    }

    private String getCharFreqToString() {
        String returnString = "";
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() > 1) {
                returnString += "'" + entry.getKey() + "' " + "("+entry.getValue() + "x) ";
            }
        }
        return returnString;
    }

    public String toString() {
        return "Length: " + length + "\n" +
                "Vowels: " + vowelCount + "\n" +
                "Consonants: " + consonantsCount + "\n" +
                "Unique Letters: " + uniqueLettersCount + "\n" +
                "Is Palindrome? " + isPalindrome + "\n" +
                "Most common: " + getCharFreqToString();
    }
}
