package com.sks.averma.dp.tree;

import com.sks.leetcode.common.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TreeDiameter_Nary {
    /**
     * Time Complexity : O(n)
     * Space Complexity: O(n)
     */
    public int diameter_by_height(Node root) {
        Map<Node, Integer> nhMap = new HashMap<>();
        calculateHeight(root, nhMap);
        for (Node n : nhMap.keySet())
            System.out.println(n.val + "->" + nhMap.get(n));
        int diameter = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int m1 = 0, m2 = 0;
            for (Node child : node.children) {
                int ch = nhMap.get(child);
                if (ch > m1) {
                    m2 = m1;
                    m1 = ch;
                } else if (ch > m2) m2 = ch;
                stack.push(child);
            }
            int temp = 1 + Math.max(m1, m2);
            int ans = Math.max(temp, 1 + m1 + m2);
            diameter = Math.max(diameter, ans);
        }
        return diameter - 1;
    }


    private int calculateHeight(Node node, Map<Node, Integer> nhMap) {
        if (node == null) return 0;
        if (nhMap.containsKey(node)) return nhMap.get(node);
        int maxChildHeight = 0;
        for (Node child : node.children) {
            maxChildHeight = Math.max(maxChildHeight, calculateHeight(child, nhMap));
        }
        int height = maxChildHeight + 1;
        nhMap.put(node, height);
        return height;
    }

    public static void main(String[] args) {
        Node root = Node.prepareTestData_1();
        System.out.println("Height of N-ary tree = " + new TreeDiameter_Nary().diameter_by_height(root));
    }
}
