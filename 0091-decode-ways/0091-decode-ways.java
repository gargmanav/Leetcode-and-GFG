class Solution {
    
    private int decode(String s,int index,Map<Integer,Integer> memo){
        if(s.length() == index)return 1;
        if(s.charAt(index) == '0')return 0;
        if(memo.containsKey(index))return memo.get(index);

        int ways = decode(s,index + 1,memo);
        if(index < s.length() - 1){
            int num = Integer.parseInt(s.substring(index,index+2));
            if(num >= 10 && num <= 26){
                ways += decode(s,index + 2,memo);
            }
        }
        memo.put(index,ways);
        return ways;

    }
    public int numDecodings(String s) {
        Map<Integer,Integer> memo = new HashMap<>();
        return decode(s,0,memo);
    }
}