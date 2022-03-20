package com.sks.algo2021;

public class TestInheritance {
    @Override
    public String toString() {
        return "Parent";
    }

    public static void main(String[] args) {
        TestInheritance ti = new TestInheritance();
        System.out.println(ti);
        Child c = new Child();
        System.out.println(c);
    }
}

class Child extends TestInheritance {
    @Override
    public String toString() {
        return super.toString() + "Child";
    }
}
