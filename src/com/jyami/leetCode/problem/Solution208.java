package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/08/05
 */
public class Solution208 {

    /**
     * 제출시 아래 TrieNode를 선언한 코드도 같이 넣어야한다.
     */

    class Trie {

        /**
         * Initialize your data structure here.
         */
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char now = word.charAt(i);
                if (!node.containsKey(now)){
                    node.put(now, new TrieNode());
                }
                node = node.get(now);
            }
            node.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char now = word.charAt(i);
                if (node != null && node.containsKey(now)) {
                    node = node.get(now);
                } else {
                    return false;
                }
            }
            return node.isEnd();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char now = prefix.charAt(i);
                if (node != null && node.containsKey(now)) {
                    node = node.get(now);
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    void trie() {
        // ["Trie","insert","search","search","startsWith","insert","search"]
        //[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }


}
