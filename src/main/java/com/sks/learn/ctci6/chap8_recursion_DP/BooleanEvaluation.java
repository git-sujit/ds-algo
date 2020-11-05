package com.sks.learn.ctci6.chap8_recursion_DP;

public class BooleanEvaluation {

    public static int countEval(String exp, boolean targetResult) {
        if (isValidExp(exp)) {
            int totalCount = 0;
            for (int i = 0; i < exp.length(); i++) {
                if (i % 2 != 0) {
                    String left = exp.substring(0, i);
                    char op = exp.charAt(i);
                    String right = exp.substring(i + 1);
                    if (op == '&') {

                    } else if (op == '|') {

                    } else if (op == '^') {

                    }
                }
            }
            return totalCount;
        } else {
            System.out.println("FAILED:: Invalid Expression");
            return 0;
        }
    }

    public static int waysOfParenthesizing(String exp, boolean targetResult) {
        if (isValidExp(exp)) {
            //System.out.println("SUCCESS:: Valid Expression");
            boolean result = evaluateExpression(exp);
            System.out.println("Result = " + result);
            return 0;
        } else {
            System.out.println("FAILED:: Invalid Expression");
            return 0;
        }
    }

    private static boolean isValidExp(String exp) {
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            //TODO: Think OR vs AND
            if ((i % 2 == 0 && (c != '1' && c != '0')) || (i % 2 == 1 && (c != '&' && c != '^' && c != '|')))
                return false;
        }
        return true;
    }

    private static boolean evaluateExpression(String exp) {
        if (exp.length() == 1) {
            char c = exp.charAt(0);
            return c == '1';
        } else {
            char exp1 = exp.charAt(0);
            char op = exp.charAt(1);
            boolean b = evaluateExpression(exp.substring(2));
            char exp2;
            if (b)
                exp2 = '1';
            else
                exp2 = '0';
            return eval(exp1, op, exp2);
        }
    }

    private static boolean eval(char exp1, char op, char exp2) {
        if (op == '&') {
            return exp1 == '1' && exp2 == '1';
        } else if (op == '|') {
            return exp1 == '1' || exp2 == '1';
        } else if (op == '^') {
            return !(exp1 == exp2);
        } else
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        testBooleanEvaluation("0|1", false);
        testBooleanEvaluation("1^0", false);
        testBooleanEvaluation("1&0", false);
        testBooleanEvaluation("1&1", false);
        testBooleanEvaluation("1^0&1", false);
        testBooleanEvaluation("1^1", false);
        testBooleanEvaluation("|1^0|0|1", true);
        testBooleanEvaluation("0&0&0&1^1|0", true);
    }

    private static void testBooleanEvaluation(String exp, boolean result) {
        System.out.println("\nExpression = " + exp);
        waysOfParenthesizing(exp, result);
    }


}
