class Solution {
    private int finddigitsum(int n){
        int sum = 0;
        while(n > 0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        Map<Integer,Integer> map = new HashMap<>();

        int count = 0;
        int maxsize = 0;
        for(int i = 1;i<=n;i++){
           int digitSum = finddigitsum(i);
           map.put(digitSum,map.getOrDefault(digitSum,0) + 1);
           if(map.get(digitSum) == maxsize){
            count++;
           }else if(map.get(digitSum) > maxsize){
            maxsize = map.get(digitSum);
            count = 1;
           }
        }
        return count;
    }
}