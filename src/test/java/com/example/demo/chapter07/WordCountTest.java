package com.example.demo.chapter07;

import com.example.demo.data.TextTestData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class WordCountTest {
    private String sentence;

    @BeforeEach
    void setUp() {
        sentence = String.join("", TextTestData.INFERNO);
    }

    @Test
    void countWordsIteratively() {
        var result = WordCount.countWordsIteratively(sentence);
        assertEquals(19, result);
        log.info("Word count for sentence: {}", result);
    }

    @Test
    void countWordsUsingStream() {
        var result = WordCount.countWordsUsingStream(sentence);
        assertEquals(19, result);
        log.info("Word count for sentence: {}", result);
    }
}
