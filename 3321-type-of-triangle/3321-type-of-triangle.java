class Solution {
    boolean checkTriangle(int[] nums){
        if((nums[0] + nums[1]) <= nums[2])return false;
        else if((nums[0] + nums[2]) <= nums[1])return false;
        else if((nums[1] + nums[2]) <= nums[0])return false;
        return true;
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