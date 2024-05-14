package org.example;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ParseWebPage p = new ParseWebPage();

        System.out.println(p.getHtmlCodeWebPage());

        List<MetroLine> metroLineList = new ArrayList<>();
        metroLineList = p.parseMetroLines();
        System.out.println("Линии:");
        for(MetroLine met : metroLineList){
            System.out.println(met.toString());
        }

        List<Station> stationsList = new ArrayList<>();
        stationsList = p.parseStations();
        System.out.println("Станции:");
        for(Station met : stationsList){
            System.out.println(met.toString());
        }
    }
}