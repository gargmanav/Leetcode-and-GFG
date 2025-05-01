class Solution {
    private Map<String,Double> map = new HashMap<>();
    private final int[][] directions = {
        {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
        {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
    };
    public double knightProbability(int n, int k, int row, int column) {
        String key = row +","+ column +","+ k;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(row < 0 || row >= n || column < 0 || column >= n){
            return 0;
        }
        if(k == 0)return 1;
        double result = 0.0;
        for(int[] arr : directions){
            int nr = row + arr[0];
            int nc = column + arr[1];
            result += knightProbability(n,k - 1,nr,nc);
        }
        
        result /= 8.0;
        map.put(key, result);
        return result;
    }
}