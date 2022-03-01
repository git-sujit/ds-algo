package com.sks.averma.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle.
 * The task is to choose the place in the initial circle so that you are the last one remaining and so survive.
 */
public class JosephusProblem {
    /**
     * Approach: create a list and add all values from 1 to n in it
     */
    public static int gameOfDeathInCircle_better(int n, int k) {
        List<Integer> persons = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            persons.add(i);
        int killIndex = 0;
        //System.out.println("Start, Persons = " + persons);
        gameOfDeathInCircle_better(n, k - 1, killIndex, persons);
        return persons.get(0);
    }

    private static void gameOfDeathInCircle_better(int n, int k, int killIndex, List<Integer> persons) {
        //Base Condition
        if (persons.size() == 1) return;
        killIndex = (killIndex + k) % persons.size();
        persons.remove(killIndex);
        //Hypothesis
        gameOfDeathInCircle_better(n - 1, k, killIndex, persons);
    }

    /**
     *
     */
    public static int gameOfDeathInCircle(int n, int k) {
        if (n == 1) return 1;
        else
            return (gameOfDeathInCircle(n - 1, k) + k - 1) % n + 1;
    }

    public static void main(String[] args) {
        int n = 40;
        int k = 7;
        //demo(n, k);
        //demo(40, 2);
        demo(10, 3);
    }

    private static void demo(int n, int k) {
        System.out.println("\nn = " + n + ", k = " + k);
        System.out.println("Survivor = " + gameOfDeathInCircle(n, k));
        System.out.println("[Better] Survivor = " + gameOfDeathInCircle_better(n, k));
    }
}
