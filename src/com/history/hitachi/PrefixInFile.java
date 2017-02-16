package com.history.hitachi;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Given a large file with lines of string - write a function to find if there
 * is a given prefix.
 * */
public class PrefixInFile {
    public static void main(String[] args) {
        final Tries trie = new Tries();
        trie.addString("apple");
        trie.addString("box");
        trie.addString("balls");
        trie.addString("apx");
        trie.addString("bank");
        trie.addString("ape");

        System.out.println("Size of trie: " + trie.size());
        String []testStrings = {"apples", "ape", "apes", "ball", "balls", "app", "zebra"};
        for (String test : testStrings) {
            System.out.println("DO we have String: " + test + ", " + trie.hasPrefix(test));
        }
    }

    private static class Tries {
        private final Node root = new Node(null);
        
        public void addString(String str) {
            if (str == null || str.isEmpty()) {
                return;
            }
            Node ptr = root;
            for (char c : str.toCharArray()) {
                if (!ptr.getChildren().containsKey(c)) {
                    ptr.getChildren().put(c, new Node(c));
                }
                ptr = ptr.getChildren().get(c);
            }
        }

        public boolean hasPrefix(String prefix) {
            Node ptr = root;
            for (char c : prefix.toCharArray()) {
                if (!ptr.getChildren().containsKey(c)) {
                    return false;
                }
                ptr = ptr.getChildren().get(c);
            }
            return true;
        }
        
        public int size() {
            return size(root) - 1;
        }
        
        private int size(Node root) {
            if (root == null) {
                return 0;
            }
            int count = 1;
            for (Entry<Character, Node> entry : root.getChildren().entrySet()) {
                count += size(entry.getValue());
            }
            return count;
        }
    }

    @AllArgsConstructor
    @Getter
    private static class Node {
        private final Character value;
        private final Map<Character, Node> children = new HashMap<Character, PrefixInFile.Node>();
    }
}
