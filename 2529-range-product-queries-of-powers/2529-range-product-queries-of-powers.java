class Solution {
    private int modulo = 1_000_000_007;
    public int[] productQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] result = new int[m];
        List<Integer> power = new ArrayList<>();
        for(int i = 0;i<32;i++){
            if(((n >> i) & 1) == 1){
                power.add(1 << i);
            }
        }
        int j = 0;
        for(int[] query : queries){
            long product = 1;
            for(int i = query[0];i <= query[1];i++){
               product = (product * power.get(i) % modulo);
            }
            result[j++] = (int) product;
        }
        return result;
    }
}