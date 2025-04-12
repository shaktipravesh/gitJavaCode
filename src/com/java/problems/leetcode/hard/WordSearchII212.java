package com.java.problems.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class WordSearchII212 {
    // Trie Node Definition
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Stores full word when it's the end
    }

    // Insert words into Trie
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word; // Mark the end of a word
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        // Start DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return; // Skip if visited or not in Trie

        node = node.children[c - 'a'];
        if (node.word != null) { // Found a word
            result.add(node.word);
            node.word = null; // Avoid duplicates
        }

        // Mark visited
        board[i][j] = '#';
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                dfs(board, x, y, node, result);
            }
        }
        board[i][j] = c; // Restore character

        // Optimization: Prune Trie nodes with no children
        if (node.children[c - 'a'] == null) {
            node = null;
        }
    }

    public static void main(String[] args) {
        WordSearchII212 solver = new WordSearchII212();

        char[][] board1 = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words1 = {"oath", "pea", "eat", "rain"};
        out.println(solver.findWords(board1, words1)); // Output: ["eat", "oath"]

        char[][] board2 = {
                {'a','b'},
                {'c','d'}
        };
        String[] words2 = {"abcb"};
        out.println(solver.findWords(board2, words2)); // Output: []
    }
}
