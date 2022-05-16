package com.sks.learn.java.java8;

/**
 * 1. Default Method in Interface : BACKWARD-COMPATIBILITY
 * 2. Static Method in Interface : UTILITY METHODS (Interface can have main() method i.e you can run interface)
 */
public class InterfaceRevamp {
    public static void main(String[] args) {
        InterfaceRevamp ir = new InterfaceRevamp();
        ir.defaultMethodDemo();
        ir.staticMethodDemo();
    }

    /**
     * Before Java 1.8, all methods must be abstract & variables as constant
     * Java 1.8: Can have concrete methods -> default methods and Static methods
     * Why? BACKWARD-COMPATIBILITY for old interfaces so that they can have new methods without affecting existing code
     */
    private void defaultMethodDemo() {
        Test t = new Test();
        t.d1();
        t.d2();
    }

    /**
     *
     */
    private void staticMethodDemo() {
        Test t = new Test();
        /*- Does not work
         t.s1();
         Test.s2();
         Called COMPULSORY from interface only
         */
        MyIface1.s1();
        MyIface2.s2();
    }

    class Test implements MyIface1, MyIface2 {
        @Override
        public void d1() {
            System.out.println("m1: Default method: Implementation");
            MyIface1.super.d1();
        }
        /*-@Override Cant override static method of interface
        void s1() {
            System.out.println("s1: Static method: Implementation");
        }*/
    }

    interface MyIface1 {
        //From 1.8 onwards you can run interface also
        static void main(String[] args) {
            System.out.println("MyIface1 main method");
        }

        default void d1() {
            System.out.println("MyIface1.d1: Default method: Interface");
        }

        default void d2() {
            System.out.println("MyIface1.d2: Default method: Interface");
        }

        static void s1() {
            System.out.println("MyIface1.s1: Static method: Interface");
        }
    }

    interface MyIface2 {
        default void d1() {
            System.out.println("MyIface2.d1: Default method: Interface");
        }

        static void s2() {
            System.out.println("MyIface2.s2: Static method: Interface");
        }
    }
}
