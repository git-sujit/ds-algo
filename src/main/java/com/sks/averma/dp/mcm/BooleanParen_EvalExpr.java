package com.sks.averma.dp.mcm;

/**
 * Given a boolean expression with symbols: {T, F} and operators: {&, |, ^}
 * Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true
 */
public class BooleanParen_EvalExpr {
    /**
     * Time Complexity :
     * Space Complexity:
     */
    public static int countWaysToTrue(String exp) {
        if (exp == null || exp.length() == 0) return 0;
        return solve(exp, 0, exp.length() - 1, true);
    }

    private static int solve(String exp, int i, int j, boolean isTrue) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue) return 1;
            else return 0;
        }
        int ans = 0;
        //k:Operator will start at i+1 & jump 2 index
        for (int k = i + 1; k <= j - 1; k = k + 2) {
            int lt = solve(exp, i, k, true);
            int lf = solve(exp, i, k, false);
            int rt = solve(exp, k + 1, j, true);
            int rf = solve(exp, k + 1, j, false);
            if (exp.charAt(k) == '&') {
                if (isTrue) ans += lt * rt;
                else ans += lt * rf + lf * rt + lf * rf;
            } else if (exp.charAt(k) == '|') {
                if (isTrue) ans += lt * rf + lt * rt + lf * rt;
                else ans += lf * rf;
            }
            if (exp.charAt(k) == '^') {
                if (isTrue) ans += lt * rf + lf * rt;
                else ans += lt * rt + lf * rf;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        demo("T|F");
        demo("\"T^T^F");
    }

    private static void demo(String exp) {
        System.out.println("exp = " + exp + " => count ways to true: " + countWaysToTrue(exp));
    }
}
