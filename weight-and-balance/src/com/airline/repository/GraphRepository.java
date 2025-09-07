package com.airline.repository;

import com.airline.model.GraphNode;
import java.util.HashMap;
import java.util.Map;

public class GraphRepository {
    private final Map<String, GraphNode> graphMap = new HashMap<>();

    public void save(GraphNode node) {
        graphMap.put(node.getId(), node);
    }

    public GraphNode findById(String id) {
        return graphMap.get(id);
    }

    public Map<String, GraphNode> findAll() {
        return graphMap;
    }
}
