class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<List<Integer>> temp = new ArrayList<>();
        int i = 0,j = 0;
        int m = nums1.length;
        int n = nums2.length;
        while(i < m && j < n){
            if(nums1[i][0] == nums2[j][0]){
               List<Integer> pair = new ArrayList<>();
               pair.add(nums1[i][0]);
               pair.add(nums1[i][1] + nums2[j][1]);
               temp.add(pair);
               i++;
               j++;
            }else if(nums1[i][0] < nums2[j][0]){
                List<Integer> pair = new ArrayList<>();
                pair.add(nums1[i][0]);
                pair.add(nums1[i][1]);
                temp.add(pair);
                i++;
            }else{
                List<Integer> pair = new ArrayList<>();
                pair.add(nums2[j][0]);
                pair.add(nums2[j][1]);
                temp.add(pair);
                j++;
            }
        }
        while(i < m){
            List<Integer> pair = new ArrayList<>();
                pair.add(nums1[i][0]);
                pair.add(nums1[i][1]);
                temp.add(pair);
                i++;
        }
        while(j < n){
            List<Integer> pair = new ArrayList<>();
                pair.add(nums2[j][0]);
                pair.add(nums2[j][1]);
                temp.add(pair);
                j++;
        }
        int[][] result = new int[temp.size()][2];
        for(int k = 0;k < temp.size();k++){
            result[k][0] = temp.get(k).get(0);
            result[k][1] = temp.get(k).get(1);
        }
        return result;
    }
}