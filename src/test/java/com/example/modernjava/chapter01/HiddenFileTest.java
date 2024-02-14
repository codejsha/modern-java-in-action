package com.example.modernjava.chapter01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class HiddenFileTest {
    @BeforeEach
    void setUp() {
    }

    void assertHiddenFiles(File[] files) {
        assertNotNull(files);
        assertTrue(files.length > 0);
        assertTrue(files[0].isHidden());
        assertTrue(files[0].toString().contains(".git"));
        log.info("Hidden files: {}", (Object[]) files);
    }

    @Test
    void testListHiddenFiles() {
        final var files = HiddenFile.listHiddenFiles();
        assertHiddenFiles(files);
    }

    @Test
    void testListHiddenFiles2() {
        final var files = HiddenFile.listHiddenFiles2();
        assertHiddenFiles(files);
    }

    @Test
    void testListHiddenFiles3() {
        final var files = HiddenFile.listHiddenFiles3();
        assertHiddenFiles(files);
    }
}
