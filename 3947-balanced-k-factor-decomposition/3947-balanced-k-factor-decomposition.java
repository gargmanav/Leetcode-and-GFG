class Solution {
    public int[] minDifference(int n, int k) {
        int[] temp = new int[]{n,k};
        Map<String,List<List<Integer>>> memo = new HashMap<>();
        List<Integer> answer = null;
        int mingap = Integer.MAX_VALUE;

        for(List<Integer> way : helper(n,k,memo)){
            int max = Collections.max(way);
            int min = Collections.min(way);
            if(max - min < mingap){
                mingap = max - min;
                answer = way;
            }
        }
        int[] result = new int[answer.size()];
        for(int i = 0;i < answer.size();i++)result[i] = answer.get(i);
        return result;
    }
    private List<List<Integer>> helper(int n, int k, Map<String,   List<List<Integer>>> memo) {
       String key = n + "," + k;
        if (memo.containsKey(key)) return memo.get(key);

        List<List<Integer>> result = new ArrayList<>();
        if (k == 1) {
            if (n > 0) result.add(Arrays.asList(n));
            memo.put(key, result);
            return result;
        }
        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {
               for (List<Integer> next : helper(n / d, k - 1, memo)) {
                   List<Integer> split = new ArrayList<>();
                   split.add(d);
                    split.addAll(next);
                    result.add(split);
                }
            }
        }
       memo.put(key, result);
        return result;
    }
}