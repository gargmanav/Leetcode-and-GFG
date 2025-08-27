import java.util.*;

class Solution {
    public long maxTotal(int[] value, int[] limit) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Pehle values ko unke limit ke bucket me daal do
        for (int i = 0; i < limit.length; i++) {
            map.putIfAbsent(limit[i], new ArrayList<>());
            map.get(limit[i]).add(value[i]);
        }

        long ans = 0;
        // Har ek bucket ke liye
        for (int currLimit : map.keySet()) {
            ArrayList<Integer> list = map.get(currLimit);

            // Sort descending order me
            Collections.sort(list, Collections.reverseOrder());

            // Sirf min(currLimit, list.size()) tak values lena
            for (int i = 0; i < Math.min(currLimit, list.size()); i++) {
                ans += list.get(i);
            }
        }
        return ans;
    }
}
