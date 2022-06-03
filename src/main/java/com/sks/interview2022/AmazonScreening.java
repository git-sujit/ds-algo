package com.sks.interview2022;
//hello
/*
An Amazon pickup location has a series of lockers for packages to be dropped off
and picked up. Packages can come in many different sizes. We have lockers of
varying sizes as well.  Model the lockers, packages and pickup location and
implement an algorithm for efficiently finding the best possible empty locker
for a given package.
*/

import java.util.*;

/**
 * Location-Fixed
 * Locker dependant on box-size(S/M/L)
 * Locker(S/M/L)- something like this
 */
public class AmazonScreening {
}

enum Size {
    S, M, L
}

class Locker {
    private int lockerId;
    private Size lockerSize;
    private int lockerCode; // For Customer
    //private boolean isAvailable;

}

class Box {
    public Size boxSize;
}

class Location {
    public int locationCode; // For Carrier
    public static final int LOC_SIZE = 500;
    public List<Locker> lockerList;
    public Map<Size, Deque<Locker>> sizeBasedLockers;
    public int sCount;
    public int mCount;
    public int lCount;

    public Location() {
        locationCode = (int) Math.random() % LOC_SIZE;
        lockerList = new ArrayList<>();
        //sort(lockerList); // sort based on size - increasing order
        sizeBasedLockers = preapareSizeBasedDeque();
        Deque<Locker> dqSmall = new ArrayDeque<>();
    }

    private Map<Size, Deque<Locker>> preapareSizeBasedDeque() {
        return null;
    }

    public Locker allocateLockerToBox(Box box) {
        if (box.boxSize == Size.S) {
            Deque<Locker> lockers = sizeBasedLockers.get(box.boxSize);
            if (lockers.getFirst() == null) {
                lockers = sizeBasedLockers.get(Size.M);
                if (lockers.getFirst() == null) {
                    lockers = sizeBasedLockers.get(Size.L);
                    if (lockers.getFirst() == null) {
                        return null;
                    } else {
                        Locker l = lockers.getFirst();
                        lockers.removeFirst();
                        lockers.addLast(l);
                        return l;
                    }
                } else {
                    Locker l = lockers.getFirst();
                    lockers.removeFirst();
                    lockers.addLast(l);
                    return l;
                }
            } else {
                Locker l = lockers.getFirst();
                lockers.removeFirst();
                lockers.addLast(l);
                return l;
            }
        } else if (box.boxSize == Size.M) {
            Deque<Locker> lockers = sizeBasedLockers.get(box.boxSize);
            if (lockers.getFirst() == null) {
                lockers = sizeBasedLockers.get(Size.L);
                if (lockers.getFirst() == null) {
                    return null;
                }
            } else {
                Locker l = lockers.getFirst();
                lockers.removeFirst();
                lockers.addLast(l);
                return l;
            }

        }
        if (box.boxSize == Size.L) {
            Deque<Locker> lockers = sizeBasedLockers.get(box.boxSize);
            if (lockers.getFirst() == null) {
                return null;
            } else {
                Locker l = lockers.getFirst();
                lockers.removeFirst();
                lockers.addLast(l);
                return l;
            }
        }
        return null;
    }
}
