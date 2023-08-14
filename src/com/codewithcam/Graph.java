package com.codewithcam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    private class Node {

        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void removeNode(String label) {

        if (!nodes.containsKey(label)) return;

        Node toRemove = nodes.get(label);
        List<Node> list = adjacencyList.get(toRemove);
        if (list == null) return;

        for (Node node : list)
            adjacencyList.get(node).remove(toRemove);

        nodes.remove(label);
        adjacencyList.remove(toRemove);
    }

    public void addEdge(String from, String to) {

        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null) throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeEdge(String from, String to) {

        if (!nodes.containsKey(from) || !nodes.containsKey(to)) throw new IllegalArgumentException();

        List<Node> list = adjacencyList.get(nodes.get(from));

        list.remove(nodes.get(to));

    }

    public void print() {

        for (Node node : adjacencyList.keySet()) {
            var targets = adjacencyList.get(node);
            if (!targets.isEmpty()) {
                System.out.println(node + " is connected to " + targets);
            }

        }

    }


}
