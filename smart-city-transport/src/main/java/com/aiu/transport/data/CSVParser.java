package com.aiu.transport.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public String[] parseLine(String line) {
        return line.split("\\s*,\\s*");
    }
    
    public List<String[]> readAll(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        List<String[]> records = new ArrayList<>();
        
        for (String line : lines) {
            if (!line.trim().isEmpty() && !line.startsWith("#")) {
                records.add(parseLine(line));
            }
        }
        return records;
    }
}
