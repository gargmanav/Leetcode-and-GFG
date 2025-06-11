class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
         int n = reward1.length;

        // Step 1: Calculate total reward if all eaten by mouse 2
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += reward2[i];
        }

        // Step 2: Create an array of differences (reward1 - reward2)
        Integer[] gain = new Integer[n];
        for (int i = 0; i < n; i++) {
            gain[i] = reward1[i] - reward2[i];
        }

        // Step 3: Sort the gain array in descending order
        Arrays.sort(gain, (a, b) -> b - a);

        // Step 4: Pick top k gains and add to total
        for (int i = 0; i < k; i++) {
            total += gain[i];
        }

        return total;
    }
}