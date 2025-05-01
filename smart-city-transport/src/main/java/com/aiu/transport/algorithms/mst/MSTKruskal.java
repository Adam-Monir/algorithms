package com.aiu.transport.algorithms.mst;

import com.aiu.transport.model.*;
import java.util.*;

public class MSTKruskal {
    public Set<Edge> computeMST(Graph graph) {
        Set<Edge> result = new HashSet<>();
        List<Edge> edges = new ArrayList<>(graph.getAllEdges());
        edges.sort(Comparator.comparingDouble(Edge::getDistance));
        
        UnionFind uf = new UnionFind(graph.getAllNodes().size());
        Map<Node, Integer> nodeToId = new HashMap<>();
        int id = 0;
        for (Node node : graph.getAllNodes()) {
            nodeToId.put(node, id++);
        }
        
        for (Edge edge : edges) {
            Node from = edge.getFrom();
            Node to = edge.getTo();
            
            int fromId = nodeToId.get(from);
            int toId = nodeToId.get(to);
            
            if (uf.find(fromId) != uf.find(toId)) {
                result.add(edge);
                uf.union(fromId, toId);
            }
        }
        return result;
    }
    
    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;
        
        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootX] = rootY;
                    if (rank[rootX] == rank[rootY]) {
                        rank[rootY]++;
                    }
                }
            }
        }
    }
}
