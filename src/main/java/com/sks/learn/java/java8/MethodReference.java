package com.sks.learn.java.java8;

/**
 * Java Double Colon Operator:
 * -Method Reference
 * -Constructor Reference
 */
public class MethodReference {
    public MethodReference() {
        System.out.println("Constructor reference");
    }

    public static void m2() {
        System.out.println("Method reference: Static method");
    }

    public void m3() {
        System.out.println("Method reference: Instance method");
    }

    public static void main(String[] args) {
        demoLambdaExpr();
        demoDoubleColonOperator();
    }

    private static void demoDoubleColonOperator() {
        // Static Method reference
        InterF iFace = MethodReference::m2; // m1 method refers to m2 (Code Re-usability)
        iFace.m1();

        // Instance method reference
        MethodReference obj = new MethodReference();
        InterF iFace1 = obj::m3;
        iFace1.m1();

        // Constructor reference
        InterFConst iFaceConst = MethodReference::new;
        iFaceConst.get();
    }

    private static void demoLambdaExpr() {
        InterF iFace = () -> {
            System.out.println("Lambda expression implementation");
        };
        iFace.m1();
    }
}

@FunctionalInterface
interface InterF {
    void m1();
}

@FunctionalInterface
interface InterFConst {
    MethodReference get();
}
