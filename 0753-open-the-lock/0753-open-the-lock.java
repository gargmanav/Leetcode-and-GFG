import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) return -1;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process current level
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) return level;

                for (String neighbor : getNeighbors(current)) {
                    if (!deadSet.contains(neighbor) && !visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }

            level++;
        }

        return -1;
    }

    private List<String> getNeighbors(String code) {
        List<String> neighbors = new ArrayList<>();
        char[] arr = code.toCharArray();

        for (int i = 0; i < 4; i++) {
            char c = arr[i];

            // Turn wheel one step forward
            arr[i] = c == '9' ? '0' : (char)(c + 1);
            neighbors.add(new String(arr));

            // Turn wheel one step backward
            arr[i] = c == '0' ? '9' : (char)(c - 1);
            neighbors.add(new String(arr));

            // Reset to original for next digit
            arr[i] = c;
        }

        return neighbors;
    }
}
