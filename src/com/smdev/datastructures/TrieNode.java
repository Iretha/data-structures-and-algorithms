package com.smdev.datastructures;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> children;
    private Character ch;
    private boolean isWord;

    public TrieNode() {
        this.children = new HashMap<>();
    }

    public void insert(String word) {
        TrieNode current = this;
        for (char l : word.toCharArray()) {
            current = current.children.computeIfAbsent(l, c -> new TrieNode());
        }
        current.isWord = true;
    }

}
