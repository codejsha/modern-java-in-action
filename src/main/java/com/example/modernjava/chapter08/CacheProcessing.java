package com.example.modernjava.chapter08;

import com.example.modernjava.data.TextData;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class CacheProcessing {

    public static void main(String[] args) {
        final var lines = TextData.INFERNO;

        try {
            final var messageDigest = MessageDigest.getInstance("SHA-256");
            log.info("Update message digest for lines: {}", updateDigestTextLines(messageDigest, lines));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Update message digest for lines
     *
     * @param messageDigest message digest
     * @param lines         text lines
     * @return result
     * @throws NoSuchAlgorithmException exception
     */
    public static Map<String, byte[]> updateDigestTextLines(MessageDigest messageDigest, List<String> lines)
            throws NoSuchAlgorithmException {
        final var dataToHash = new HashMap<String, byte[]>();

        lines.forEach(line -> {
            if (!dataToHash.containsKey(line)) {
                dataToHash.computeIfAbsent(line, key -> messageDigest.digest(line.getBytes(StandardCharsets.UTF_8)));
            }
        });

        return dataToHash;
    }
}
