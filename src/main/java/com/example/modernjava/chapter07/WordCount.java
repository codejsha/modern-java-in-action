package com.example.modernjava.chapter07;

import com.example.modernjava.data.TextData;
import lombok.extern.slf4j.Slf4j;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.StreamSupport;

@Slf4j
public class WordCount {
    public static void main(String[] args) {
        final var sentence = String.join("", TextData.INFERNO);

        log.info("Word count for sentence: {}", countWordsIteratively(sentence));
        log.info("Word count for sentence: {}", countWordsUsingStream(sentence));
    }

    /**
     * Count words in sentence iteratively
     *
     * @param sentence sentence
     * @return word count
     */
    public static int countWordsIteratively(String sentence) {
        var counter = 0;
        var lastSpace = true;

        for (var c : sentence.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }

        return counter;
    }

    /**
     * Count words in sentence using stream
     *
     * @param sentence sentence
     * @return word count
     */
    public static int countWordsUsingStream(String sentence) {
        final var wordCounter = StreamSupport.stream(new WordCounterSpliterator(sentence), true)
                .reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
        return wordCounter.counter();
    }

    /**
     * Word counter
     *
     * @param counter   counting the number of words
     * @param lastSpace whether the character is a space or not
     */
    private record WordCounter(int counter, boolean lastSpace) {
        public WordCounter accumulate(Character c) {
            if (Character.isWhitespace(c)) {
                return lastSpace ? this : new WordCounter(counter, true);
            } else {
                return lastSpace ? new WordCounter(counter + 1, false) : this;
            }
        }

        public WordCounter combine(WordCounter wordCounter) {
            return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
        }
    }

    /**
     * Spliterator for words in a sentence
     */
    private static class WordCounterSpliterator implements Spliterator<Character> {
        private final String string;
        private int currentChar = 0;

        private WordCounterSpliterator(String string) {
            this.string = string;
        }

        @Override
        public boolean tryAdvance(Consumer<? super Character> action) {
            action.accept(string.charAt(currentChar++));
            return currentChar < string.length();
        }

        @Override
        public Spliterator<Character> trySplit() {
            final var currentSize = string.length() - currentChar;
            if (currentSize < 10) {
                return null;
            }
            for (var splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
                if (Character.isWhitespace(string.charAt(splitPos))) {
                    final Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));
                    currentChar = splitPos;
                    return spliterator;
                }
            }
            return null;
        }

        @Override
        public long estimateSize() {
            return string.length() - currentChar;
        }

        @Override
        public int characteristics() {
            return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
        }
    }
}
