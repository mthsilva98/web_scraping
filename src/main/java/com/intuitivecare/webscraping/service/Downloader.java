package com.intuitivecare.webscraping.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Downloader {
    private static final String DOWNLOAD_DIR = "downloads/";

    public static void downloadFiles(List<String> fileUrls) throws IOException {
        Files.createDirectories(Paths.get(DOWNLOAD_DIR));

        for (String fileUrl : fileUrls) {
            String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
            System.out.println("Baixando: " + fileName);

            try (InputStream in = new URL(fileUrl).openStream();
                 FileOutputStream out = new FileOutputStream(DOWNLOAD_DIR + fileName)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
        }
    }
}
