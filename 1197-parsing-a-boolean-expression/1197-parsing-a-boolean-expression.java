class Solution {
    public boolean parseBoolExpr(String expression) {

        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',') continue;
            if (ch != ')') {
                stack.push(ch);
            } else {
                List<Character> temp = new ArrayList<>();
                while (stack.peek() != '(') {
                    temp.add(stack.pop());
                }

                stack.pop();      
                char operator = stack.pop();

                boolean result = evaluate(operator, temp);
                stack.push(result ? 't' : 'f');
            }
        }

        return stack.pop() == 't';
    }

    private boolean evaluate(char op, List<Character> temp) {
        if (op == '!') {
            return temp.get(0) == 'f';
        }

        if (op == '&') {
            for (char c : temp) {
                if (c == 'f') return false;
            }
            return true;
        }

        if (op == '|') {
            for (char c : temp) {
                if (c == 't') return true;
            }
            return false;
        }

        return false;
    }
}
