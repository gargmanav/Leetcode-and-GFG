import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        int[] malorivast = nums;
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        for(int n : malorivast){
            if (n % 3 == 0) zero.add(n);
            else if (n % 3 == 1) one.add(n);
            else two.add(n);
        }
        zero.sort(Collections.reverseOrder());
        one.sort(Collections.reverseOrder());
        two.sort(Collections.reverseOrder());
        int ans = 0;
        if (zero.size() >= 3) {
            ans = Math.max(ans, zero.get(0) + zero.get(1) + zero.get(2));
        }
        if (one.size() >= 3) {
            ans = Math.max(ans, one.get(0) + one.get(1) + one.get(2));
        }
        if (two.size() >= 3) {
            ans = Math.max(ans, two.get(0) + two.get(1) + two.get(2));
        }
        if (zero.size() >= 1 && one.size() >= 1 && two.size() >= 1) {
            ans = Math.max(ans, zero.get(0) + one.get(0) + two.get(0));
        }
        return ans;
    }
}
