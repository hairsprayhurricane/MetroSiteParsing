package org.example;

public class Station {
    private String name;
    private String line;

    public Station(String name, String line) {
        this.name = name;
        this.line = line;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", line='" + line + '\'' +
                '}';
    }
}
