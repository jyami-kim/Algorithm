package com.jyami.leetCode.problem;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by jyami on 2020/08/05
 */
public class TrieNode {
    private TrieNode[] link;

    private boolean isEnd = false;

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