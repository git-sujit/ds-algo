package com.sks.leatcode.hard;


import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;
/*- SPIRAL BACKTRACKING
Idea: Clockwise + Direction
Direction: 0-up, 1-right, 2-down, 3-left
Directions:{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}
   0
3<-|->1
   2
          (0,1)
            |
  (-1,0)<-(0,0)->(1,0)
            |
          (0,-1)
 */

/**
 * The room is modeled as an m x n binary grid where 0 represents a wall and 1 represents an empty slot.
 * The robot starts at an unknown location in the room that is guaranteed to be empty,
 * and you do not have access to the grid, but you can move the robot using the given API Robot.
 * You are tasked to use the robot to clean the entire room (i.e., clean every empty cell in the room).
 * The robot with the four given APIs can move forward, turn left, or turn right. Each turn is 90 degrees.
 */
public class RobotRoomCleaner {
    private Robot robot;
    private Set<Pair<Integer, Integer>> visited = new HashSet<>();
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }

    private void backtrack(int row, int col, int dir) {
        visited.add(new Pair(row, col));
        robot.clean();
        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int i = 0; i < 4; i++) {
            int curr_dir = (dir + i) % 4;
            int curr_row = row + directions[curr_dir][0];
            int curr_col = col + directions[curr_dir][1];
            if (!visited.contains(new Pair(curr_row, curr_col)) && robot.move()) {
                backtrack(curr_row, curr_col, curr_dir);
                goBack();
            }
            robot.turnRight();
        }
    }

    private void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public static void main(String[] args) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair<>(1, 2));
        visited.add(new Pair<>(1, 1));
        visited.add(new Pair<>(2, 1));
        System.out.println(visited.contains(new Pair<>(2, 2)));
    }

    interface Robot {
        public boolean move();

        public void turnLeft();

        public void turnRight();

        public void clean();
    }
}
