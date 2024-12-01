class Solution {
    
    public static int solve(int i ,int j,int[] nums){
        if(i > j)return 0;

        int take1 = nums[i] + Math.min(solve(i+2,j,nums),solve(i+1,j-1,nums));
        int take2 = nums[j] + Math.min(solve(i+1,j-1,nums),solve(i,j-2,nums));

        return Math.max(take1,take2);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int totalscore = 0;
        for(int i : nums){
            totalscore += i;
        }
        int player1 = solve(0,n-1,nums);
        int player2 = totalscore - player1;
        return player1 >= player2;
    }
}