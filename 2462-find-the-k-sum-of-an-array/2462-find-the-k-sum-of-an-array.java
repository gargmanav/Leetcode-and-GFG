import java.util.*;

class Solution {
    public long kSum(int[] nums, int k) {
        long maxSum = 0;
        int n = nums.length;
        
        // Step 1: take positives for max sum, convert to absolute values
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) maxSum += nums[i];
            nums[i] = Math.abs(nums[i]);
        }
        
        // Step 2: sort absolute values
        Arrays.sort(nums);
        
        // Step 3: Min-heap for generating k smallest subset sums
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare((long)a[0], (long)b[0]));
        pq.offer(new long[]{nums[0], 0}); // {sum, index}
        
        long minSumK = 0;
        for (int count = 1; count < k; count++) {
            long[] curr = pq.poll();
            long sum = curr[0];
            int idx = (int) curr[1];
            minSumK = sum;
            
            if (idx + 1 < n) {
                // Case 1: include nums[idx+1] as well
                pq.offer(new long[]{sum + nums[idx + 1], idx + 1});
                // Case 2: replace nums[idx] with nums[idx+1]
                pq.offer(new long[]{sum - nums[idx] + nums[idx + 1], idx + 1});
            }
        }
        
        return maxSum - minSumK;
    }
}
