class Solution {
    int[] parent = new int[26];
    int[] rank = new int[26];
    public boolean equationsPossible(String[] equations) {
        
        for(int i = 0;i<26;i++){
           parent[i] = i;
           rank[i] = 1;
        }

        for(String str : equations){
            if(str.charAt(1) == '='){
                union(str.charAt(0) - 'a' , str.charAt(3) - 'a');
            }
        }

        for(String str : equations){
            if(str.charAt(1) == '!'){
                int parent_x = find(str.charAt(0) - 'a');
                int parent_y = find(str.charAt(3) - 'a');
                if(parent_x == parent_y){
                    return false;
                }
            }
        }
        return true;
    }
        private void union(int x,int y){
            int parent_x = find(x);
            int parent_y = find(y);
            if(parent_x == parent_y){
                return;
            }
            if(rank[parent_x] < rank[parent_y]){
                parent[parent_x] = parent_y;
            }else if(rank[parent_x] > rank[parent_y]){
                parent[parent_y] = parent_x;
            }else {parent[parent_x] = parent_y;
                  rank[parent_y] += 1;}       
        }
        private int find(int x){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }
    
}