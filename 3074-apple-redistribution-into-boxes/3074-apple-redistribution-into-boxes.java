class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int i : apple){
            sum += i;
        }
        System.out.println("sumupper"+sum);
        Arrays.sort(capacity);
        int count = 0;
        int n = capacity.length;
        for(int i = n - 1;i >= 0;i--){
            if(sum <= 0){
                return count;
            }
            if(sum < i){
                count++;
                break;
            }
            sum -= capacity[i];
            System.out.println("sumdown"+sum);
            count++;
        }
        return count;
    }
}