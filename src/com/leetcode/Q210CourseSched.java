package com.leetcode;

import java.util.*;

public class Q210CourseSched {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) {
            return numCourses == 0 ? new int[] {} : new int[] {0};
        }

        // Build the graph as adj list.
        List[] graph = new List[numCourses];
        for (int course = 0; course < numCourses; course++) {
            graph[course] = new ArrayList<>();
        }

        for (int[] prereq : prerequisites) {
            final int from = prereq[0];
            final int to = prereq[1];

            graph[from].add(to);
        }

        // Now, if there is a loop - we couldn't finish courses if it is not a DAG i.e., there
        // are loops in the graph.
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        for (int course = 0; course < numCourses; course++) {
            if (visited.contains(course)) continue;

            if (!dfs(course, graph, visited, new HashSet<>(), stack)) {
                return new int[] {};
            }
        }

        int idx = 0;
        int[] result = new int[numCourses];
        while (!stack.isEmpty()) {
            result[idx++] = stack.pop();
        }
        return result;
    }

    private boolean dfs(int course, List[] graph, Set<Integer> visited,
                        Set<Integer> path, Deque<Integer> stack) {
        if (path.contains(course)) {
            return false;
        }
        if (visited.contains(course) || graph[course] == null) {
            stack.push(course);
            return true;
        }

        visited.add(course);
        path.add(course);

        for (int prereq : (List<Integer>)graph[course]) {
            if (!dfs(prereq, graph, visited, path, stack)) {
                return false;
            }
        }
        stack.push(course);
        return true;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q210CourseSched().findOrder(3, new int[][]{{0, 1}, {0, 2}, {1, 2}})));
    }
}
