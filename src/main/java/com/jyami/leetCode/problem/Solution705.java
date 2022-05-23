package com.jyami.leetCode.problem;

import java.util.HashSet;

/**
 * Created by jyami on 2020/08/02
 */
public class Solution705 {

}

class MyHashSet {

    boolean[] hashSet = new boolean[0];

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        hashSet = new boolean[1000001];
    }

    public void add(int key) {
        hashSet[key] = true;
    }

    public void remove(int key) {
        hashSet[key] = false;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return hashSet[key];
    }
}
