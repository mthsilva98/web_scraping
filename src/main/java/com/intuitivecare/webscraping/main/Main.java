package com.intuitivecare.webscraping.main;

import com.intuitivecare.webscraping.service.Scraper;
import com.intuitivecare.webscraping.service.Downloader;
import com.intuitivecare.webscraping.service.Zipper;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // 1️⃣ Buscar links dos PDFs
            List<String> pdfLinks = Scraper.getPdfLinks();

            if (pdfLinks.isEmpty()) {
                System.out.println("Nenhum anexo encontrado.");
                return;
            }

            // 2️⃣ Baixar os arquivos
            Downloader.downloadFiles(pdfLinks);

            // 3️⃣ Compactar os arquivos
            Zipper.zipFiles();

            System.out.println("Processo concluído com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
