class Solution {

    class DSU {
        int[] parent;
        
        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]); // Path compression
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) parent[px] = py;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();

        int id = 0;
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                emailToName.put(email, name);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }
            }
        }

        DSU dsu = new DSU(id);

        for (List<String> acc : accounts) {
            String firstEmail = acc.get(1);
            int firstId = emailToId.get(firstEmail);
            for (int i = 2; i < acc.size(); i++) {
                dsu.union(firstId, emailToId.get(acc.get(i)));
            }
        }

        // Grouping emails by parent
        Map<Integer, List<String>> merged = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int parentId = dsu.find(emailToId.get(email));
            merged.computeIfAbsent(parentId, x -> new ArrayList<>()).add(email);
        }

        // Building result
        List<List<String>> res = new ArrayList<>();
        for (List<String> group : merged.values()) {
            Collections.sort(group);
            String name = emailToName.get(group.get(0));
            group.add(0, name);
            res.add(group);
        }

        return res;
    }
}