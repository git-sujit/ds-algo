package com.sks.averma.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Recursive Tree
 * Given n, generate all balanced parentheses
 */
public class BalancedParentheses {
    public static List<String> allBalancedParens(int n) {
        List<String> parenList = new ArrayList<>();
        allBalancedParens(n, n, "", parenList);
        return parenList;
    }

    private static void allBalancedParens(int open, int close, String paren, List<String> parenList) {
        System.out.println("abp(" + open + ", " + close + ", " + paren + ", " + parenList + ")");
        if (open == 0 && close == 0) {
            parenList.add(paren);
            return;
        }
        if (open > 0)
            allBalancedParens(open - 1, close, paren + "(", parenList);
        if (close > 0 && open != close)
            allBalancedParens(open, close - 1, paren + ")", parenList);
    }

    public static void main(String[] args) {
        demo(3);
        //demo(4);
        //demo(5);
    }

    private static void demo(int n) {
        System.out.println("\nn : " + n);
        List<String> parens = allBalancedParens(n);
        System.out.println("Balanced Parentheses : " + parens.size() + " => " + parens);
    }
}
