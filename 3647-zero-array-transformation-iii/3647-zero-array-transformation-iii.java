class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int q = queries.length;
        int n = nums.length;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        Arrays.sort(queries,(a,b)-> a[0] - b[0]);
        int j = 0;
        int usercount = 0;
        for(int i = 0;i < n;i++){
            while(j < q && queries[j][0] == i){
               maxheap.add(queries[j][1]);
               j++;
            }
            nums[i] -= minheap.size();
            while(nums[i] > 0 && !maxheap.isEmpty() && maxheap.peek() >= i){
                int ending = maxheap.poll();
                minheap.add(ending);
                usercount++;
                nums[i]--;
            }
            if(nums[i] > 0){
                return -1;
            }

            while(!minheap.isEmpty() && minheap.peek() <= i){
                minheap.poll();
            }
        }
        return q - usercount;
    }
}