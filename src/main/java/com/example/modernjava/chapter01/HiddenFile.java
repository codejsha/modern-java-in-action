package com.example.modernjava.chapter01;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;

@Slf4j
public class HiddenFile {
    public static void main(String[] args) {
        log.info("Hidden files: {}", (Object[]) listHiddenFiles());
        log.info("Hidden files: {}", (Object[]) listHiddenFiles2());
        log.info("Hidden files: {}", (Object[]) listHiddenFiles3());
    }

    /**
     * list hidden files using anonymous class
     *
     * @return hidden files
     */
    public static File[] listHiddenFiles() {
        return new File(".").listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
    }

    /**
     * list hidden files using lambda expression
     *
     * @return hidden files
     */
    public static File[] listHiddenFiles2() {
        return new File(".").listFiles(file -> file.isHidden());
    }

    /**
     * list hidden files using method reference
     *
     * @return hidden files
     */
    public static File[] listHiddenFiles3() {
        return new File(".").listFiles(File::isHidden);
    }
}
