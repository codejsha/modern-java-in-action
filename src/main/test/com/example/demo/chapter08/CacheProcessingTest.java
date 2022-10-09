package com.example.demo.chapter08;

import com.example.demo.data.TextTestData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class CacheProcessingTest {
    private MessageDigest messageDigest;
    private List<String> lines;

    @BeforeEach
    void setUp() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-256");
        lines = TextTestData.INFERNO;
    }

    @Test
    void updateDigestTextLines() throws NoSuchAlgorithmException {
        var result = CacheProcessing.updateDigestTextLines(messageDigest, lines);
        assertNotNull(result);
        assertEquals(3, result.size());
        log.info("Update message digest for lines: {}", result);
    }
}
