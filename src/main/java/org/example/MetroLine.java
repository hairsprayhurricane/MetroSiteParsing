package org.example;

public class MetroLine {
    private String name;
    private String number;

    public MetroLine(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "MetroLine{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
