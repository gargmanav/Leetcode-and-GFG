class Solution {
    public int maxDifference(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int maxEven = Integer.MAX_VALUE,maxOdd = Integer.MIN_VALUE;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(Integer value : map.values()){
            if(value % 2 == 0){
                maxEven = Math.min(value,maxEven);
            }
            else maxOdd = Math.max(value,maxOdd);
        }
        return maxOdd - maxEven;
    }
}