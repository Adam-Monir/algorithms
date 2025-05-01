package com.aiu.transport.algorithms.shortest;

import com.aiu.transport.model.*;
import java.util.*;

public class Dijkstra {
    public Map<Node, Path> shortestPath(Graph graph, Node src) {
        Map<Node, Double> distances = new HashMap<>();
        Map<Node, Node> previous = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        
        // Initialize distances
        for (Node node : graph.getAllNodes()) {
            distances.put(node, Double.MAX_VALUE);
            previous.put(node, null);
        }
        distances.put(src, 0.0);
        queue.add(src);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            for (Edge edge : graph.getNeighbors(current)) {
                Node neighbor = edge.getTo();
                double newDist = distances.get(current) + edge.getDistance();
                
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        
        // Build path results
        Map<Node, Path> results = new HashMap<>();
        for (Node node : graph.getAllNodes()) {
            if (distances.get(node) < Double.MAX_VALUE) {
                results.put(node, buildPath(node, previous, distances));
            }
        }
        return results;
    }
    
    private Path buildPath(Node target, Map<Node, Node> previous, Map<Node, Double> distances) {
        List<Node> path = new ArrayList<>();
        for (Node node = target; node != null; node = previous.get(node)) {
            path.add(node);
        }
        Collections.reverse(path);
        return new Path(path, distances.get(target));
    }
    
    public static class Path {
        private final List<Node> nodes;
        private final double totalDistance;
        
        public Path(List<Node> nodes, double totalDistance) {
            this.nodes = nodes;
            this.totalDistance = totalDistance;
        }
        
        public List<Node> getNodes() { return nodes; }
        public double getTotalDistance() { return totalDistance; }
    }
}
