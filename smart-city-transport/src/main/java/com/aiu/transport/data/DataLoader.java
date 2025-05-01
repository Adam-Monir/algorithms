package com.aiu.transport.data;

import com.aiu.transport.model.*;
import java.io.IOException;
import java.util.*;

public class DataLoader {
    private final CSVParser csvParser = new CSVParser();
    private final Map<String, Node> nodesCache = new HashMap<>();
    
    public List<Node> loadNeighborhoods(String csvPath) throws IOException {
        List<Node> neighborhoods = new ArrayList<>();
        List<String[]> records = csvParser.readAll(csvPath);
        
        for (String[] record : records) {
            String id = record[0];
            String name = record[1];
            int population = Integer.parseInt(record[2]);
            String type = record[3];
            double x = Double.parseDouble(record[4]);
            double y = Double.parseDouble(record[5]);
            
            Node neighborhood = new Node(id, name, x, y, type, population);
            neighborhoods.add(neighborhood);
            nodesCache.put(id, neighborhood);
        }
        return neighborhoods;
    }
    
    public List<Facility> loadFacilities(String csvPath) throws IOException {
        List<Facility> facilities = new ArrayList<>();
        List<String[]> records = csvParser.readAll(csvPath);
        
        for (String[] record : records) {
            String id = record[0];
            String name = record[1];
            String type = record[2];
            double x = Double.parseDouble(record[3]);
            double y = Double.parseDouble(record[4]);
            
            Facility facility = new Facility(id, name, x, y, type);
            facilities.add(facility);
            nodesCache.put(id, facility);
        }
        return facilities;
    }
    
    public List<Edge> loadRoads(String csvPath) throws IOException {
        List<Edge> roads = new ArrayList<>();
        List<String[]> records = csvParser.readAll(csvPath);
        
        for (String[] record : records) {
            String fromId = record[0];
            String toId = record[1];
            double distance = Double.parseDouble(record[2]);
            int capacity = Integer.parseInt(record[3]);
            int condition = Integer.parseInt(record[4]);
            
            Node from = nodesCache.get(fromId);
            Node to = nodesCache.get(toId);
            
            if (from != null && to != null) {
                roads.add(new Edge(from, to, distance, capacity, condition));
            }
        }
        return roads;
    }
    
    public Map<String, Node> getNodesCache() {
        return Collections.unmodifiableMap(nodesCache);
    }
}
