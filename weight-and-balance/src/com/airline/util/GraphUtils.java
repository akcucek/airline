package com.airline.util;

import com.airline.model.GraphNode;

import java.util.*;

/**
 * Utility functions for graph algorithms (BFS, DFS, shortest path).
 */
public class GraphUtils {

    // Simple BFS
    public static List<GraphNode> bfs(GraphNode start) {
        List<GraphNode> visited = new ArrayList<>();
        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> seen = new HashSet<>();

        queue.add(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();
            visited.add(current);

            for (GraphNode neighbor : current.getNeighbors()) {
                if (!seen.contains(neighbor)) {
                    queue.add(neighbor);
                    seen.add(neighbor);
                }
            }
        }
        return visited;
    }

    // Simple DFS
    public static List<GraphNode> dfs(GraphNode start) {
        List<GraphNode> visited = new ArrayList<>();
        Set<GraphNode> seen = new HashSet<>();
        dfsHelper(start, visited, seen);
        return visited;
    }

    private static void dfsHelper(GraphNode node, List<GraphNode> visited, Set<GraphNode> seen) {
        visited.add(node);
        seen.add(node);
        for (GraphNode neighbor : node.getNeighbors()) {
            if (!seen.contains(neighbor)) {
                dfsHelper(neighbor, visited, seen);
            }
        }
    }
}

