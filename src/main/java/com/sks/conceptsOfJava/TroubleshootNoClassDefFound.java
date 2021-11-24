package com.sks.conceptsOfJava;

public class TroubleshootNoClassDefFound {
    //How to Resolve java.lang.NoClassDefFoundError
    //failure of a Java class static initializer block or variable
    /**
     * Java static initializer: Statically initialize variables or block of code.
     * They are guaranteed
     *  1. To be executed only once in JVM lifecycle at the class loading time and are never executed again until JVM is restarted
     *  2. Thread safe by design
     *  When static code executed at Class Loading time terminates with unhandled exception then
     *      "java.lang.NoClassDefFoundError" happens
     *  REASON: The original problem is the ExceptionInInitializerError triggered following the failure of the static initializer code.
     *  This clearly demonstrates the importance of proper error handling and logging when using Java static initializers.
     *
     */
    public static void main(String[] args) {
        System.out.println("\n######## java.lang.NoClassDefFoundError Simulator - Training ########\n");

        try {
            // Create a new instance of ClassA (attempt #1)
            System.out.println("1st attempt to create a new instance of ClassA...");
            ClassA classA = new ClassA();

        } catch (Throwable any) {
            any.printStackTrace();
        }

        try {
            // Create a new instance of ClassA (attempt #2)
            System.out.println("2nd attempt to create a new instance of ClassA...");
            ClassA classA = new ClassA();

        } catch (Throwable any) {
            any.printStackTrace();
        }

        try {
            // Create a new instance of ClassA (attempt #3)
            System.out.println("3rd attempt to create a new instance of ClassA...");
            ClassA classA = new ClassA();

        } catch (Throwable any) {
            any.printStackTrace();
        }

        System.out.println("\n\ndone!");
    }
}

class ClassA {

    private final static String CLAZZ = ClassA.class.getName();
    // Problem replication switch ON/OFF
    private final static boolean REPLICATE_PROBLEM1 = true; // static variable initializer
    private final static boolean REPLICATE_PROBLEM2 = false; // static block{} initializer

    // STATIC VARIABLE executed at Class loading time
    private static String staticVariable = initStaticVariable();

    // Static initializer block executed at Class loading time
    static {
        // STATIC BLOCK code execution...
        if (REPLICATE_PROBLEM2) throw new IllegalStateException("ClassA.static{}: Internal Error!");
    }

    public ClassA() {
        System.out.println("Creating a new instance of "+ClassA.class.getName()+"...");
    }

    private static String initStaticVariable() {
        String stringData = "";
        if (REPLICATE_PROBLEM1) throw new IllegalStateException("ClassA.initStaticVariable(): Internal Error!");
        return stringData;
    }
}
