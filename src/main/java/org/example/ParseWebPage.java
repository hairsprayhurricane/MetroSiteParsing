package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseWebPage {
    public String getHtmlCodeWebPage() throws IOException {
        String url = "https://skillbox-java.github.io/";
        Document document = Jsoup.connect(url).get();
        String htmlCode = String.valueOf(document);
        return htmlCode;
    }
    public List<MetroLine> parseMetroLines() throws IOException {
        String url = "https://skillbox-java.github.io/";
        Document doc = Jsoup.connect(url).get();

        Elements lineElements = doc.select(".js-toggle-depend.s-depend-control-single");

        List<MetroLine> list = new ArrayList<>();

        for (Element lineElement : lineElements) {
            String name = lineElement.select(".t-metrostation-list-header").text();
            String number = String.valueOf(list.size() + 1);

            list.add(new MetroLine(name, number));
        }

        return list;
    }
    public List<Station> parseStations() throws IOException {
        String url = "https://skillbox-java.github.io/";
        Document doc = Jsoup.connect(url).get();

        Elements stationElements = doc.select(".single-station");

        List<Station> list = new ArrayList<>();

        for (Element stationElement : stationElements) {
            String name = stationElement.select(".name").text();
            Elements lineNumbers = stationElement.select(".t-icon-metroln");

            String lineNumber = "";
            for (Element lineNumberElement : lineNumbers) {
                String line = lineNumberElement.attr("class");
                if (!line.isEmpty()) {
                    line = line.substring(line.indexOf("ln-") + 3);
                    if (!lineNumber.isEmpty()) {
                        lineNumber += ", " + line;
                    } else {
                        lineNumber = line;
                    }
                }
            }

            list.add(new Station(name, lineNumber));
        }

        return list;
    }






}
