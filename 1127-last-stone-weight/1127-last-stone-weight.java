class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones){
            pq.add(stone);
        }
        while(pq.size() >= 2){
           int a = pq.poll();
           int b = pq.poll();
           if(a == b)continue;
           else pq.add(a-b);
        }
        if(pq.isEmpty())return 0;
        return pq.poll();
    }
}