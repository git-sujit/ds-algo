package com.sks.interview_2022;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Build Nested Transaction
 * Refer: https://leetcode.com/discuss/interview-question/279913/Key-Value-Store-with-transaction
 */
public class DoorDash {
    Stack<Map<String, String>> tranStack = new Stack<>();
    Map<String, String> master = new HashMap<>();

    String get(String key) {
        return master.get(key);
    }

    void put(String key, String value) {
        master.put(key, value);
    }

    boolean commit() {
        while (!tranStack.isEmpty()) {
            Map<String, String> rem = tranStack.pop();
            for (Map.Entry<String, String> e : rem.entrySet())
                put(e.getKey(), e.getValue());
        }
        return true;
    }

    boolean begin() {
        tranStack.push(new HashMap<>());
        return true;
    }

    boolean rollback() {
        Map<String, String> rem = tranStack.pop();
        for (String k : rem.keySet())
            master.remove(k);
        return true;
    }
}
