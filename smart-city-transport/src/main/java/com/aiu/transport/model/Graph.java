package com.aiu.transport.model;

import java.util.*;

public class Graph {
    private final Map<Node, List<Edge>> adjacencyList = new HashMap<>();
    
    public void addNode(Node node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }
    
    public void addEdge(Edge edge) {
        Node from = edge.getFrom();
        Node to = edge.getTo();
        
        if (!adjacencyList.containsKey(from)) {
            addNode(from);
        }
        if (!adjacencyList.containsKey(to)) {
            addNode(to);
        }
        
        adjacencyList.get(from).add(edge);
        // For undirected graph, add the reverse edge
        adjacencyList.get(to).add(new Edge(to, from, edge.getDistance(), edge.getCapacity(), edge.getCondition()));
    }
    
    public List<Edge> getNeighbors(Node node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }
    
    public Set<Node> getAllNodes() {
        return adjacencyList.keySet();
    }
    
    public List<Edge> getAllEdges() {
        List<Edge> edges = new ArrayList<>();
        for (List<Edge> edgeList : adjacencyList.values()) {
            edges.addAll(edgeList);
        }
        return edges;
    }
}
