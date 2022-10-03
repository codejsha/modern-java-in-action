package com.example.demo.chapter01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class HiddenFileTest {
    private HiddenFile hiddenFile;

    @BeforeEach
    void setUp() {
        hiddenFile = new HiddenFile();
    }

    void assertHiddenFiles(File[] files) {
        assertNotNull(files);
        assertTrue(files.length > 0);
        assertTrue(files[0].isHidden());
        assertTrue(files[0].toString().contains(".git"));

        log.info("Hidden files: {}", (Object[]) files);
    }

    @Test
    void listHiddenFiles() {
        var files = hiddenFile.listHiddenFiles();
        assertHiddenFiles(files);
    }

    @Test
    void listHiddenFiles2() {
        var files = hiddenFile.listHiddenFiles2();
        assertHiddenFiles(files);
    }

    @Test
    void listHiddenFiles3() {
        var files = hiddenFile.listHiddenFiles3();
        assertHiddenFiles(files);
    }
}
