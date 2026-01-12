package com.andrew.smv.lru_cache;


import java.util.*;

public class LRUCache {

    private final int capacity;
    private Map<Integer, Node> cache;
    private Node last;
    private Node first;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    private static class Node {
        private Node next;
        private Node prev;
        private int value;

        public Node(Node next, int value, Node prev) {
            this.next = next;
            this.value = value;
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public int get(int key) {

        Node node = cache.get(key);


        return node.getValue();
    }

    public void put(int key, int value) {
        if (cache.size() < capacity) {
            Node node;
            if (first == null) {
                node = new Node(null, value, null);
                first = node;
                last = node;
            } else {
                node = new Node(first, value, null);
                first = node;
            }
            cache.put(key, node);
        } else {
            last = last.getPrev();
            Node next = first.getNext();
            first = new Node(next, value, null);
            cache.put(key, first);
        }
    }
}
