class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
    String word = null; // To store full word at end node
}

class Solution {
    private TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
        curr.word = word;
    }

    private List<String> getWordsWithPrefix(TrieNode node) {
        List<String> result = new ArrayList<>();
        dfs(node, result);
        return result;
    }

    private void dfs(TrieNode node, List<String> result) {
        if (node == null || result.size() == 3) return;
        if (node.isEnd) {
            result.add(node.word);
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                dfs(node.children[i], result);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products); // lexicographical order
        for (String word : products) {
            insert(word);
        }

        TrieNode curr = root;
        for (char ch : searchWord.toCharArray()) {
            int idx = ch - 'a';
            if (curr != null) {
                curr = curr.children[idx];
            }
            if (curr == null) {
                res.add(new ArrayList<>());
            } else {
                res.add(getWordsWithPrefix(curr));
            }
        }

        return res;
    }
}
