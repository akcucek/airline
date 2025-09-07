package com.airline.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a graph node (used in load distribution or route maps).
 */
public class GraphNode {
    private final String id;
    private final List<GraphNode> neighbors;

    public GraphNode(String id) {
        this.id = id;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(GraphNode node) {
        neighbors.add(node);
    }

    public String getId() { return id; }
    public List<GraphNode> getNeighbors() { return neighbors; }

    @Override
    public String toString() {
        return "GraphNode{" +
                "id='" + id + '\'' +
                ", neighbors=" + neighbors.stream().map(GraphNode::getId).toList() +
                '}';
    }
}