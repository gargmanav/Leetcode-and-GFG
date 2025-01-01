class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        Stack<Character> st = new Stack<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                continue;
            }
            while(!st.isEmpty() && s.charAt(i) < st.peek() && i < map.get(st.peek())){
               char ch = st.pop();
               set.remove(ch);
            }
            st.push(s.charAt(i));
            set.add(s.charAt(i));

        }
        StringBuilder str = new StringBuilder();
        for(char i : st){
            str.append(i);
        }
        return str.toString();
    }

}