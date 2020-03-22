package com.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Solution {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        new Solution().solve();
    }

    public void solve() {
        // Step-1: Build a graph from inputs representing event "A B" as A -> B in this
        // directed graph.
        final Map<String, Set<String>> graph = buildGraph();

        // Step-2
        // Now traverse the graph and get to know the reach of each node i.e., set of
        // nodes you could reach from a given node.
        Map<String, Set<String>> reach = new HashMap<>();
        for (String node : graph.keySet()) {
            Set<String> seen = new HashSet<>();
            seen.add(node); // A node is reachable from itself - could optimize by not storing it explicitly
            // too.

            reach.put(node, seen);
            dfs(graph, node, seen); // Traverse and populate seen set for this node.
        }

        System.out.println(graph);
        System.out.println(reach);

        Set<String> candidateNodes = new HashSet<>(graph.keySet());
        // Step-3
        // Now compare reach of every pair of nodes (V^2 pairs if V = number of nodes).
        // If reach of node "B" is subset of
        // that of node "A", it would mean we could reach all the nodes B could and some
        // more from node "A" - hence B is redundant.
        // In this case, remove B from candidate list and proceed.
        // The idea is, at the end of all-pair-comparison, we would only have nodes that
        // have max reach and paths that aren't duplicated
        // by others.
        List<String> nodeList = new ArrayList<>(graph.keySet());
        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = i + 1; j < nodeList.size(); j++) {
                String node1 = nodeList.get(i);
                String node2 = nodeList.get(j);

                Set<String> reach1 = reach.get(node1);
                Set<String> reach2 = reach.get(node2);
                if (reach1.containsAll(reach2)) {
                    // reach2 is subset and node2 is redundant.
                    candidateNodes.remove(node2);
                } else if (reach2.containsAll(reach1)) {
                    // reach1 is subset and node1 is redundant.
                    candidateNodes.remove(node1);
                }
                // We should keep both nodes atleast for now.
            }
        }

        System.out.println("Candidates: " + candidateNodes);
        // Now map candidate nodes to the reach size and sort, because that is what we
        // need to print.
        List<Integer> sizes = candidateNodes.stream().map(node -> reach.get(node).size()).collect(Collectors.toList());
        Collections.sort(sizes);

        for (int i = sizes.size() - 1; i >= 0; i--) {
            System.out.print(sizes.get(i) + " ");
        }
    }

    // Traverse by DFS and
    private void dfs(final Map<String, Set<String>> graph, String startNode, Set<String> seen) {
        // TODO: Could optimize here, if a node is already seen/visited and if we know
        // what nodes we saw from there, we could cut traversal short.
        if (!graph.containsKey(startNode)) {
            return;
        }
        for (String neighbor : graph.get(startNode)) {
            dfs(graph, neighbor, seen);
            seen.add(neighbor);
        }
    }

    private Map<String, Set<String>> buildGraph() {
        final Map<String, Set<String>> graph = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // Read number of inputs given as first line.
            int count = new Integer(reader.readLine().trim());
            while (count-- > 0) {
                String line = reader.readLine().trim();
                String[] path = line.split(" "); // split on whitespace.
                populateGraph(path, graph);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return graph;
    }

    private void populateGraph(String[] path, Map<String, Set<String>> graph) {
        for (int i = 0; i < path.length - 1; i++) {
            // i goes till last but one node, because that would be terminal node without
            // outgoing edge.
            String from = path[i];
            String to = path[i + 1];
            graph.putIfAbsent(from, new HashSet<>());
            graph.get(from).add(to); // Add edge.
        }
    }
}
