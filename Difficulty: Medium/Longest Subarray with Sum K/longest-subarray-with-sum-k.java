// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
       int prefixSum = 0;
       int maxlen = 0;
       Map<Integer,Integer> map = new HashMap<>();
       for(int i = 0;i < arr.length;i++){
           prefixSum += arr[i];
           if(prefixSum == k){
               maxlen = Math.max(maxlen,i + 1);
           }
           int curr = prefixSum - k;
           if(map.containsKey(curr)){
               maxlen = Math.max(maxlen,i - map.get(curr));
           }
                if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        
           
       }
       return maxlen;
    }
}
