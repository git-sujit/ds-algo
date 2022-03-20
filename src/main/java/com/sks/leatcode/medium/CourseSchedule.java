package com.sks.leatcode.medium;

import java.util.*;
/**
 * Directed Acyclic Graph => all courses will be completed
 * Cycle => all course will not be completed
 */

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int[] pre : prerequisites)
            preMap.computeIfAbsent(pre[0], e -> new ArrayList<>()).add(pre[1]);
        System.out.println("preMap = " + preMap);
        for (int course = 0; course < numCourses; course++) {
            List<Integer> preList = preMap.get(course);
            if (preList == null || preList.isEmpty()) continue;
            if (hasCycle(course, preMap))
                return false;
        }
        return true;
    }

    private static boolean hasCycle(int course, Map<Integer, List<Integer>> preMap) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(course);
        while (!stack.isEmpty()) {
            int crs = stack.pop();
            visited.add(crs);
            List<Integer> preList = preMap.get(crs);
            if (preList != null) {
                for (int pre : preList) {
                    if (visited.contains(pre)) return true;
                    stack.push(pre);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numCourses = 4;
        demo(numCourses, prerequisites);

        prerequisites = new int[][]{{1, 0}, {0, 1}};
        numCourses = 2;
        demo(numCourses, prerequisites);
    }

    private static void demo(int numCourses, int[][] prerequisites) {
        System.out.println("\nnumCourses = " + numCourses + ", prerequisites = " + Arrays.deepToString(prerequisites));
        System.out.println("canFinish = " + canFinish(numCourses, prerequisites));
    }
}
