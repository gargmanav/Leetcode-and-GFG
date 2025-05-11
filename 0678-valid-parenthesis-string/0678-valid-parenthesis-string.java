class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        // Step 1: Traverse the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openStack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else if (ch == ')') {
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        // Step 2: Match leftover '(' with '*' from the right
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            if (openStack.peek() > starStack.peek()) {
                return false; // '(' is after '*', invalid
            }
            openStack.pop();
            starStack.pop();
        }

        // If there are unmatched '(', invalid
        return openStack.isEmpty();
    }
}