class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
        }
        for(int i = 0;i<k;i++){
            int a = pq.poll();
            pq.add(-(a));
        }
        int count = 0;
        while(!pq.isEmpty()){
          count += pq.poll();
        }
        return count;
    }
}