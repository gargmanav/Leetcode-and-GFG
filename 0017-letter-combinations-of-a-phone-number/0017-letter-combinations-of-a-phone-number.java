class Solution {
    public void solve(int idx,String digits,HashMap<Character,String> map,StringBuilder temp,List<String> result){
        if(idx == digits.length()){
            result.add(temp.toString());
            return;
        }
        char ch = digits.charAt(idx);
        String str = map.get(ch);
        for(int i = 0;i<str.length();i++){
            temp.append(str.charAt(i));
            solve(idx+1,digits,map,temp,result);
            temp.deleteCharAt(temp.length() - 1);
        }

    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) { // Handle the edge case when digits is empty
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        StringBuilder temp = new StringBuilder();
        solve(0,digits,map,temp,result);
        return result;
        
    }
}