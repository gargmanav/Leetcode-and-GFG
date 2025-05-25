class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();

        // Step 1: Insert each number into the Trie
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }

        int maxXor = 0;

        // Step 2: For each number, find the max XOR using the Trie
        for (int num : nums) {
            TrieNode node = root;
            int currentXor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int oppositeBit = 1 - bit;
                if (node.children[oppositeBit] != null) {
                    currentXor |= (1 << i);
                    node = node.children[oppositeBit];
                } else {
                    node = node.children[bit];
                }
            }
            maxXor = Math.max(maxXor, currentXor);
        }

        return maxXor;
    }
}