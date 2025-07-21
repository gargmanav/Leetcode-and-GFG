class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        str.append(s.charAt(0));
        int count = 1;
        for(int i = 1;i < s.length();i++){
            if(s.charAt(i - 1) == s.charAt(i)){
                count++;
                if(count >= 3){
                    if(s.charAt(i - 1) == s.charAt(i))continue;
                    count = 1;
                }
                str.append(s.charAt(i));
                
            }else{
                str.append(s.charAt(i));
                count = 1;
            }
        }
        return str.toString();
    }
}