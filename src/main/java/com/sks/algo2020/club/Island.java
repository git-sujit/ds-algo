package com.sks.algo2020.club;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author : Sujit K Singh
 * Purpose : Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands
 */
public class Island {
    public static Map<Node, List<Node>> islandAnalysis(int[][] lwMatrix, boolean[][] visited) {
        Map<Node, List<Node>> out = new HashMap<>();
        if (lwMatrix != null && visited != null) {
            for (int r = 0; r < lwMatrix.length; r++) {
                for (int c = 0; c < lwMatrix[r].length; c++) {
                    if (!visited[r][c]) {
                        visited[r][c] = true;
                        if (lwMatrix[r][c] == 1) {
                            Node startNode = new Node(r, c);
                            List<Node> contNodes = new ArrayList<>();
                            contNodes.add(startNode);
                            islandRecursive(lwMatrix, visited, startNode, contNodes);
                            out.put(startNode, contNodes);
                        }
                    }
                }
            }
        }
        return out;
    }

    private static void islandRecursive(int[][] lwMatrix, boolean[][] visited, Node startNode, List<Node> contNodes) {
        int r = startNode.row;
        int c = startNode.column;
        if (r - 1 >= 0) {
            if (!visited[r - 1][c] && lwMatrix[r - 1][c] == 1) {
                visited[r - 1][c] = true;
                contNodes.add(new Node(r - 1, c));
                islandRecursive(lwMatrix, visited, new Node(r - 1, c), contNodes);
            }
        }
        if (c - 1 >= 0) {
            if (!visited[r][c - 1] && lwMatrix[r][c - 1] == 1) {
                visited[r][c - 1] = true;
                contNodes.add(new Node(r, c - 1));
                islandRecursive(lwMatrix, visited, new Node(r, c - 1), contNodes);
            }
        }
        if (r + 1 < lwMatrix.length) {
            if (!visited[r + 1][c] && lwMatrix[r + 1][c] == 1) {
                visited[r + 1][c] = true;
                contNodes.add(new Node(r + 1, c));
                islandRecursive(lwMatrix, visited, new Node(r + 1, c), contNodes);
            }
        }
        if (c + 1 < lwMatrix[0].length) {
            if (!visited[r][c + 1] && lwMatrix[r][c + 1] == 1) {
                visited[r][c + 1] = true;
                contNodes.add(new Node(r, c + 1));
                islandRecursive(lwMatrix, visited, new Node(r, c + 1), contNodes);
            }
        }
    }

    public static int perimeter(int[][] lw) {
        int xlen = lw.length;
        int ylen = lw[0].length;
        System.out.println("xlen = " + xlen + ", ylen = " + ylen);

        return 0;
    }

    public static void dfs(int[][] a, boolean[][] v) {
        if (a == null || a.length == 0) return;
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[r].length; c++) {
                if (!v[r][c] && a[r][c] == 1) {
                    System.out.print("(" + r + "," + c + "), ");
                    v[r][c] = true;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //int[][] array = {{1, 1, 0, 1, 1}, {0, 1, 0, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 0, 0, 1}};
        int[][] array = {{1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1}};
        //int[][] array = {{0, 1, 0, 1}, {0, 1, 0, 1}, {1, 1, 1, 0}, {0, 0, 0, 1}};
        boolean[][] visited = new boolean[array.length][array[0].length];

        Map<Node, List<Node>> islands = islandAnalysis(array, visited);
        test(array, visited);
        System.out.println("Total number of islands = " + islands.keySet().size());
        int maxLength = 0;
        for (Map.Entry<Node, List<Node>> entry : islands.entrySet()) {
            if (maxLength < entry.getValue().size())
                maxLength = entry.getValue().size();
            System.out.println("Island : " + entry);
        }
        System.out.println("Max Length of island : " + maxLength);
    }

    public static void test(int[][] array, boolean[][] visited) {
        System.out.println("##### ADJACENCY MATRIX");
        for (int[] a : array) {
            System.out.println(Arrays.toString(a));
        }
        //dfs(array, visited);
        System.out.println("##### VISITED MATRIX");
        for (boolean[] v : visited) {
            System.out.println(Arrays.toString(v));
        }
    }

    static class Node {
        public int row;
        public int column;

        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public String toString() {
            return "(" + row + "," + column + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return row == node.row &&
                    column == node.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }
}



