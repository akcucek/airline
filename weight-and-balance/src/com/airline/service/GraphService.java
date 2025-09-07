package com.airline.service;

import com.airline.model.GraphNode;

import java.util.*;

/**
 * Graph algorithms (BFS for shortest path).
 */
public class GraphService {

    public List<GraphNode> findShortestPath(GraphNode start, GraphNode end) {
        Map<GraphNode, GraphNode> prev = new HashMap<>();
        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();
            if (current.equals(end)) {
                return buildPath(prev, start, end);
            }
            for (GraphNode neighbor : current.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    prev.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        return Collections.emptyList();
    }

    private List<GraphNode> buildPath(Map<GraphNode, GraphNode> prev,
                                      GraphNode start,
                                      GraphNode end) {
        List<GraphNode> path = new LinkedList<>();
        for (GraphNode at = end; at != null; at = prev.get(at)) {
            path.add(0, at);
        }
        return path;
    }
}
