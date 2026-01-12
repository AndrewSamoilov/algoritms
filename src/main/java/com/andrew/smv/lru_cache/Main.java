package com.andrew.smv.lru_cache;

import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {
        Cache lruCache = new Cache(4);

//        linkedList.addFirst(1);
//        linkedList.addFirst(2);
//        linkedList.addFirst(3);
//        linkedList.addFirst(4);
//        linkedList.addFirst(5);
//        linkedList.addFirst(6);
//        linkedList.addFirst(7);


//

        lruCache.add(1, 1);
        lruCache.add(1, 2);
        lruCache.add(1, 3);
        lruCache.add(1, 4);
        lruCache.add(5, 5);
        lruCache.add(6, 6);

//        lruCache.get(2);
        int t = 3;
    }
}
