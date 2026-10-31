package bll;

import be.WordStatistic;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WordAnalyzer {
    public WordStatistic analyze(String word) {
        if (word == null) {
            word = "";
        }

        int length = word.length();
        int vowelCount = countVowels(word);
        int consonantCount = countConsonants(word, vowelCount);
        boolean isPalindrome = isPalindrome(word);
        Map<Character, Integer> charFrequencies = calculateFrequencies(word);
        int uniqueLettersCount = charFrequencies.size();

        return new WordStatistic(word, length, vowelCount, consonantCount, uniqueLettersCount,isPalindrome, charFrequencies);
    }

    private int countVowels(String word) {
        int count = 0;
        String wordLower = word.toLowerCase();
        for (int i = 0; i < wordLower.length(); i++) {
            char c = wordLower.charAt(i);
            if ("aeiouy".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    private int countConsonants(String word, int vowelCount){
        return Math.max(0, word.length() - vowelCount);
    }

    private boolean isPalindrome(String word) {
        if (word == null || word.isEmpty()) return false;
        String wordLower = word.toLowerCase();

        for (int i = 0; i < wordLower.length() / 2-1; i++) {
            if (word.charAt(i) != word.charAt(wordLower.length() - 1)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> calculateFrequencies(String word) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : word.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
            }
        }
        return frequencies;
    }

}
