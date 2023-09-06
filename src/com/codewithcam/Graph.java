package com.codewithcam;

import java.util.HashMap;
import java.util.Stack;
import java.util.*;

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
        if (list == null) {
            nodes.remove(label);
            return;
        }

        for (Node node : list)
            adjacencyList.get(node).remove(toRemove);

        nodes.remove(label);
        adjacencyList.remove(toRemove);
    }

    public void addEdge(String from, String to) {

        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null) throw new IllegalArgumentException();

        if (adjacencyList.get(fromNode) == null || adjacencyList.get(fromNode).contains(toNode)) return;

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

    public void traverseDepthFirst(String string) {

        Node node = nodes.get(string);
        if (node == null) return;

        traverseDepthFirst(node, new HashSet<>());
    }

    private void traverseDepthFirst(Node node, Set<Node> visited) {

        if (!visited.add(node))
            return;

        System.out.println(node.toString());

        for (Node neighbour : adjacencyList.get(node))
            traverseDepthFirst(neighbour, visited);
    }

    public void traverseDepthFirstIterative(String string) {

        Node node = nodes.get(string);
        if (node == null) return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current);
            visited.add(current);
            for (Node neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor))
                    stack.push(neighbor);
            }
        }

    }

    public void traverseBreadthFirstIterative(String string) {

        Node node = nodes.get(string);
        if (node == null) return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();

            if (visited.contains(current)) continue;

            System.out.println(current);
            visited.add(current);

            queue.addAll(adjacencyList.get(current));
        }

    }


}
