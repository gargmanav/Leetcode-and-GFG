class KthLargest {
private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            add(num);  // reuse logic to maintain heap size
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);  // add the new value
        
        // Maintain the heap size to be at most k
        if (minHeap.size() > k) {
            minHeap.poll();  // remove the smallest
        }
        
        // The kth largest is the smallest in the min-heap
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */