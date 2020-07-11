package com.xiaolee.algorithm;

import com.xiaolee.algorithm.LRU.LRUCache;
import org.junit.Test;

public class LRUCacheTest {
    @Test
    public void testOp() {
        LRUCache<String, Object> cache = new LRUCache<>(3);
        // <1,1>
        cache.put("1", "1");
        cache.print();

        // <2,2> <1,1>
        cache.put("2","2");
        cache.print();

        // <1,1> <2,2>
        cache.get("1");
        cache.print();

        // <3,3> <1,1> <2,2>
        cache.put("3", "3");
        cache.print();

        // <4,4> <3,3> <1,1>
        cache.put("4", "4");
        cache.print();
    }
}
