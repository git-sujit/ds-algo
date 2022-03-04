package com.sks.leatcode.medium;

import java.util.HashMap;
import java.util.Map;
/**
 * IDEA: Map<Key, DoublyLinkedList>
 * - One advantage of double linked list is that the node can remove itself without other reference.
 * In addition, it takes constant time to add and remove nodes from the head or tail.
 * - Pseudo head and pseudo tail to mark the boundary, so that we don't need to check the null node during the update.
 */

/**
 * Time Complexity of get/put: O(1)
 * Space Complexity of get/put: O(capacity)
 */
public class LRUCacheBetter {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCacheBetter(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }

    public int get(int key) {
        System.out.println("get(" + key + ")");
        if (cache.containsKey(key)) {
            Node n = cache.get(key);
            removeNode(n);
            addToHead(n);
            return n.value;
        }
        return -1;
    }


    public void put(int key, int value) {
        System.out.println("put(" + key + "," + value + ")");
        Node n = null;
        if (cache.containsKey(key)) {
            n = cache.get(key);
            removeNode(n);
            n.value = value;
        } else {
            n = new Node(key, value);
            if (cache.size() == capacity) {
                Node rem = removeFromTail();
                cache.remove(rem.key);
            }
        }
        cache.put(key, n);
        addToHead(n);
    }

    private void addToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    private Node removeFromTail() {
        Node rem = tail.prev;
        rem.prev.next = tail;
        tail.prev = rem.prev;
        return rem;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + "," + value + ")";
        }
    }

    public String getLinkedList() {
        StringBuilder sb = new StringBuilder();
        Node node = head.next;
        while (node.next != null) {
            sb.append(node.key).append("->").append(node.value);
            node = node.next;
            if (node.next != null)
                sb.append(",");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCacheBetter lru = new LRUCacheBetter(2);
        lru.put(2, 1);
        printLRU(lru);
        lru.put(1, 1);
        printLRU(lru);
        lru.put(2, 3);
        printLRU(lru);
        lru.put(4, 1);
        printLRU(lru);
        System.out.println(lru.get(1));
        printLRU(lru);
        System.out.println(lru.get(2));
        printLRU(lru);
    }

    private static void printLRU(LRUCacheBetter lru) {
        System.out.println("Cache = " + lru.cache);
        System.out.println("Doubly Linked List = " + lru.getLinkedList());
    }
}
