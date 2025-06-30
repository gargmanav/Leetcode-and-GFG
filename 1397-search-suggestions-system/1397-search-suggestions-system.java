import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // Step 1: Sort lexicographically
        List<List<String>> result = new ArrayList<>();
        String prefix = "";

        for (char c : searchWord.toCharArray()) {
            prefix += c;

            int start = lowerBound(products, prefix);
            List<String> suggestions = new ArrayList<>();

            for (int i = start; i < Math.min(start + 3, products.length); i++) {
                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]);
                } else {
                    break; // No need to check further
                }
            }

            result.add(suggestions);
        }

        return result;
    }

    // Custom binary search to find first word >= prefix
    private int lowerBound(String[] products, String prefix) {
        int low = 0, high = products.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (products[mid].compareTo(prefix) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
