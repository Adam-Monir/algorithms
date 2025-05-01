package com.aiu.transport.model;

public class Edge {
    private final Node from;
    private final Node to;
    private final double distance;
    private final int capacity;
    private final int condition;
    
    public Edge(Node from, Node to, double distance, int capacity, int condition) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.capacity = capacity;
        this.condition = condition;
    }
    
    // Getters
    public Node getFrom() { return from; }
    public Node getTo() { return to; }
    public double getDistance() { return distance; }
    public int getCapacity() { return capacity; }
    public int getCondition() { return condition; }
    
    @Override
    public String toString() {
        return from + " -> " + to + " (" + distance + "km)";
    }
}
