class Solution {
    boolean checkTriangle(int[] nums){
        Arrays.sort(nums);
        return (nums[0] + nums[1] > nums[2]);
    }
    public String triangleType(int[] nums) {
        if(checkTriangle(nums)){
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num);
            }
            if(set.size() == 3)return "scalene";
            else if(set.size() == 2)return "isosceles";
            else return "equilateral";
        }else {
            return "none";
        }
    }
}