class Solution {
    int[] parent, size;
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private void union(int x, int y, int[] count) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX == rootY) return;
        
        // merge smaller into larger
        if (size[rootX] < size[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }
        
        // remove old group counts
        count[size[rootX]]--;
        count[size[rootY]]--;
        
        parent[rootY] = rootX;
        size[rootX] += size[rootY];
        
        // add new merged group
        count[size[rootX]]++;
    }
    
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (n == m) return n;  // whole array is the group
        
        parent = new int[n + 2];
        size = new int[n + 2];
        boolean[] active = new boolean[n + 2];
        int[] count = new int[n + 1];
        
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        
        int res = -1;
        
        for (int step = 0; step < n; step++) {
            int pos = arr[step];
            active[pos] = true;
            parent[pos] = pos;
            size[pos] = 1;
            count[1]++;
            
            if (active[pos - 1]) {
                union(pos, pos - 1, count);
            }
            if (active[pos + 1]) {
                union(pos, pos + 1, count);
            }
            
            if (count[m] > 0) res = step + 1;
        }
        
        return res;
    }
}
