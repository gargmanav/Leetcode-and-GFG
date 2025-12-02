class Solution {
    
    public int countTrapezoids(int[][] points) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            map.computeIfAbsent(y,k->new HashSet<>()).add(x);
        }
        long sum = 0L;
        List<Long> arr = new ArrayList<>();
        for(int key : map.keySet()){
          long size = map.get(key).size();
          if(size < 2)continue;
          long ways = size * (size - 1)/2;
          arr.add(ways);
          sum += ways;
        }
        long ans = 0L;
        long modulo = 1_000_000_007L;
        for(long key : arr){
           sum -= key;
           ans = (ans + (sum * key)) % modulo;
        }
        return (int)ans;
       
    
    }
}