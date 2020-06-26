package com.sks.learn.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class MyConsumer<T> implements Consumer<Integer> {
    @Override
    public void accept(Integer t) {
        System.out.println("Consumer: Outer Class, " + t);
    }
}

class MyPredicate<T> implements Predicate<Integer> {

    @Override
    public boolean test(Integer t) {
        System.out.println("Predicate: Outer Class, " + t);
        return t % 2 == 0;
    }

}

public class Java8FunctionalInterfaces {

    public static void main(String[] args) {
        // Consumer Functional Interface
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> c1 = new MyConsumer<Integer>();
        Consumer<Integer> c2 = new Consumer<Integer>() {
            @Override
            public void accept(java.lang.Integer t) {
                System.out.println("Consumer: Anonymous Inner Class, " + t);
            }
        };
        // Lambda Expression
        Consumer<Integer> c3 = t -> System.out.println("Consumer: Lambda, " + t);

        l.forEach(c1);
        l.forEach(c2);
        l.forEach(c3);

        // Predicate Functional Interface
        Predicate<Integer> p1 = new MyPredicate<Integer>();
        Predicate<Integer> p2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                System.out.println("Predicate: Anonymous Inner Class, " + t);
                return t % 2 == 0;
            }

        };
        Predicate<Integer> p3 = t -> t % 2 == 0;
        l.stream().filter(p1).forEach(t -> System.out.println(t));
        l.stream().filter(p2).forEach(t -> System.out.println(t));
        l.stream().filter(p3).forEach(t -> System.out.println(t));

        System.out.println("Custom functional interface::");
        // Custom Functional Interface: Using anonymous class
        TestLambdaFI funcInt = new TestLambdaFI() {
            public int sum(int a, int b) {
                return a + b;
            }

        };

        //l.forEach((t) -> System.out.println(funcInt.sum(t, 2)));

        System.out.println("Java8 Default Methods");
        //funcInt.myDefaultMethod_1(2);
        //funcInt.myDefaultMethod_2(4);
        //funcInt.myDefaultMethod_3(6);
        System.out.println("Java8 Static Default Methods");
        //TestLambdaFI.myStaticDefaultMethod(10);
    }

}
