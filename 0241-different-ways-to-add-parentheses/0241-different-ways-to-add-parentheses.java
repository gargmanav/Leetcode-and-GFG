class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
    Map<String, List<Integer>> memo = new HashMap<>();
    return compute(expression, memo);
}

private List<Integer> compute(String input, Map<String, List<Integer>> memo) {
    if (memo.containsKey(input)) {
        return memo.get(input);
    }

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
        char ch = input.charAt(i);
        if (ch == '+' || ch == '-' || ch == '*') {
            String leftExpr = input.substring(0, i);
            String rightExpr = input.substring(i + 1);
            List<Integer> left = compute(leftExpr, memo);
            List<Integer> right = compute(rightExpr, memo);

            for (int l : left) {
                for (int r : right) {
                    int val = 0;
                    if (ch == '+') val = l + r;
                    else if (ch == '-') val = l - r;
                    else if (ch == '*') val = l * r;
                    result.add(val);
                }
            }
        }
    }

    // If result is still empty, input is a single number (e.g. "3")
    if (result.isEmpty()) {
        result.add(Integer.parseInt(input));
    }

    memo.put(input, result);
    return result;
}
}