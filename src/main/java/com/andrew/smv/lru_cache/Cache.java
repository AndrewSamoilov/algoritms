package com.andrew.smv.lru_cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Cache {


    private Map<Integer, Node> cache;
    private Node first;
    private Node last;
    private final int capacity;


    public Cache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    public void add(int key, int value) { // O(1)

        boolean containsKey = cache.containsKey(key);

        LinkedList<Object> objects = new LinkedList<>();
        if (containsKey) {
            Node node = cache.get(key);

            Node prev = node.prev;
            Node next = node.next;


            if (prev != null) {
                prev.next = next.prev;
            }

            if (next != null) {
                next.prev = prev.next;
            }




            node.prev = null;
            node.next = first;

            this.first = node;

            cache.put(key, node);

            // | | - | | - | | - | |
        }


        if (cache.size() < capacity) {

            Node node;
            if (this.first != null) {
                node = new Node(null, this.first, value);

                Node f = this.first;
                f.prev = node;

                this.first = node;
            } else {
                node = new Node(null, null, value);
                this.first = node;
                this.last = node;
            }

            cache.put(key, node);
        }

    }


    private static class Node {
        private Node prev;
        private int val;
        private Node next;

        public Node(Node prev, Node next, int val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }

        public Node() {
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }


}
