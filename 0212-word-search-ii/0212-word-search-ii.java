class Solution {
    private int n, m;
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private Set<String> result = new HashSet<>();

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;  // store complete word at the end node
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                curr.children.putIfAbsent(ch, new TrieNode());
                curr = curr.children.get(ch);
            }
            curr.word = word;  // mark complete word
        }
        return root;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, boolean[][] visited) {
        char ch = board[i][j];
        TrieNode curr = node.children.get(ch);
        if (curr == null) return;

        if (curr.word != null) {
            result.add(curr.word);  // found a valid word
            curr.word = null;       // prevent duplicates
        }

        visited[i][j] = true;

        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[ni][nj]) {
                dfs(board, ni, nj, curr, visited);
            }
        }

        visited[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        n = board.length;
        m = board[0].length;

        TrieNode root = buildTrie(words);
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (root.children.containsKey(board[i][j])) {
                    dfs(board, i, j, root, visited);
                }
            }
        }

        return new ArrayList<>(result);
    }
}