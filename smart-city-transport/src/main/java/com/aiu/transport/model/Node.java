package com.aiu.transport.model;

public class Node {
    private final String id;
    private final String name;
    private final double x;
    private final double y;
    private final String type;
    private final int population;
    
    public Node(String id, String name, double x, double y, String type, int population) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.type = type;
        this.population = population;
    }
    
    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getX() { return x; }
    public double getY() { return y; }
    public String getType() { return type; }
    public int getPopulation() { return population; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return id.equals(node.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
    
    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}
