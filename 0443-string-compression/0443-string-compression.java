class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if(n < 2)return n;
        int read = 0,write = 0;
        while(read < n){
            char curr = chars[read];
            int count = 0;
            while(read < n && chars[read] == curr){
                count++;
                read++;
            }
            chars[write++] = curr;
            if(count > 1){
                for(char num : String.valueOf(count).toCharArray()){
                    chars[write++] = num;
                }
            }
        }
        return write;
    }
}