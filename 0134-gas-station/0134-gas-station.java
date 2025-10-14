class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalgas = 0;
        int totalcost = 0;
        for(int i = 0;i < n;i++){
            totalgas += gas[i];
            totalcost += cost[i];
        }
        if(totalcost > totalgas)return -1;
        int startindex = 0;
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum += gas[i] - cost[i];
            if(sum < 0){
                startindex = i + 1;
                sum = 0;
            }
        }
        return startindex;
    }
}