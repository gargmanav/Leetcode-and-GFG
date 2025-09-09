class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
    Stack<Integer> st = new Stack<>();
    long count = 0;
    for(int num : nums){
        while(!st.isEmpty() && st.peek() < num){
            st.pop();
            if(!st.isEmpty()){
              count++;
            }
        }
        if(st.isEmpty() || st.peek() != num){
         st.push(num);
        }
    }
    return count;
    }
}