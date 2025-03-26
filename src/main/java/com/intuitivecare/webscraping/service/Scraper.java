package com.intuitivecare.webscraping.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scraper {
    private static final String URL_BASE = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";

    public static List<String> getPdfLinks() throws IOException {
        List<String> pdfLinks = new ArrayList<>();
        Document doc = Jsoup.connect(URL_BASE).get();
        Elements links = doc.select("a[href]");

        for (Element link : links) {
            String fileUrl = link.absUrl("href"); // Captura o link completo
            String linkText = link.text(); // Captura o texto visível no link

            // Verifica se o link é um PDF e se o texto contém "Anexo I" ou "Anexo II"
            if (fileUrl.toLowerCase().endsWith(".pdf") &&
                    (linkText.contains("Anexo I") || linkText.contains("Anexo II"))) {
                pdfLinks.add(fileUrl); // Adiciona o link se passar no filtro
            }
        }
        return pdfLinks;
    }

}
