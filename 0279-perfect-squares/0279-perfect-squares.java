class Solution {
    public int numSquares(int n) {
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int level = 0;

        que.add(n);
        visited.add(n);
        while(!que.isEmpty()){
            level++;
            int size = que.size();
            for(int i = 0;i<size;i++){
               int temp = que.poll();
               for(int j = 1;j * j <= temp;j++){
                int next = temp - j * j;
                if(next == 0)return level;
                if(!visited.contains(next)){
                    que.add(next);
                    visited.add(next);
                }
               }
            }
          
        }
        return -1;
    }
}