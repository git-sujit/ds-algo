package com.sks.algo2020.club;

import java.util.*;

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

    public static int perimeter_onlyOneIsland(int[][] lw) {
        int xlen = lw.length;
        int ylen = lw[0].length;
        int numOfNodes = 0;
        int grandNeighbors = 0;
        for (int r = 0; r < xlen; r++) {
            for (int c = 0; c < ylen; c++) {
                if (lw[r][c] == 1) {
                    numOfNodes++;
                }
                if (r - 1 >= 0 && lw[r - 1][c] == 1) grandNeighbors++;
                if (c - 1 >= 0 && lw[r][c - 1] == 1) grandNeighbors++;
                if (r + 1 < xlen && lw[r + 1][c] == 1) grandNeighbors++;
                if (c + 1 < ylen && lw[r][c + 1] == 1) grandNeighbors++;
            }
        }
        return 4 * numOfNodes - grandNeighbors;
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

    private static int distinctIslands(Map<Node, List<Node>> islands) {
        if (islands == null || islands.size() == 0) return -1;
        int count = 0;
        int dupCount = 0;
        for (Map.Entry<Node, List<Node>> e1 : islands.entrySet()) {
            count++;
            List<Node> nodes1 = e1.getValue();
            int r1 = nodes1.get(0).row;
            int c1 = nodes1.get(0).column;
            for (Map.Entry<Node, List<Node>> e2 : islands.entrySet()) {
                if (!e1.getKey().equals(e2.getKey()) && e1.getValue().size() == e2.getValue().size()) {
                    List<Node> nodes2 = e2.getValue();
                    int r2 = nodes2.get(0).row;
                    int c2 = nodes2.get(0).column;
                    int rd = r1 - r2;
                    int cd = c1 - c2;
                    for (int i = 1; i < nodes1.size(); i++) {
                        if (rd == (nodes1.get(i).row - nodes2.get(i).row) && cd == (nodes1.get(i).column - nodes2.get(i).column)) {
                            if (i == nodes1.size() - 1)
                                dupCount++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return count - dupCount / 2;
    }

    private static int distinctIslands_2(Map<Node, List<Node>> islands) {
        if (islands == null || islands.size() == 0) return -1;
        int count = 0;
        for (Map.Entry<Node, List<Node>> e1 : islands.entrySet()) {
            count++;
            List<Node> nodes1 = e1.getValue();
            int r1 = nodes1.get(0).row;
            int c1 = nodes1.get(0).column;
            boolean dup = true;
            for (Map.Entry<Node, List<Node>> e2 : islands.entrySet()) {
                if (!e1.getKey().equals(e2.getKey()) && e1.getValue().size() == e2.getValue().size()) {
                    List<Node> nodes2 = e2.getValue();
                    int r2 = nodes2.get(0).row;
                    int c2 = nodes2.get(0).column;
                    int rd = r1 - r2;
                    int cd = c1 - c2;
                    dup = true;
                    for (int i = 1; i < nodes1.size(); i++) {
                        if (rd != (nodes1.get(i).row - nodes2.get(i).row) || cd != (nodes1.get(i).column - nodes2.get(i).column)) {
                            dup = false;
                            break;
                        }
                    }
                    if (dup) count--;
                }
            }
        }
        return count;
    }

    private static int distinctIslands_1(Map<Node, List<Node>> islands) {
        if (islands == null || islands.size() == 0) return -1;
        int count = 0;
        for (Map.Entry<Node, List<Node>> e1 : islands.entrySet()) {
            count++;
            List<Node> nodes1 = e1.getValue();
            int r1 = nodes1.get(0).row;
            int c1 = nodes1.get(0).column;
            boolean dup = false;
            for (Map.Entry<Node, List<Node>> e2 : islands.entrySet()) {
                List<Node> nodes2 = e2.getValue();
                if (e1.getKey() != e2.getKey() && nodes1.size() == nodes2.size()) {
                    int r2 = nodes2.get(0).row;
                    int rd = r1 - r2;
                    int c2 = nodes2.get(0).column;
                    int cd = c1 - c2;
                    for (int i = 1; i < nodes1.size(); i++) {
                        r1 = nodes1.get(i).row;
                        r2 = nodes2.get(i).row;
                        c1 = nodes1.get(1).column;
                        c2 = nodes2.get(1).column;
                        if (i == nodes1.size() - 1 && (rd == (r1 - r2) && cd == (c1 - c2))) {
                            dup = true;
                        }
                    }
                }
            }
            if (dup) count--;
        }
        return count;
    }

    private static void updateIslands(Map<Node, List<Node>> islands, int[][] lw) {
        for (Map.Entry<Node, List<Node>> entry : islands.entrySet()) {
            Node startNode = entry.getKey();
            List<Node> islandNodes = entry.getValue();
            int p = 4 * islandNodes.size();
            int grandNeighbours = 0;
            for (Node n : islandNodes) {
                int neighbours = 0;
                int r = n.row;
                int c = n.column;
                if (islandNodes.contains(new Node(r - 1, c))) {
                    neighbours++;
                    if (r - 1 == 0) startNode.isNotClosed = true;
                }
                if (islandNodes.contains(new Node(r, c - 1))) {
                    neighbours++;
                    if (c - 1 == 0) startNode.isNotClosed = true;
                }
                if (islandNodes.contains(new Node(r + 1, c))) {
                    neighbours++;
                    if (r + 1 == lw.length - 1) startNode.isNotClosed = true;
                }
                if (islandNodes.contains(new Node(r, c + 1))) {
                    neighbours++;
                    if (c + 1 == lw[0].length - 1) startNode.isNotClosed = true;
                }
                grandNeighbours += neighbours;
            }
            startNode.perimeter = p - grandNeighbours;
        }
    }

    public static void main(String[] args) {
        System.out.println("################# TEST RUN ################# ");
        //int[][] array = {{0, 1, 0, 1}, {0, 1, 0, 1}, {1, 1, 1, 0}, {0, 0, 0, 1}};
        //int[][] array = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        //int[][] array = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        //int[][] array = {{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int[][] array = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        //int[][] array = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        boolean[][] visited = new boolean[array.length][array[0].length];
        testIslands(array, visited);

        System.out.println("################# TEST RUN ################# ");
        int[][] array1 = {{1, 1, 0, 1, 1}, {0, 1, 0, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 0, 0, 1}};
        visited = new boolean[array1.length][array1[0].length];
        testIslands(array1, visited);

        System.out.println("################# TEST RUN ################# ");
        int[][] array2 = {{1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1}};
        visited = new boolean[array2.length][array2[0].length];
        testIslands(array2, visited);
    }

    public static void testIslands(int[][] array, boolean[][] visited) {
        System.out.println("##### ADJACENCY MATRIX");
        for (int[] a : array) {
            System.out.println(Arrays.toString(a));
        }
        Map<Node, List<Node>> islands = islandAnalysis(array, visited);
        updateIslands(islands, array);
        System.out.println("Total number of islands = " + islands.keySet().size());
        int maxLength = 0;
        for (Map.Entry<Node, List<Node>> entry : islands.entrySet()) {
            if (maxLength < entry.getValue().size())
                maxLength = entry.getValue().size();
            System.out.println("Island : " + entry + ", Perimeter=" + entry.getKey().perimeter + ", isClosedIsland=" + !entry.getKey().isNotClosed);
        }
        System.out.println("No. of Distinct islands = " + distinctIslands(islands));
        System.out.println("Max Length of island : " + maxLength);
    }

    static class Node {
        public int row;
        public int column;
        public int perimeter;
        public boolean isNotClosed;

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



