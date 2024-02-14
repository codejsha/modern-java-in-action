package com.example.modernjava.chapter08;

import com.example.modernjava.data.TextTestData;
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
    void testUpdateDigestTextLines() throws NoSuchAlgorithmException {
        final var result = CacheProcessing.updateDigestTextLines(messageDigest, lines);
        assertNotNull(result);
        assertEquals(3, result.size());
        log.info("Update message digest for lines: {}", result);
    }
}
