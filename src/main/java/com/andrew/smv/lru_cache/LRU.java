package com.andrew.smv.lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> {

    private int capacity;
    private Map<K, Node<V>> cache;
    private Node<V> first;
    private Node<V> last;


    public LRU(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }


    public void add(K key, V value) {

        if (cache.containsKey(key)){
            Node<V> node = cache.get(key);

            deleteNode(node);

            this.first.prev = node;





        }


        if (cache.size() < capacity){
            Node<V> node = new Node<>(value);
            addFirst(node);
            cache.put(key, node);
        }
    }

    private static class Node<V> {
        Node<V> prev;
        Node<V> next;
        V value;

        public Node(Node<V> prev, Node<V> next, V value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }

        public Node( V value) {
            this.value = value;
        }
    }

    public void addFirst(Node<V> value) {
        if (first == null && last == null) {
            value.prev = null;
            value.next = null;

            this.first = value;
            this.last = value;
        } else {
            Node<V> first = this.first;

            value.prev = null;
            value.next = first;

            this.first = value;
            first.prev = value;
        }
    }

    public void addFirst(V value) {
        if (first == null && last == null) {
            Node<V> first = new Node<>(null, null, value);
            this.first = first;
            this.last = first;
        } else {
            Node<V> first = this.first;
            Node<V> newNode = new Node<>(null, first, value);
            this.first = newNode;
            first.prev = newNode;
        }
    }


    public void deleteNode(Node<V> node) {
        if (node == null) {
            return;
        }

        if (node.next == null) {
            node.prev = null;
        }
        if (node.prev == null) {
            node.next = null;
        }

        Node<V> prev = node.prev;
        Node<V> next = node.next;

        prev.next = next;
        next.prev = prev;
    }
}
