class Solution {
    public long distributeCandies(int n, int limit) {
     // Use inclusion-exclusion principle
        // Total ways = all ways - (ways with at least 1 child > limit) 
        //            + (ways with at least 2 children > limit) 
        //            - (ways with all 3 children > limit)
        
        long total = combination(n + 2, 2);
        
        // Subtract cases where at least one child gets more than limit candies
        // If child 1 gets > limit, they get at least (limit + 1) candies
        // So we need to distribute (n - limit - 1) candies among 3 children
        long excess1 = 0;
        if (n > limit) {
            excess1 = 3 * combination(n - limit - 1 + 2, 2);
        }
        
        // Add back cases where at least two children get more than limit candies
        long excess2 = 0;
        if (n > 2 * limit) {
            excess2 = 3 * combination(n - 2 * limit - 2 + 2, 2);
        }
        
        // Subtract cases where all three children get more than limit candies
        long excess3 = 0;
        if (n > 3 * limit) {
            excess3 = combination(n - 3 * limit - 3 + 2, 2);
        }
        
        return total - excess1 + excess2 - excess3;
    }
    
    // Calculate combination C(n, k) = n! / (k! * (n-k)!)
    // For our case, we only need C(n, 2) = n * (n-1) / 2
    private long combination(int n, int k) {
        if (n < 0 || n < k) return 0;
        if (k == 2) {
            return (long) n * (n - 1) / 2;
        }
        return 0; // We only need C(n, 2) for this problem
    }
}