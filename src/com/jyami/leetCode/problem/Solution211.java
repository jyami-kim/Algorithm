package com.jyami.leetCode.problem;


import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.ObjectReader;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by jyami on 2020/08/05
 */
public class Solution211 {
}

class TrieNode {
    private TrieNode[] link;

    private boolean isEnd;

    public TrieNode() {
        this.link = new TrieNode[26];
    }

    public TrieNode get(char c) {
        return link[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        link[c - 'a'] = node;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean containsKey(char ch) {
        return link[ch - 'a'] != null;
    }

    public List<TrieNode> getList() {
        return Arrays.stream(link)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}

class WordDictionary {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);
            if (!node.containsKey(now)) {
                node.put(now, new TrieNode());
            }
            node = node.get(now);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchDot(word, root, 0);
    }

    private boolean searchDot(String word, TrieNode root, int index) {
        TrieNode node = root;
        for (; index < word.length(); index++) {
            if (node == null)
                return false;
            char now = word.charAt(index);
            if (now == '.') {
                if (node.getList().size() == 0) {
                    return false;
                }
                List<TrieNode> list = node.getList();
                for (TrieNode t : list) {
                    if(searchDot(word, t, index + 1))
                        return true;
                }
                return false;
            } else {
                if (node.containsKey(now)) {
                    node = node.get(now);
                } else {
                    return false;
                }
            }
        }
        return node.isEnd();
    }

    @Test
    void pattern() {
        //["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        //[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//        WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
//        System.out.println(wordDictionary.search("pad"));
//        System.out.println(wordDictionary.search("bad"));
//        System.out.println(wordDictionary.search(".ad"));
//        System.out.println(wordDictionary.search("b.."));

        // ["WordDictionary","addWord","addWord","search","search","search","search","search","search"]
        //[[],["a"],["a"],["."],["a"],["aa"],["a"],[".a"],["a."]]

        System.out.println("=====");
        WordDictionary wordDictionary1 = new WordDictionary();
        wordDictionary1.addWord("at");
        wordDictionary1.addWord("and");
        wordDictionary1.addWord("an");
        wordDictionary1.addWord("add");
        System.out.println(wordDictionary1.search(".at"));
        wordDictionary1.addWord("bat");
        System.out.println(wordDictionary1.search(".at"));

    }
}
