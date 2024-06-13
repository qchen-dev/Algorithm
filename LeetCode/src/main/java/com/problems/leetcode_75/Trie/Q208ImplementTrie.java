package com.problems.leetcode_75.Trie;

public class Q208ImplementTrie {

    // https://leetcode.com/problems/implement-trie-prefix-tree/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Trie trie = new Trie();

        // Example 1
        trie.insert("apple");
        boolean expected = true;
        boolean actual = trie.search("apple");
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        expected = false;
        actual = trie.search("app");
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        expected = true;
        actual = trie.startsWith("app");
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        trie.insert("app");
        actual = trie.search("app");
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Node {
        int pass;
        int end;
        Node[] paths;

        Node() {
            pass = 0;
            end = 0;
            paths = new Node[26];
        }
    }

    private static class Trie {

        private final Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            if (null == word) return;

            char[] chars = word.toCharArray();
            Node node = root;
            node.pass++;
            for (char chr : chars) {
                if (node.paths[chr - 'a'] == null) {
                    node.paths[chr - 'a'] = new Node();
                }
                node.paths[chr - 'a'].pass++;
                node = node.paths[chr - 'a'];
            }
            node.end++;
        }

        public boolean search(String word) {
            if (null == word) return false;

            char[] chars = word.toCharArray();
            Node node = root;

            for (char chr : chars) {
                if (node.paths[chr - 'a'] == null) {
                    return false;
                }
                node = node.paths[chr - 'a'];
            }
            return node.end > 0;
        }

        public boolean startsWith(String prefix) {
            if (null == prefix) return false;

            char[] chars = prefix.toCharArray();
            Node node = root;

            for (char chr : chars) {
                if (node.paths[chr - 'a'] == null) {
                    return false;
                }
                node = node.paths[chr - 'a'];
            }
            return node.pass > 0;
        }
    }

}
