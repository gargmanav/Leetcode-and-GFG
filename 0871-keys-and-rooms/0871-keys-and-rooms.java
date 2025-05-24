class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        visited[0] = true;
        while(!que.isEmpty()){
            int index = que.poll();
            for(int num : rooms.get(index)){
                if(!visited[num]){
                    que.add(num);
                    visited[num] = true;
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(visited[i] == false){
                return false;
            }
        }
        return true;
    }
}