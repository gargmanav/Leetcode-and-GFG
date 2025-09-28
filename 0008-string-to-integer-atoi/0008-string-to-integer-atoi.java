class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        int n = s.length();
        while(i < n && s.charAt(i) == ' '){
            i++;
        }
        if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            if(s.charAt(i) == '-'){
               sign *= -1;
            }
           i++;
        }
        if(i < n && s.charAt(i) == '0'){
            i++;
        }
        int result = 0;
        while(i < n && Character.isDigit(s.charAt(i))){
           int curr = s.charAt(i) - '0';
           System.out.println(curr);
           if(result > (Integer.MAX_VALUE - curr)/10){
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
           }
           result = result * 10 + curr;
          
           i++;
        }
        return  sign * result;
    }
}