package com.intuitivecare.webscraping.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper {
    private static final String DOWNLOAD_DIR = "downloads/";
    private static final String ZIP_FILE = "anexos.zip";

    public static void zipFiles() throws IOException {
        File dir = new File(DOWNLOAD_DIR);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".pdf"));

        if (files == null || files.length == 0) {
            System.out.println("Nenhum arquivo para compactar.");
            return;
        }

        try (FileOutputStream fos = new FileOutputStream(ZIP_FILE);
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {
            for (File file : files) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    zipOut.putNextEntry(zipEntry);
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fis.read(buffer)) > 0) {
                        zipOut.write(buffer, 0, len);
                    }
                }
            }
        }
        System.out.println("Arquivos compactados em " + ZIP_FILE);
    }
}
