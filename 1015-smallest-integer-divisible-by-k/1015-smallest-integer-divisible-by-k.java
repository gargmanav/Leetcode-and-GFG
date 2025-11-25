class Solution {
    public int smallestRepunitDivByK(int k) {
        int value = 1;
        Set<Integer> set = new HashSet<>();
        int count = 1;
        while(value % k != 0){
          if(set.contains(value))return -1;
          set.add(value);
          value = (value * 10 + 1) % k;
          count++;
        }
        return count;
    }
}