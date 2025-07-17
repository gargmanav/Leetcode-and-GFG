class Solution {
    private void swap(int a,int b,int[] sarr){
        int temp = sarr[a];
        sarr[a] = sarr[b];
        sarr[b] = temp;
    }
    public long minimumSteps(String s) {
        long steps = 0;
        int[] arr = s.chars().map(c -> c - '0').toArray();
        int i = 0,j = 1;
        while(j < arr.length){
            if(arr[i] == 1 && arr[j] == 0){
                steps += j - i;
                swap(i,j,arr);
                i++;
                j++;
            }else{
                while(i < j && arr[i] != 1){
                    i++;
                }
                j++;
            }
        }
        return steps;
    }
}